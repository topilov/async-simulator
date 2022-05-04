package me.topilom.mainplugin.GUIEvent;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;

public class BitsGUIEvent implements Listener {
    MainPlugin plugin;

    public BitsGUIEvent(MainPlugin plugin) {
        this.plugin = plugin;
    }

    public MySQL SQL;
    public SQLGetter data;

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(plugin);

        if (e.getInventory().getTitle().equalsIgnoreCase("Магазин за Битсы")) {
            if (e.getCurrentItem() == null) return;
            if (e.getCurrentItem().getItemMeta() == null) return;

            Player player = (Player) e.getWhoClicked();
            String playerBuyer = e.getWhoClicked().getName();

            // LOCAL BOOSTER BALANCE

            if (e.getSlot() == 0 && e.getCurrentItem().getType() == Material.EMERALD) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addLocalBoosterBalance(player.getUniqueId(), 1);
                    data.addBoosterBalance(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
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

            if (e.getSlot() == 1 && e.getCurrentItem().getType() == Material.EXPERIENCE_BOTTLE) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addLocalBoosterEXP(player.getUniqueId(), 1);
                    data.addBoosterEXP(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
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

            if (e.getSlot() == 2 && e.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addLocalBoosterBlocks(player.getUniqueId(), 1);
                    data.addBoosterBlocks(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
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

            if (e.getSlot() == 3 && e.getCurrentItem().getType() == Material.GOLD_NUGGET) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addLocalBoosterArtefacts(player.getUniqueId(), 1);
                    data.addBoosterArtefacts(player.getUniqueId(), 1);

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
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

            if (e.getSlot() == 5 && e.getCurrentItem().getType() == Material.EMERALD) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterBalance(plugin.getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

                        data.addBoosterBalance(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &aДенег х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        data.removeGlobalBoosterBalance(plugin.getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

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

            if (e.getSlot() == 6 && e.getCurrentItem().getType() == Material.EXPERIENCE_BOTTLE) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterEXP(plugin.getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
                        data.addBoosterEXP(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &bОпыта х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        data.removeGlobalBoosterEXP(plugin.getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

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

            if (e.getSlot() == 7 && e.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterBlocks(plugin.getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
                        data.addBoosterBlocks(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &eБлоков х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        data.removeGlobalBoosterBlocks(plugin.getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

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

            if (e.getSlot() == 8 && e.getCurrentItem().getType() == Material.GOLD_NUGGET) {
                int bits = data.getBits(player.getUniqueId());
                if (bits > 150 || bits == 150) {
                    data.addBits(player.getUniqueId(), -150);
                    data.addGlobalBoosterArtefacts(plugin.getName(), 1);

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
                        data.addBoosterArtefacts(onlinePlayers.getUniqueId(), 1);
                        onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fИгрок &a"
                                + playerBuyer +  " &fприобрел бустер &6Артефактов х2 &fна 30 минут"));
                    }

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        data.removeGlobalBoosterArtefacts(plugin.getName(), 1);

                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

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
