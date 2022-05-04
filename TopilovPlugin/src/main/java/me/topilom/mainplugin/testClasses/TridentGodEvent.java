package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class TridentGodEvent implements Listener {
    public List<String> list = new ArrayList<String>();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.TRIDENT))
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                Player player = (Player) e.getPlayer();
                //Right click
                if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                    if (!list.contains((player.getName())))
                        list.add(player.getName());
                    return;
                }

                //Left click
                if (e.getAction() == Action.LEFT_CLICK_AIR) {
                    player.launchProjectile(Fireball.class);
                }
            }
        if (list.contains(e.getPlayer().getName())) {
            list.remove(e.getPlayer().getName());
        }
    }

    @EventHandler
    public void onLand(ProjectileHitEvent e) {
        if (e.getEntityType() == EntityType.TRIDENT) {
            if (e.getEntity().getShooter() instanceof  Player) {
                Player player = (Player) e.getEntity().getShooter();
                if (list.contains(player.getName())) {
                    //spawn zombies
                    Location loc = e.getEntity().getLocation();
                    loc.setY(loc.getY() + 1);

                    for (int i = 1; i < 4; i++) {
                        Creeper creeper = (Creeper) loc.getWorld().spawnEntity(loc, EntityType.CREEPER);
                        creeper.setPowered(true);
                        loc.setX(loc.getX() + i);
                    }
                }
            }
        }
    }
}
