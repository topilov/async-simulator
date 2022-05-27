package me.topilov.GUI;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import me.topilov.utils.InventoryManagement;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class RebirthGUI implements CommandExecutor {
    private final Economy economy = App.economy;
    SQLGetter data = App.getInstance().data;
    public ItemStack rebirthItem = new ItemStack(Material.PINK_CONCRETE);


    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if (cmd.getName().equalsIgnoreCase("rebirth")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
            Player player = (Player) sender;
            int rebirth = data.getRebirth(player.getUniqueId());

            if(args.length == 0) {

                Inventory menu = Bukkit.getServer().createInventory(null, 9, "Перерождение");

                if (rebirth == 5) {
                    player.sendMessage("У вас максимальное количество перерождений");
                    return true;
                }

                    setMeta(player);

                    menu.setItem(4, rebirthItem);
                    player.openInventory(menu);
                    return true;
            }

            if (args[0].equalsIgnoreCase("create")) {

                rebirthCreate(player);

            return true;
        }
    }
    return true;
}















    boolean setMeta(Player player) {

        int rebirth = data.getRebirth(player.getUniqueId());
        int level = data.getLevel(player.getUniqueId());
        double balance = economy.getBalance(player);


        ArrayList<String> lore = new ArrayList<>();

        ItemMeta metaref = rebirthItem.getItemMeta();

        lore.add("");
        lore.add("§7Думаешь ты уже готов начать всё  ");
        lore.add("§7сначала? Не бойся! Это будет такжe");
        lore.add("§7увлекательно, как и до этого. К  ");
        lore.add("§7тому же получишь награду в виде");
        lore.add("§7вечных бустеров статистики:");
        lore.add("");
        lore.add("  §cБлоки §f+100%");
        lore.add("  §eМонеты §f+100%");
        lore.add("  §6Артефакты §f+100%");
        lore.add("  §bОпыт §f+100%");
        lore.add("");
        lore.add("§aДополнительная награда:");
        lore.add("§6 ✪ §f+ §d25 Битсов");
        lore.add("§6 ✪ §710% на §bСлот для Питомца");
        lore.add("");
        lore.add("§6Необходимая статистика");
        metaref.setDisplayName("§6Перерождение");

        for (int i = 0; i <= 4; i++) {
            if (rebirth == i) {
                int price = App.getInstance().getConfig().getInt("rebirth.price." + i);
                if (balance > price) {
                    lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/" + price);
                } else {
                    lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/" + price);
                }
                if (level == 6) {
                    lore.add(" §fУровень: §a§l✔ §a" + level + "§a/6");
                } else {
                    lore.add(" §fУровень: §c§l✖ §c" + level + "§a/6");
                }
                lore.add("§e§l▶ §eНажмите, чтобы переродиться");
                metaref.setLore(lore);
            }
        }

        rebirthItem.setItemMeta(metaref);
        return true;
    }

    private boolean rebirthCreate(Player player) {

        int rebirth = data.getRebirth(player.getUniqueId());
        int level = data.getLevel(player.getUniqueId());
        double balance = economy.getBalance(player);

        for (int i = 0; i <= 4; i++) {
            if(rebirth == i) {
                int price = App.getInstance().getConfig().getInt("rebirth.price." + i);
                if (balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег для перерождения");
                    return true;
                }
                if (level != 6) {
                    player.sendMessage(ChatColor.RED + "Недостаточно уровня для перерождения");
                    return true;
                }
            } else if (rebirth == 5) {
                player.sendMessage(ChatColor.RED + "У вас максимальное количество перерождений");
                return true;
            }
        }

        InventoryManagement.clear(player);
        player.chat("/locations spawn");

        if (data.getPickaxe(player.getUniqueId()) == 1) {
            ItemStack pickaxe = new ItemStack(Material.GOLDEN_PICKAXE);
            ItemMeta itemMeta = pickaxe.getItemMeta();

            itemMeta.setDisplayName(ChatColor.GOLD + "Супер Кирка");
            List<String> lore3 = new ArrayList<>();

            lore3.add("");
            lore3.add(ChatColor.WHITE + "Супер кирка, которая дает уникальные способности");

            itemMeta.addEnchant(Enchantment.DIG_SPEED, 300, true);
            itemMeta.setUnbreakable(true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.setLore(lore3);
            pickaxe.setItemMeta(itemMeta);

            player.getInventory().addItem(pickaxe);
        } else {
            ItemStack wooden_pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
            ItemMeta itemMeta = wooden_pickaxe.getItemMeta();
            itemMeta.setDisplayName("Кирка ур.1");
            itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
            wooden_pickaxe.setItemMeta(itemMeta);

            player.getInventory().addItem(wooden_pickaxe);
        }


        economy.withdrawPlayer(player, economy.getBalance(player));
        data.setLevel(player.getUniqueId(), 1);
        data.setBlocks(player.getUniqueId(), 0);
        data.setBlocksBP(player.getUniqueId(), 0);
        data.setBackPack(player.getUniqueId(), 50);

        data.addRebirth(player.getUniqueId(), 1);
        data.addBoosterEXP(player.getUniqueId(), 1);
        data.addBoosterBlocks(player.getUniqueId(), 1);
        data.addBoosterBalance(player.getUniqueId(), 1);
        data.addBoosterArtefacts(player.getUniqueId(), 1);
        return true;
    }
}
