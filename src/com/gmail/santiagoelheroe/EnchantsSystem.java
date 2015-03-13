package com.gmail.santiagoelheroe;

import java.util.Map.Entry;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnchantsSystem implements Listener{
       
private final Main plugin;
public EnchantsSystem(Main i) {
    plugin = i;
}
    
public Item getItemByName(String NAME) {
    for(String ITEM_NAME : Item.ITEMS.keySet()) {
    Item ITEM = Item.ITEMS.get(ITEM_NAME);
    String NAME_FORMAT = ChatColor.translateAlternateColorCodes('&', Quality.getQualityColor(ITEM.getQuality()) + ITEM.getName());
        if(NAME_FORMAT.equals(NAME)) {
            return ITEM;
        }
    }
    return null;
}
      
@EventHandler
public void onDamage(EntityDamageByEntityEvent event) {
    if(!(event.getDamager() instanceof Player)) { return; }
    Player player = (Player) event.getDamager();
    Entity entity = event.getEntity();
    if(!(entity instanceof LivingEntity)) { return; }
    if(player.getItemInHand() == null) { return; }
    if(!player.getItemInHand().getItemMeta().hasLore() || !player.getItemInHand().getItemMeta().hasLore()) { return; }
    ItemStack stack = player.getItemInHand();
       
    Item ITEM = getItemByName(stack.getItemMeta().getDisplayName());
    if(ITEM != null) {
        if(ITEM.getEnchants().isEmpty()) { return; }
        
        for(Entry<Enchant, Integer> ENTRY : ITEM.getEnchants().entrySet()) {
            Enchant ENCHANT = ENTRY.getKey();
            int LEVEL = ENTRY.getValue();
            if(ENCHANT == Enchant.FLY || ENCHANT == Enchant.SPEED || ENCHANT == Enchant.NO_FALL_DAMAGE || ENCHANT == Enchant.LIFE_REGENERATION) { continue; }
            double BASE_THING = Enchant.getEnchantBase(ENCHANT);
            double MULTIPLIED_THING = BASE_THING;
            if(LEVEL > 0) {
                MULTIPLIED_THING = BASE_THING * LEVEL;
            }
            if(ENCHANT == Enchant.FIRE) {
                fire(entity, MULTIPLIED_THING);
                continue;
            }
            if(ENCHANT == Enchant.POISON) {
                poison(entity, MULTIPLIED_THING);
            }
        }   
    } else { Bukkit.broadcastMessage("Null"); }
}
    
public void fire(Entity entity, double MULTIPLIED_THING) {
    entity.setFireTicks((int) MULTIPLIED_THING); 
}   
public void poison(Entity entity, double MULTIPLIED_THING) {
    int duration = (int) MULTIPLIED_THING / 20;
    PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, duration , 0);
    slowness.apply((LivingEntity) entity);
}
}
