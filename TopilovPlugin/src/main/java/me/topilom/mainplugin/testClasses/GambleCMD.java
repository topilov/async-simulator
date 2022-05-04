package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GambleCMD implements CommandExecutor {

    MainPlugin main;
    public GambleCMD(MainPlugin main) {
        this.main = main;
    }

    List<Inventory> invs = new ArrayList<Inventory>();
    public static ItemStack[] contens;
    private int itemIndex = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if( (label.equalsIgnoreCase("gamble"))) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "Консоль не может играть в азартные игры");
                return true;
            }
            Player player = (Player) sender;
            ItemStack fee = new ItemStack(Material.DIAMOND);
            fee.setAmount(3);
            if (player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND) &&
                    player.getInventory().getItemInMainHand().getAmount() >= 3) {
                player.getInventory().removeItem(fee);
                //spin that GUI
                spin(player);
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED + "Тебе требуется 3 алмаза чтобы играть");
            return true;
        }
        return true;
    }

    public void shuffle(Inventory inv) {
        if (contens == null) {
            ItemStack[] items = new ItemStack[10];

            items[0] = new ItemStack(Material.COARSE_DIRT, 32);
            items[1] = new ItemStack(Material.DIAMOND, 3);
            items[2] = new ItemStack(Material.IRON_INGOT, 64);
            items[3] = new ItemStack(Material.NETHER_STAR, 8);
            items[4] = new ItemStack(Material.CREEPER_SPAWN_EGG, 1);
            items[5] = new ItemStack(Material.QUARTZ_BLOCK, 64);
            items[6] = new ItemStack(Material.DIAMOND, 3);
            items[7] = new ItemStack(Material.ACACIA_WOOD, 12);
            items[8] = new ItemStack(Material.DIAMOND, 3);
            items[9] = new ItemStack(Material.BARRIER, 1);

            contens = items;
        }

        int startingIndex = ThreadLocalRandom.current().nextInt(contens.length);

        for (int index = 0; index < startingIndex; index++) {
            for (int itemstacks = 9; itemstacks < 18; itemstacks++) {
                inv.setItem(itemstacks, contens[(itemstacks + itemIndex) % contens.length]);
            }
            itemIndex++;
        }

        // Customize
        ItemStack item = new ItemStack(Material.HOPPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "|");
        inv.setItem(4, item);
    }


    public void spin(final Player player) {

        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Вращение рулетки");
        shuffle(inv);
        invs.add(inv);
        player.openInventory(inv);

        Random r = new Random();
        double seconds = 7.0 + (12.0 - 7.0) * r.nextDouble();

        new BukkitRunnable() {
            double delay = 0;
            int ticks = 0;
            boolean done = false;

            public void run() {
                if (done)
                return;
                ticks++;
                delay += 1 / (20 *seconds);
                if (ticks > delay * 10) {
                    ticks = 0;

                    for (int itemstacks = 9; itemstacks < 18; itemstacks++)
                        inv.setItem(itemstacks, contens[(itemstacks + itemIndex) % contens.length]);

                    itemIndex++;

                    if (delay >= .5) {
                        done = true;
                        new BukkitRunnable() {
                            public void run() {
                                ItemStack item = inv.getItem(13);
                                player.getInventory().addItem(item);
                                player.updateInventory();
                                player.closeInventory();
                                cancel();
                            }

                        }.runTaskLater(main, 50);
                        cancel();
                    }
                }
            }

        }.runTaskTimer(main, 0, 1);

    }
}
