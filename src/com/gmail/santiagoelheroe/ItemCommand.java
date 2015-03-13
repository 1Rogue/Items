package com.gmail.santiagoelheroe;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemCommand implements CommandExecutor {
  
private final Main plugin;
public ItemCommand(Main i) {
    plugin = i;
}
   
public ItemStack testItem() {
    Item ITEM = new Item("Espada de la destrucción");
         ITEM.addEnchant(Enchant.FIRE, 3);
         ITEM.setMinDamage(10);
         ITEM.setMaxDamage(15);
         ITEM.setQuality(Quality.LEGENDARY);
    return ITEM.createItem();
}


@Override
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if(cmd.getName().equalsIgnoreCase("item")) {
        if(!(sender instanceof Player)) { sender.sendMessage("Only runanble from in-game"); return true; }
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(ChatColor.DARK_RED + "Todavía no hay comando"); 
        } else {
            if(args[0].equalsIgnoreCase("qualitys")) {
                if(args[1].equalsIgnoreCase("getprefix")) {
                        if(Quality.getQualityByString(args[2]) != null) {
                            Quality quality = Quality.getQualityByString(args[2]);
                            player.sendMessage(Quality.getQualityPrefix(quality));
                            return true;
                    }
                }
            }
            if(args[0].equalsIgnoreCase("testitem")) {
                player.getInventory().setItem(0, testItem());
                player.updateInventory();
            }
        }
    }
    return false;
}
}
