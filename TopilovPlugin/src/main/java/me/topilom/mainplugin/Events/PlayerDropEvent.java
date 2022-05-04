package me.topilom.mainplugin.Events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropEvent implements Listener {

    @EventHandler
    public void handle(PlayerDropItemEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE)
            e.setCancelled(true);
    }

}
