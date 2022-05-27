package me.topilov.NPCs;

import me.topilov.App;
import net.minecraft.server.v1_13_R2.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class ClickNPC implements Listener {

    @EventHandler
    public void onClick(RightClickNPCEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GOLDEN_SWORD) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                EntityPlayer npc = e.getNPC();
                NPC.removeNPC(player, npc);
            }
        }
        if (e.getNPC().getName().contains("§e§lГайд")) {
            startGuide(e.getPlayer());
        }
        if (e.getNPC().getName().contains("§e§lУлучшить")) {
            e.getPlayer().chat("/upgrade");
        }
        for (int i = 1; i <= 6; i++) {
            if (e.getNPC().getName().contains("§e§lПродать " + i)) {
                e.getPlayer().chat("/sellall <" + i);
            }
        }
        /*if (e.getNPC().getName().contains("§e§lПродать 1")) {
            e.getPlayer().chat("/sellall <1");
        }
        if (e.getNPC().getName().contains("§e§lПродать 1")) {
            e.getPlayer().chat("/sellall <2");
        }
        if (e.getNPC().getName().contains("§e§lПродать 1")) {
            e.getPlayer().chat("/sellall <3");
        }*/
    }

    void startGuide(Player player) {
        player.teleport(new Location(Bukkit.getWorld("world"), 12.0, 135.0, 409.0, (float) 27.632, (float) 10.8));
        player.sendMessage("§eТвоя цель - копать и копать");
        Bukkit.getServer().getScheduler().runTaskLater(App.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                player.sendMessage("§bПовышая уровень ты сможешь перемещаться по локациям и получать больше монет за блок");
            }
        }, 40);
        Bukkit.getServer().getScheduler().runTaskLater(App.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                player.sendMessage("§bКогда достигнешь максимального уровня, тебе следует сделать перерождение");
            }
        }, 80);
        Bukkit.getServer().getScheduler().runTaskLater(App.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                player.sendMessage("§bПерерождение дает тебе приятные бонусы к твоему развитию");
            }
        }, 120);
        Bukkit.getServer().getScheduler().runTaskLater(App.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                player.teleport(new Location(Bukkit.getWorld("world"), -333.0, 103.0, 416.0, (float) 273.133, (float) 1.2));
                player.sendMessage("§bНа спавне есть кейсы, с помощью которых ты можешь обоготиться");
            }
        }, 160);
        Bukkit.getServer().getScheduler().runTaskLater(App.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                player.chat("/locations spawn");
                player.sendMessage("§aОсновные команды режима: /lvl /upgrade /locations /menu /bits");
                player.sendMessage("§bУдачи");
            }
        }, 200);
    }
}
