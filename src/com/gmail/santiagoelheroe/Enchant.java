package com.gmail.santiagoelheroe;

import org.bukkit.ChatColor;


public enum Enchant {
    FIRE,
    ICE,
    POISON,
    SLOW,
    LIFE_STEAL,
    LIFE_REGENERATION,
    FLY,
    SPEED,
    NO_FALL_DAMAGE,
    DAMAGE_REDUCTION;
 
public static Enchant getEnchantByString(String ENCHANT) {
    if(ENCHANT.equalsIgnoreCase("fire")) {
        return FIRE;
    }
    if(ENCHANT.equalsIgnoreCase("ice")) {
        return ICE;
    }
    if(ENCHANT.equalsIgnoreCase("poison")) {
        return POISON;
    }
    if(ENCHANT.equalsIgnoreCase("slow")) {
        return SLOW;
    }
    if(ENCHANT.equalsIgnoreCase("lifesteal")) {
        return LIFE_STEAL;
    }
    if(ENCHANT.equalsIgnoreCase("liferegeneration")) {
        return LIFE_REGENERATION;
    }
    if(ENCHANT.equalsIgnoreCase("fly")) {
        return FLY;
    }
    if(ENCHANT.equalsIgnoreCase("speed")) {
        return SPEED;
    }
    if(ENCHANT.equalsIgnoreCase("nofalldamage")) {
        return NO_FALL_DAMAGE;
    }
    if(ENCHANT.equalsIgnoreCase("damagereduction")) {
        return DAMAGE_REDUCTION;
    }
    return null;
}
public static double getEnchantBase(Enchant ENCHANT) {
    if(ENCHANT == FIRE) {
        return 20;
    }
    if(ENCHANT == ICE) {
        return 20;
    }
    if(ENCHANT == POISON) {
        return 20;
    }
    if(ENCHANT == SLOW) {
        return 20;
    }
    if(ENCHANT == LIFE_STEAL) {
        return 0.1;
    }
    if(ENCHANT == LIFE_REGENERATION) {
        return 20;
    }
    if(ENCHANT == FLY) {
        return 0;
    }
    if(ENCHANT == SPEED) {
        return 0;
    }
    if(ENCHANT == NO_FALL_DAMAGE) {
        return 0;
    }
    if(ENCHANT == DAMAGE_REDUCTION) {
        return 0.1;
    }
    return 0;
}
public static String getEnchantFormat(Enchant ENCHANT, String LEVEL_ROMAN_FORMAT) {   
    String NAME = null;
    
    if(ENCHANT == FIRE) {
        NAME = ChatColor.RED + "Toque de Fuego";
    }
    if(ENCHANT == ICE) {
        NAME = ChatColor.AQUA + "Toque de Hielo";
    }
    if(ENCHANT == POISON) {
        NAME = ChatColor.DARK_GREEN + "Veneno";
    }
    if(ENCHANT == SLOW) {
        NAME = ChatColor.YELLOW + "Realentización";
    }
    if(ENCHANT == LIFE_STEAL) {
        NAME = ChatColor.DARK_RED + "Robo de Vida";
    }
    if(ENCHANT == LIFE_REGENERATION) {
        NAME = ChatColor.LIGHT_PURPLE + "Regeneración";
    }
    if(ENCHANT == FLY) {
        NAME = ChatColor.AQUA + "Vuelo";
    }
    if(ENCHANT == SPEED) {
        NAME = ChatColor.AQUA + "Velocidad";
    }
    if(ENCHANT == NO_FALL_DAMAGE) {
        NAME = ChatColor.AQUA + "Peso Pluma";
    }
    if(ENCHANT == DAMAGE_REDUCTION) {
        NAME = ChatColor.GREEN + "Reducción de Daño";
    }
    return NAME + " " + LEVEL_ROMAN_FORMAT;
}
}
