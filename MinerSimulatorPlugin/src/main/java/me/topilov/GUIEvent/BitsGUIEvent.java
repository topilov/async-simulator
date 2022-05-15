package me.topilov.GUIEvent;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BitsGUIEvent implements Listener {
    SQLGetter data = App.getInstance().data;

    @Deprecated
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        String playerBuyer = e.getWhoClicked().getName();
        Inventory inventory = e.getInventory();
        
        if (inventory.getTitle().equalsIgnoreCase("Магазин за Битсы")) {
            if (clicked == null) return;
            if (clicked.getItemMeta() == null) return;

            // LOCAL BOOSTER BALANCE

            if (e.getSlot() == 0 && clicked.getType() == Material.EMERALD) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addLocalBoosterBalance(player.getUniqueId(), 1);
                    data.addBoosterBalance(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeLocalBoosterBalance(player.getUniqueId(), 1);
                        data.removeBoosterBalance(player.getUniqueId(), 1);
                    }, 20 * 1800);

                    player.sendMessage(ChatColor.WHITE + "Локальный бустер " + ChatColor.GREEN + "х2 Денег " + ChatColor.GRAY + "добавлен к вашей статистике");
                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }

            // LOCAL BOOSTER EXP

            if (e.getSlot() == 1 && clicked.getType() == Material.EXPERIENCE_BOTTLE) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addLocalBoosterEXP(player.getUniqueId(), 1);
                    data.addBoosterEXP(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeLocalBoosterEXP(player.getUniqueId(), 1);
                        data.removeBoosterEXP(player.getUniqueId(), 1);
                    }, 20 * 1800);

                    player.sendMessage(ChatColor.WHITE + "Локальный бустер " + ChatColor.AQUA + "х2 Опыта " + ChatColor.GRAY + "добавлен к вашей статистике");
                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }

            // LOCAL BOOSTER BLOCKS

            if (e.getSlot() == 2 && clicked.getType() == Material.GRASS_BLOCK) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addLocalBoosterBlocks(player.getUniqueId(), 1);
                    data.addBoosterBlocks(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeLocalBoosterBlocks(player.getUniqueId(), 1);
                        data.removeBoosterBlocks(player.getUniqueId(), 1);
                    }, 20 * 1800);

                    player.sendMessage(ChatColor.WHITE + "Локальный бустер " + ChatColor.YELLOW + "х2 Блоков " + ChatColor.GRAY + "добавлен к вашей статистике");
                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }

            // LOCAL BOOSTER ARTEFACTS

            if (e.getSlot() == 3 && clicked.getType() == Material.GOLD_NUGGET) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addLocalBoosterArtefacts(player.getUniqueId(), 1);
                    data.addBoosterArtefacts(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeLocalBoosterArtefacts(player.getUniqueId(), 1);
                        data.removeBoosterArtefacts(player.getUniqueId(), 1);
                    }, 20 * 1800);

                    player.sendMessage(ChatColor.WHITE + "Локальный бустер " + ChatColor.GOLD + "х2 Артефактов " + ChatColor.GRAY + "добавлен к вашей статистике");
                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }

            // GLOBAL BOOSTER BALANCE

            if (e.getSlot() == 5 && clicked.getType() == Material.EMERALD) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterBalance(App.getInstance().getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        data.addBoosterBalance(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &aДенег х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeGlobalBoosterBalance(App.getInstance().getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (onlinePlayers.isOnline()) {
                                data.removeBoosterBalance(onlinePlayers.getUniqueId(), 1);
                            }
                        }
                    }, 20 * 1800);

                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }

            // GLOBAL BOOSTER EXP

            if (e.getSlot() == 6 && clicked.getType() == Material.EXPERIENCE_BOTTLE) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterEXP(App.getInstance().getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        data.addBoosterEXP(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &bОпыта х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeGlobalBoosterEXP(App.getInstance().getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (onlinePlayers.isOnline()) {
                                data.removeBoosterEXP(onlinePlayers.getUniqueId(), 1);
                            }
                        }
                    }, 20 * 1800);

                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }

            // GLOBAL BOOSTER BLOCKS

            if (e.getSlot() == 7 && clicked.getType() == Material.GRASS_BLOCK) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterBlocks(App.getInstance().getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        data.addBoosterBlocks(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &eБлоков х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeGlobalBoosterBlocks(App.getInstance().getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (onlinePlayers.isOnline()) {
                                data.removeBoosterBlocks(onlinePlayers.getUniqueId(), 1);
                            }
                        }
                    }, 20 * 1800);

                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }

            // GLOBAL BOOSTER ARTEFACTS

            if (e.getSlot() == 8 && clicked.getType() == Material.GOLD_NUGGET) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterArtefacts(App.getInstance().getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        data.addBoosterArtefacts(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &6Артефактов х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> {
                        data.removeGlobalBoosterArtefacts(App.getInstance().getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (onlinePlayers.isOnline()) {
                                data.removeBoosterArtefacts(onlinePlayers.getUniqueId(), 1);
                            }
                        }
                    }, 20 * 1800);

                    e.setCancelled(true);
                } else {
                    player.sendMessage(ChatColor.RED + "Недостаточно битсов для покупки");
                    e.setCancelled(true);
                }
            }
        }
    }
}
