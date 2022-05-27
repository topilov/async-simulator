package me.topilov.Events;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MineBreakEvent implements Listener {
    private final Economy economy = App.economy;
    SQLGetter data = App.getInstance().data;
    public ItemStack keyItem = new ItemStack(Material.TRIPWIRE_HOOK);

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material block = event.getBlock().getType();

        int boosterEXP = data.getBoosterEXP(player.getUniqueId());
        int boosterBlocks = data.getBoosterBlocks(player.getUniqueId());
        int boosterArtefacts = data.getBoosterArtefacts(player.getUniqueId());
        int boosterBalance = data.getBoosterBalance(player.getUniqueId());
        int valueBP = data.getBackPack(player.getUniqueId());
        int blocksBP = data.getBlocksBP(player.getUniqueId());

        if (block == Material.SANDSTONE || block == Material.END_STONE
                || block == Material.STONE_SLAB || block == Material.CRACKED_STONE_BRICKS
                || block == Material.BROWN_TERRACOTTA || block == Material.YELLOW_TERRACOTTA
                || block == Material.QUARTZ_BLOCK) {

            if (blocksBP >= valueBP) {
                data.setBlocksBP(player.getUniqueId(), valueBP);

                player.sendTitle(ChatColor.RED + "Вы заполнили свой рюкзак", "", 20,40,20);
                event.setCancelled(true);
                return;
            }

            int random = (int) (Math.random() * 30) + 1;
            switch (random) {
                case 1: {
                    player.sendTitle(ChatColor.GOLD + "Ты нашел артефакт: ", "", 10,70,20);
                    data.addArtefacts(player.getUniqueId(), boosterArtefacts);
                    break;
                }
                case 3: {
                    addDefaultKey(player);
                    break;
                }
            }

            data.addBlocks(player.getUniqueId(), boosterBlocks);
            data.addExp(player.getUniqueId(), 5 * boosterEXP);
            if (data.getAutosell(player.getUniqueId()) == 1) {
                economy.depositPlayer(player, 10 * boosterBalance);
            } else {
                data.addBlocksBP(player.getUniqueId(), 1);
            }
            event.getBlock().setType(Material.AIR);

            Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> event.getBlock().setType(block), 20 * 10);
        }
    }









    void addDefaultKey(Player player) {
        ArrayList<String> lore = new ArrayList<>();

        ItemMeta meta = keyItem.getItemMeta();

        meta.setDisplayName("§fКлюч от §6Обычного ящика");
        lore.add("");
        lore.add("§7Нажми ПКМ по кейсу на спавне");
        meta.setLore(lore);
        keyItem.setItemMeta(meta);

        player.getInventory().addItem(keyItem);
        player.sendMessage("§fВы получили Ключ от §6Обычного ящика §7x1§f!");
    }

}
