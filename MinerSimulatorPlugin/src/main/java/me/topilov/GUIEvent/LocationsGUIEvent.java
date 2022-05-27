package me.topilov.GUIEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class LocationsGUIEvent implements Listener {

    @Deprecated
    @EventHandler
    public void onItemDrag(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();

        if (inventory.getTitle().contains("Локации")) {
            if (clicked == null) return;
            if (clicked.getType() == Material.GOLDEN_PICKAXE && e.getSlot() == 12) {
                player.chat("/locations 1");
                player.closeInventory();
            }
            if (clicked.getType() == Material.IRON_PICKAXE && e.getSlot() == 13) {
                player.chat("/locations 2");
                player.closeInventory();
            }
            if (clicked.getType() == Material.DIAMOND_PICKAXE) {
                player.chat("/locations 3");
                player.closeInventory();
            }
            if (clicked.getType() == Material.WOODEN_PICKAXE) {
                player.chat("/locations 4");
                player.closeInventory();
            }
            if (clicked.getType() == Material.STONE_PICKAXE) {
                player.chat("/locations 5");
                player.closeInventory();
            }
            if (clicked.getType() == Material.GOLDEN_PICKAXE && e.getSlot() == 23) {
                player.chat("/locations 6");
                player.closeInventory();
            }
            if (clicked.getType() == Material.IRON_PICKAXE && e.getSlot() == 24) {
                player.sendMessage("§cЛокация временно закрыта");
                player.closeInventory();
            }

        }
    }
}
