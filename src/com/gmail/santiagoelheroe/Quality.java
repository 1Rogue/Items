package com.gmail.santiagoelheroe;

import org.bukkit.ChatColor;

public enum Quality {
    NORMAL,
    UNIQUE,
    RARE,
    SPECIAL,
    LEGENDARY;
    
    public static ChatColor getQualityColor(Quality QUALITY) {
        if(QUALITY == NORMAL) {
            return ChatColor.WHITE;
        }
        if(QUALITY == UNIQUE) {
            return ChatColor.YELLOW;
        }
        if(QUALITY == RARE) {
            return ChatColor.LIGHT_PURPLE;
        }
        if(QUALITY == SPECIAL) {
            return ChatColor.DARK_AQUA;
        }
        if(QUALITY == LEGENDARY) {
            return ChatColor.AQUA;
        }
        return null;
    }
    public static String getQualityPrefix(Quality QUALITY) {
        String NAME = null;
        if(QUALITY == NORMAL) {
            NAME = "Item Normal";
        }
        if(QUALITY == UNIQUE) {
            NAME = "Item Unico";
        }
        if(QUALITY == RARE) {
            NAME = "Item Raro";
        }
        if(QUALITY == SPECIAL) {
            NAME = "Item Special";
        }
        if(QUALITY == LEGENDARY) {
            NAME = "Item Legendario";
        }
        return ChatColor.GRAY + "[" + getQualityColor(QUALITY) + NAME + ChatColor.GRAY + "]";
    }
    public static Quality getQualityByString(String QUALITY) {
        if(QUALITY.equalsIgnoreCase("normal")) {
            return NORMAL;
        }
        if(QUALITY.equalsIgnoreCase("unique")) {
            return UNIQUE;
        }
        if(QUALITY.equalsIgnoreCase("rare")) {
            return RARE;
        }
        if(QUALITY.equalsIgnoreCase("special")) {
            return SPECIAL;
        }
        if(QUALITY.equalsIgnoreCase("legendary")) {
            return LEGENDARY;
        }
        return null;
    }
}
