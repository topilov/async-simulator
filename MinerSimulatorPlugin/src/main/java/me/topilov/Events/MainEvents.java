package me.topilov.Events;

import me.topilov.NPCs.NPC;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class MainEvents implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§8[§ci§8]§f Вы не можете выкинуть этот предмет!  \n   Используйте§6 /мусорка§f, чтобы избавиться от предмета.");
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e) {
        if (!(e.getPlayer().getGameMode() == GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (!(e.getPlayer().getGameMode() == GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
            e.setCancelled(true);
    }

    @EventHandler
    public void onDamagePlayer(EntityDamageEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeathEvent(PlayerDeathEvent e) {
        e.setKeepInventory(true);
        e.setDeathMessage(null);
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        if (!(e.getPlayer().isOp())) {
            e.setCancelled(true);
        }
    }
}
