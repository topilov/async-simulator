package me.topilom.mainplugin.testClasses;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class GodBootsEvent implements Listener {

    @EventHandler
    public void onJump(PlayerMoveEvent e) {
        Player player = (Player) e.getPlayer();
        if (player.getInventory().getBoots() != null)
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Ботинки для прыжков"))
                if (player.getInventory().getBoots().getItemMeta().hasLore())
                    if (e.getFrom().getY() < e.getTo().getY() &&
                    player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
                        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                    }
    }

    @EventHandler
    public void onFall(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if (player.getInventory().getBoots() != null)
                    if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Ботинки для прыжков"))
                        if (player.getInventory().getBoots().getItemMeta().hasLore()) {
                            e.setCancelled(true);
                        }

            }
        }
    }
}
