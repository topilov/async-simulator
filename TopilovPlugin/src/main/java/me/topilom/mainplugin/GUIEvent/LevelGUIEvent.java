package me.topilom.mainplugin.GUIEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LevelGUIEvent implements Listener {
    @EventHandler
    public void OnItemDrag(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();


        if (inventory.getTitle().contains("Повышение уровня")) {

            if (clicked.getType() == Material.EXPERIENCE_BOTTLE) {
                player.chat("/level up");
                player.closeInventory();
            }
        }
    }
}
