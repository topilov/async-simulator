package me.topilom.mainplugin.GUIEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LocationsGUIEvent implements Listener {
    @EventHandler
    public void onItemDrag(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();


        if (inventory.getTitle().contains("Локации")) {

            if (clicked.getType() == Material.SANDSTONE) {
                player.chat("/locations 1");
                player.closeInventory();
            }

            if (clicked.getType() == Material.STONE_SLAB) {
                player.chat("/locations 2");
                player.closeInventory();
            }

            if (clicked.getType() == Material.CRACKED_STONE_BRICKS) {
                player.chat("/locations 3");
                player.closeInventory();
            }

            if (clicked.getType() == Material.BROWN_TERRACOTTA) {
                player.chat("/locations 4");
                player.closeInventory();
            }

            if (clicked.getType() == Material.YELLOW_TERRACOTTA) {
                player.chat("/locations 5");
                player.closeInventory();
            }

            if (clicked.getType() == Material.QUARTZ_BLOCK) {
                player.chat("/locations 6");
                player.closeInventory();
            }

        }
    }
}
