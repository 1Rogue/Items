package com.gmail.santiagoelheroe;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    
    
@Override
public void onEnable() {
    getCommand("item").setExecutor(new ItemCommand(this));
    Bukkit.getServer().getPluginManager().registerEvents(new EnchantsSystem(this), this);
}
    
}
