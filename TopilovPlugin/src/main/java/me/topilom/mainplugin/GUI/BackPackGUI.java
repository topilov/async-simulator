package me.topilom.mainplugin.GUI;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BackPackGUI implements CommandExecutor {

    private final Economy economy = MainPlugin.economy;

    MainPlugin main;

    public BackPackGUI(MainPlugin main) {
        this.main = main;
    }

    public MySQL SQL;
    public SQLGetter data;

    public ItemStack backpackItem = new ItemStack(Material.CHEST);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(main);

        if (cmd.getName().equalsIgnoreCase("bp")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
            Player player = (Player) sender;

            int bp = data.getBackPack(player.getUniqueId());
            int balance = (int) economy.getBalance(player);

            if (args.length == 0) {
                Inventory backpack = Bukkit.getServer().createInventory(null, 9, "Улучшение рюкзака");

                ArrayList<String> lore = new ArrayList<String>();


                ItemMeta metaref = backpackItem.getItemMeta();

                if (bp == 50) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 500) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/500");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/500");
                    }
                }

                if (bp == 100) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 1000) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/1000");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/1000");
                    }
                }

                if (bp == 500) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 2000) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/2000");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/2000");
                    }
                }

                if (bp == 1000) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 3000) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/3000");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/3000");
                    }
                }

                if (bp == 2000) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 5000) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/5000");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/5000");
                    }
                }

                if (bp == 5000) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 15000) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/15000");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/15000");
                    }
                }

                if (bp == 10000) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 30000) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/30000");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/30000");
                    }
                }

                if (bp == 20000) {
                    lore.add("");
                    lore.add("§7Улучшайте вместимость и вы сможете");
                    lore.add("§7держать больше блоков одновременно!");
                    lore.add("");
                    if (balance > 60000) {
                        lore.add(" §fЦена: §a§l✔ §a" + balance + "§a/60000");
                    } else {
                        lore.add(" §fЦена: §c§l✖ §c" + balance + "§a/60000");
                    }
                }

                metaref.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                backpackItem.setItemMeta(metaref);
                backpack.setItem(4, backpackItem);

                player.openInventory(backpack);
                return true;
            }

                if (args[0].equalsIgnoreCase("upgrade")) {
                    if (bp == 50) {
                        int price = 500;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 100);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                    }
                    if (bp == 100) {
                        int price = 1000;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 500);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                    }

                    if (bp == 500) {
                        int price = 2000;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 1000);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                    }

                    if (bp == 1000) {
                        int price = 3000;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 2000);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                    }

                    if (bp == 2000) {
                        int price = 5000;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 5000);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                    }

                    if (bp == 5000) {
                        int price = 15000;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 10000);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                    }

                    if (bp == 10000) {
                        int price = 30000;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 20000);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                    }

                    if (bp == 20000) {
                        int price = 60000;

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег");
                            return true;
                        }
                        data.addBackPack(player.getUniqueId(), -bp);
                        data.addBackPack(player.getUniqueId(), 60000);
                        economy.withdrawPlayer(player, price);
                        player.sendMessage(ChatColor.YELLOW + "Рюкзак улучшен");
                        return true;
                    }

                    if (bp == 60000) {
                        player.sendMessage(ChatColor.RED + "Рюкзак максимального уровня");
                    }
                }

            }

        return true;
        }
    }
