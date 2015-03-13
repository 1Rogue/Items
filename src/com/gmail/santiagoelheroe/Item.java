package com.gmail.santiagoelheroe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
    
public static Map<String, Item> ITEMS = new HashMap();
    
private String NAME;
private int QUANTITY;
private int MIN_DAMAGE;
private int MAX_DAMAGE;
private Material MATERIAL;
private Quality QUALITY;
private Map<Enchant, Integer> ENCHANTS = new HashMap<>(); 

public Item(String NAME) {
    this.NAME = NAME;
    this.QUANTITY = 1;
    this.MIN_DAMAGE = 0;
    this.MAX_DAMAGE = 0;  
    this.MATERIAL = Material.WOOD_SWORD;
    this.QUALITY = Quality.NORMAL;
    this.ITEMS.put(NAME, this);
}

public String getName() {
    return this.NAME;
}
public void setName(String NAME) {
    this.NAME = NAME;
}
public int getQuantity() {
    return this.QUANTITY;
}
public void setQuantity(int QUANTITY) {
    this.QUANTITY = QUANTITY;
}
public int getMinDamage() {
    return this.MIN_DAMAGE;
}
public void setMinDamage(int MIN_DAMAGE) {
    this.MIN_DAMAGE = MIN_DAMAGE;
}
public int getMaxDamage() {
    return this.MAX_DAMAGE;
}
public void setMaxDamage(int MAX_DAMAGE) {
    this.MAX_DAMAGE = MAX_DAMAGE;
}
public Material getMaterial() {
    return this.MATERIAL;
}
public void setMaterial(Material MATERIAL) {
    this.MATERIAL = MATERIAL;
}
public Quality getQuality() {
    return this.QUALITY;
}
public void setQuality(Quality QUALITY) {
    this.QUALITY = QUALITY;
}
public Map<Enchant, Integer> getEnchants() {
    return this.ENCHANTS;
}
public void addEnchant(Enchant ENCHANT, int LEVEL) {
    this.ENCHANTS.put(ENCHANT, LEVEL);
}
public void setEnchants(Map<Enchant, Integer> ENCHANTS) {
    this.ENCHANTS = ENCHANTS;
}
public void removeEnchant(Enchant ENCHANT) {
    this.ENCHANTS.remove(ENCHANT);
}
public boolean checkEnchant(Enchant ENCHANT) {
    return this.ENCHANTS.containsKey(ENCHANT);
}
public void cleanEnchants() {
    this.ENCHANTS.clear();
}
public ItemStack createItem() {
    ItemStack stack = new ItemStack(MATERIAL, QUANTITY);
    ItemMeta meta = stack.getItemMeta();
    
String NAME_FORMAT = ChatColor.translateAlternateColorCodes('&', Quality.getQualityColor(QUALITY) + NAME);
             meta.setDisplayName(NAME_FORMAT);
             
    List<String> LORE = new ArrayList<>();     
    String DAMAGE_FORMAT = ChatColor.GRAY + "Daño : " + ChatColor.YELLOW + MIN_DAMAGE + ChatColor.GRAY + " - " + ChatColor.RED + MAX_DAMAGE;  
    LORE.add(DAMAGE_FORMAT);
    
    for(Entry<Enchant, Integer> ENTRY : ENCHANTS.entrySet()) {

        Enchant ENCHANT = ENTRY.getKey();
        int LEVEL = ENTRY.getValue();     
        RomanNumeral LEVEL_ROMAN_FORMAT = new RomanNumeral(LEVEL);    

        String ENCHANT_FORMAT = Enchant.getEnchantFormat(ENCHANT, LEVEL_ROMAN_FORMAT.toString());
        LORE.add(ENCHANT_FORMAT);
   
    }     
    
    String QUALITY_FORMAT = Quality.getQualityPrefix(QUALITY);
    LORE.add(QUALITY_FORMAT);
    
             meta.setLore(LORE);

    stack.setItemMeta(meta);
    return stack;
}
}
