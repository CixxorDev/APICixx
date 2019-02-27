package be.cixxor.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

    public void createInventory(Player player,int size, String name){
        Bukkit.createInventory(player,size,name);
    }
    public void closeInventory(Player player){ player.closeInventory();}
    public void openInventory(Player player, Inventory inventory) {
        player.openInventory(inventory);
    }
    public void addInventoryItem(Player player, ItemStack itemStack){ player.getInventory().addItem(itemStack); }
    public void removeItem(Player player, ItemStack itemStack){
        player.getInventory().removeItem(itemStack);
    }
    public void clearInventory(Player player){ player.getInventory().clear(); }
    public void give(Player player, ItemStack itemStack){player.getInventory().addItem(itemStack);}
}
