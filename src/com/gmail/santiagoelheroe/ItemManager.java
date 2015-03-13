package com.gmail.santiagoelheroe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ItemManager {
   
public Map<UUID, Item> selections = new HashMap<>();

//---------------- UUID ----------------\\
public UUID u(Player player) {
    return player.getUniqueId();
}
//---------------- Create Item ----------------\\
public void createItem(UUID uuid, String NAME) {
    setSelection(uuid, new Item(NAME));
}
public boolean checkItemName(String NAME) {
    return Item.ITEMS.containsKey(NAME);
}
public Item getItemByName(String NAME) {
    if(checkItemName(NAME)) {
        return Item.ITEMS.get(NAME);
    } else return null;
}
//---------------- Selection ----------------\\
public Item getSelection(UUID uuid) {
    return selections.get(uuid);
}
public void setSelection(UUID uuid, Item ITEM) {
    selections.put(uuid, ITEM);
}
public void removeSelection(UUID uuid) {
    if(hasSelection(uuid)) {
        selections.remove(uuid);
    }
}
public boolean hasSelection(UUID uuid) {
    return selections.containsKey(uuid);
}
//---------------- Name Selection ----------------\\
public void setSelection(UUID uuid, String NAME) {
    if(checkItemName(NAME)) {
        setSelection(uuid, getItemByName(NAME));
    }
}
//---------------- ItemManager Stuff ----------------\\
public String getName(UUID uuid) {
    if(hasSelection(uuid)) {
        return getSelection(uuid).getName();
    } else return null;
}
public void setName(UUID uuid, String NAME) {
    if(hasSelection(uuid)) {
        Item ITEM = getSelection(uuid);
             ITEM.setName(NAME);
        setSelection(uuid, ITEM);
    }
}
public int getQuantity(UUID uuid) {
    if(hasSelection(uuid)) {
        return getSelection(uuid).getQuantity();
    } else return 0;
}
public void setQuantity(UUID uuid, int QUANTITY) {
    if(hasSelection(uuid)) {
        Item ITEM = getSelection(uuid);
             ITEM.setQuantity(QUANTITY);
        setSelection(uuid, ITEM);
    }
}
public Material getMaterual(UUID uuid) {
    if(hasSelection(uuid)) {
        return getSelection(uuid).getMaterial();   
    } else return null;
}
public void setMaterial(UUID uuid, Material MATERIAL) {
    if(hasSelection(uuid)) {
        Item ITEM = getSelection(uuid);
             ITEM.setMaterial(MATERIAL);
        setSelection(uuid, ITEM);
    }
}
public Quality getQuality(UUID uuid) {
    if(hasSelection(uuid)) {
        return getSelection(uuid).getQuality();
    } else return null;
}
public void setQuality(UUID uuid, Quality QUALITY) {
    if(hasSelection(uuid)) {
        Item ITEM = getSelection(uuid);
             ITEM.setQuality(QUALITY);
        setSelection(uuid, ITEM);
    }
}
public boolean isEnchant(String ENCHANT) {
    for(Enchant enchant : Enchant.values()) {
        return enchant.name().equals(ENCHANT);
    } 
    return false;
}
public void addEnchant(UUID uuid, String ENCHANT, Integer LEVEL) {
    if(hasSelection(uuid) && isEnchant(ENCHANT)) {
        if(LEVEL <= 0) { LEVEL = 1; }
        Item ITEM = getSelection(uuid);
             ITEM.addEnchant(Enchant.getEnchantByString(ENCHANT), LEVEL);
        setSelection(uuid, ITEM);
    }
}
public void removeEnchant(UUID uuid, String ENCHANT) {
    if(hasSelection(uuid) && isEnchant(ENCHANT)) {
        Item ITEM = getSelection(uuid);
             ITEM.removeEnchant(Enchant.getEnchantByString(ENCHANT));
        setSelection(uuid, ITEM);
    }
}
public void setEnchants(UUID uuid, Map<Enchant, Integer> ENCHANTS) {
    if(hasSelection(uuid)) {
        Item ITEM = getSelection(uuid);
             ITEM.setEnchants(ENCHANTS);
        setSelection(uuid, ITEM);
    }
}
public void clearEnchants(UUID uuid) {
    if(hasSelection(uuid)) {
        Item ITEM = getSelection(uuid);
             ITEM.cleanEnchants();
        setSelection(uuid, ITEM);
    }
}

}
