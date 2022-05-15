package me.topilov.Events;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CaseInteractEvent implements Listener {
    private final Economy economy = App.economy;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        SQLGetter data = App.getInstance().data;
        Player player = e.getPlayer();
        int amount = player.getInventory().getItemInMainHand().getAmount();

        if (e.getClickedBlock() == null) {
            return;
        }
        if (e.getClickedBlock().getType() == Material.ENDER_CHEST) {
            if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR
                    || !e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Ключ от Ящика с Разным")
                    && !e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Ключ от Ящика с Питомцами")) {
                player.sendMessage(ChatColor.RED + "Нужно держать ключ в руках");
                e.setCancelled(true);
                return;
            }

            // CASE WITH ANOTHER

            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Ключ от Ящика с Разным")) {
                if (e.getAction() == Action.LEFT_CLICK_AIR) {
                    e.setCancelled(true);
                }

                player.getInventory().getItemInMainHand().setAmount(amount - 1);

                int random = (int) (Math.random() * 25) + 1;
                switch (random) {
                    case 1:

                    case 2:

                    case 3:

                    case 4:

                    case 5:

                    case 6: {
                        economy.depositPlayer(player, 1000);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.GREEN + "1000$");
                        e.setCancelled(true);
                        break;
                    }

                    case 7:

                    case 8:

                    case 9:

                    case 10: {
                        economy.depositPlayer(player, 2500);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.GREEN + "2500$");
                        e.setCancelled(true);
                        break;
                    }

                    case 11:

                    case 12:

                    case 13: {
                        economy.depositPlayer(player, 5000);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.GREEN + "5000$");
                        e.setCancelled(true);
                        break;
                    }

                    case 14:

                    case 15:

                    case 16: {
                        data.addExp(player.getUniqueId(), 5000);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.AQUA + "5000 Опыта");
                        e.setCancelled(true);
                        break;
                    }

                    case 17:

                    case 18:

                    case 19: {
                        data.addArtefacts(player.getUniqueId(), 100);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.GOLD + "100 Артефактов");
                        e.setCancelled(true);
                        break;
                    }

                    case 20:

                    case 21: {
                        data.addLocalBoosterBlocks(player.getUniqueId(), 1);
                        data.addBoosterBlocks(player.getUniqueId(), 1);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.YELLOW + "Бустер Блоков х2");

                        Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                            data.removeLocalBoosterBlocks(player.getUniqueId(), 1);
                            data.removeBoosterBlocks(player.getUniqueId(), 1);
                        }, 20 * 1800);

                        e.setCancelled(true);
                        break;
                    }

                    case 22:

                    case 23: {
                        data.addLocalBoosterArtefacts(player.getUniqueId(), 1);
                        data.addBoosterArtefacts(player.getUniqueId(), 1);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.GOLD + "Бустер Артефактов х2");

                        Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                            data.removeLocalBoosterArtefacts(player.getUniqueId(), 1);
                            data.removeBoosterArtefacts(player.getUniqueId(), 1);
                        }, 20 * 1800);

                        e.setCancelled(true);
                        break;
                    }

                    case 24: {
                        data.addLocalBoosterEXP(player.getUniqueId(), 1);
                        data.addBoosterEXP(player.getUniqueId(), 1);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.AQUA + "Бустер Опыта х2");

                        Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                            data.removeLocalBoosterEXP(player.getUniqueId(), 1);
                            data.removeBoosterEXP(player.getUniqueId(), 1);
                        }, 20 * 1800);

                        e.setCancelled(true);
                        break;
                    }

                    case 25: {
                        data.addLocalBoosterBalance(player.getUniqueId(), 1);
                        data.addBoosterBalance(player.getUniqueId(), 1);
                        player.sendMessage(ChatColor.WHITE + "Тебе выпало " + ChatColor.GREEN + "Бустер Денег х2");

                        Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                            data.removeLocalBoosterBalance(player.getUniqueId(), 1);
                            data.removeBoosterBalance(player.getUniqueId(), 1);
                        }, 20 * 1800);

                        e.setCancelled(true);
                        break;
                    }
                }
            }

            // CASE WITH PETS

            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Ключ от Ящика с Питомцами")) {
                if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    e.setCancelled(true);
                }

                player.getInventory().getItemInMainHand().setAmount(amount - 1);

                int random = (int) (Math.random() * 6) + 1;
                switch (random) {
                    case 1: {
                        player.sendMessage(ChatColor.WHITE + "Тебе выпал питомец 1");
                        e.setCancelled(true);
                        break;
                    }

                    case 2: {
                        player.sendMessage(ChatColor.WHITE + "Тебе выпал питомец 2");
                        e.setCancelled(true);
                        break;
                    }

                    case 3: {
                        player.sendMessage(ChatColor.WHITE + "Тебе выпал питомец 3");
                        e.setCancelled(true);
                        break;
                    }

                    case 4: {
                        player.sendMessage(ChatColor.WHITE + "Тебе выпал питомец 4");
                        e.setCancelled(true);
                        break;
                    }

                    case 5: {
                        player.sendMessage(ChatColor.WHITE + "Тебе выпал питомец 5");
                        e.setCancelled(true);
                        break;
                    }

                    case 6: {
                        player.sendMessage(ChatColor.WHITE + "Тебе выпал питомец 6");
                        e.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }
}
