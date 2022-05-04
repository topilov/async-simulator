package me.topilom.mainplugin.testClasses;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GambleGUIEvent implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getTitle().contains("Вращение рулетки")) {
            e.setCancelled(true);
            return;
        }
    }
}
