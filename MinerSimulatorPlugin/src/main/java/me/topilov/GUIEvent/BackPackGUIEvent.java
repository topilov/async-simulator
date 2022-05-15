package me.topilov.GUIEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BackPackGUIEvent implements Listener {

    @Deprecated
    @EventHandler
    public void onItemDrag(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();

        if(inventory.getTitle().contains("Улучшение рюкзака")) {
            if (clicked == null) return;
            if (clicked.getType() == Material.CHEST) {
                player.chat("/bp upgrade");
                player.closeInventory();
            } else {
                player.sendMessage("произошло исключение");
            }
        }
    }
}
