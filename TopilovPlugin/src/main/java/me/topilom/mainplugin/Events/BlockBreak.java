package me.topilom.mainplugin.Events;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class BlockBreak implements Listener {

    MainPlugin main;

    public BlockBreak(MainPlugin main) {
        this.main = main;
    }

    public MySQL SQL;
    public SQLGetter data;
    private final Economy economy = MainPlugin.economy;


    @EventHandler
    public boolean blockBreak(BlockBreakEvent event) {
        this.SQL = new MySQL();
        this.data = new SQLGetter(main);

        Player player = event.getPlayer();
        Material block = event.getBlock().getType();

        int boosterEXP = data.getBoosterEXP(player.getUniqueId());
        int boosterBlocks = data.getBoosterBlocks(player.getUniqueId());
        int boosterArtefacts = data.getBoosterArtefacts(player.getUniqueId());
        int valueBP = data.getBackPack(player.getUniqueId());
        int blocksBP = data.getBlocksBP(player.getUniqueId());

        int total = blocksBP - valueBP;

        // PRIVATE


        if (!(player.isOp())) {
            if (block != Material.SANDSTONE) {
                event.setCancelled(true);
            }
        }
        if (block == Material.SANDSTONE || block == Material.END_STONE
                || block == Material.STONE_SLAB || block == Material.CRACKED_STONE_BRICKS
                || block == Material.BROWN_TERRACOTTA || block == Material.YELLOW_TERRACOTTA
                || block == Material.QUARTZ_BLOCK) {

            if (blocksBP >= valueBP) {
                data.removeBlocksBP(player.getUniqueId(), total);

                player.sendTitle(ChatColor.RED + "Рюкзак заполнен", "");
                event.setCancelled(true);
                return true;
            }

            int random = (int) (Math.random() * 30) + 1;
            switch (random) {
                case 5: {
                    player.sendTitle(ChatColor.GOLD + "Ты нашел артефакт: ", "");
                    data.addArtefacts(player.getUniqueId(), 1 * boosterArtefacts);
                    break;
                }
                case 28: {
                    player.sendTitle(ChatColor.GOLD + "Ты нашел ЛакиБлок", "");
                    Bukkit.getScheduler().runTaskLater(main, () -> {
                        event.getBlock().setType(Material.GOLD_BLOCK);
                    }, 1);
                    return true;
                }
            }

            data.addBlocks(player.getUniqueId(), 1 * boosterBlocks);
            data.addExp(player.getUniqueId(), 5 * boosterEXP);
            data.addBlocksBP(player.getUniqueId(), 1);

            event.getBlock().setType(Material.AIR);

            Bukkit.getScheduler().runTaskLater(main, () -> {
                event.getBlock().setType(block);
            }, 20 * 10);
            return true;
        }
        return true;
    }
}


        /*if (event.getBlock().getType() == Material.GOLD_BLOCK) {

            Bukkit.getScheduler().runTaskLater(main, () -> {
                event.getBlock().setType(Material.SANDSTONE);
            }, 20 * 10);

            int random = (int) (Math.random() * 5) + 1;
            switch (random) {
                case 1: {
                    economy.depositPlayer(player, 10000);
                    player.sendMessage(ChatColor.YELLOW + "В лаки блоке ты нашел " + ChatColor.GOLD + "" + ChatColor.ITALIC + "10 000$");
                    break;
                }
                case 2: {
                    data.addBits(player.getUniqueId(), 25);
                    player.sendMessage(ChatColor.YELLOW + "В лаки блоке ты нашел " + ChatColor.GOLD + "" + ChatColor.ITALIC + "25 Битсов");
                    break;
                }
                case 3: {
                    data.addExp(player.getUniqueId(), 15000);
                    player.sendMessage(ChatColor.YELLOW + "В лаки блоке ты нашел " + ChatColor.GOLD + "" + ChatColor.ITALIC + "15 000 Опыта");
                    break;
                }
                case 4: {
                    economy.depositPlayer(player, 1000);
                    player.sendMessage(ChatColor.YELLOW + "В лаки блоке ты нашел " + ChatColor.GOLD + "" + ChatColor.ITALIC + "1 000$");
                    break;
                }
                case 5: {
                    economy.depositPlayer(player, 1000);
                    player.sendMessage(ChatColor.YELLOW + "В лаки блоке ты нашел " + ChatColor.GOLD + "" + ChatColor.ITALIC + "1 000$");
                }
            }
            return true;
        }*/
