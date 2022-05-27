package me.topilov.GUI;

import me.topilov.App;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

import static org.bukkit.Material.*;

public class UpgradeGUI implements CommandExecutor {
    private final Economy economy = App.economy;
    public ItemStack wooden_pickaxe = new ItemStack(WOODEN_PICKAXE);
    public ItemStack iron_pickaxe = new ItemStack(IRON_PICKAXE);
    public ItemStack diamond_pickaxe = new ItemStack(DIAMOND_PICKAXE);
    public ItemStack diamond_pickaxe1 = new ItemStack(DIAMOND_PICKAXE);

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String cmd, @Nonnull String[] args) {
        if (command.getName().equalsIgnoreCase("upgrade")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
            Player player = (Player) sender;
            ItemStack inhand = player.getInventory().getItemInMainHand();
            int balance = (int) economy.getBalance(player);

            if (inhand.getType() != WOODEN_PICKAXE && inhand.getType() != DIAMOND_PICKAXE && inhand.getType() != IRON_PICKAXE && inhand.getType() != GOLDEN_PICKAXE) {
                player.sendMessage("Вы должны держать кирку в руках");
                return true;
            }

            // open inventory menu
            if (args.length == 0) {
                Inventory upgrade = Bukkit.getServer().createInventory(null, 9, "Улучшение предмета");

                setMeta(player);

                upgrade.setItem(4, diamond_pickaxe1);
                player.openInventory(upgrade);
                return true;
            }

            /* upgrade CMD's (upgradeInvClick):
             /upgrade <w
             /upgrade <i
             /upgrade <d
            */
            for (int i = 1; i <= 5; i++) {
                    int price = App.getInstance().getConfig().getInt("upgrade.price.wooden." + i);
                    if (args[0].equalsIgnoreCase("<w" + i)) {

                        if (balance < price) {
                            player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                            return true;
                        }

                        player.getInventory().setItemInMainHand(null);

                        economy.withdrawPlayer(player, price);

                        setMetaWoodenPickaxe(i);

                        player.getInventory().addItem(wooden_pickaxe);
                    }
            }

            for (int i = 1; i <= 5; i++) {
                if (args[0].equalsIgnoreCase("<i" + i)) {
                    int price = App.getInstance().getConfig().getInt("upgrade.price.iron." + i);

                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                        return true;
                    }

                    player.getInventory().setItemInMainHand(null);

                    economy.withdrawPlayer(player, price);

                    setMetaIronPickaxe(i);

                    player.getInventory().addItem(iron_pickaxe);
                }
            }

            for (int i = 1; i <= 5; i++) {
                int price = App.getInstance().getConfig().getInt("upgrade.price.diamond." + i);
                if (args[0].equalsIgnoreCase("<d" + i)) {

                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                        return true;
                    }

                    player.getInventory().setItemInMainHand(null);

                    economy.withdrawPlayer(player, price);

                    setMetaDiamondPickaxe(i);

                    player.getInventory().addItem(diamond_pickaxe);
                }
            }

        }
        return true;
    }

    void setMetaWoodenPickaxe(int value) {
        ItemMeta itemMeta = wooden_pickaxe.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§7Обычная Деревянная Кирка");
        lore.add("§eУровень " + (value + 1));
        lore.add("");
        lore.add("§7Обычная кирка для добычи.");
        lore.add("§7Повышайте уровень своей кирки,");
        lore.add("§7чтобы она копала быстрее!");
        lore.add("");
        lore.add("§aОбычный предмет");
        itemMeta.addEnchant(Enchantment.DIG_SPEED, (value + 1), true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        wooden_pickaxe.setItemMeta(itemMeta);
    }

    void setMetaIronPickaxe(int value) {
        ItemMeta itemMeta = iron_pickaxe.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§7Обычная Железная Кирка");
        lore.add("§eУровень " + value);
        lore.add("");
        lore.add("§7Обычная кирка для добычи.");
        lore.add("§7Повышайте уровень своей кирки,");
        lore.add("§7чтобы она копала быстрее!");
        lore.add("");
        lore.add("§aОбычный предмет");
        itemMeta.addEnchant(Enchantment.DIG_SPEED, value, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        iron_pickaxe.setItemMeta(itemMeta);
    }

    void setMetaDiamondPickaxe(int value) {
        ItemMeta itemMeta = diamond_pickaxe.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§7Обычная Алмазная Кирка");
        lore.add("§eУровень " + value);
        lore.add("");
        lore.add("§7Обычная кирка для добычи.");
        lore.add("§7Повышайте уровень своей кирки,");
        lore.add("§7чтобы она копала быстрее!");
        lore.add("");
        lore.add("§aОбычный предмет");
        itemMeta.addEnchant(Enchantment.DIG_SPEED, value, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        diamond_pickaxe.setItemMeta(itemMeta);
    }

    void setMeta(Player player) {
        ItemMeta itemMeta = diamond_pickaxe1.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        ItemStack inhand = player.getInventory().getItemInMainHand();
        int balance = (int) economy.getBalance(player);

        lore.add("");
        lore.add("§7Улучшайте кирку, чтобы зарабатывать больше");
        lore.add("§7монет и быстрее прокачивать свой уровень!");
        lore.add("");
        lore.add("§6Необходимая статистика");

        if (inhand.getType() == WOODEN_PICKAXE) {
            for (int i = 1; i <= 5; i++) {
                int price = App.getInstance().getConfig().getInt("upgrade.price.wooden." + i);
                if (inhand.getEnchantments().get(Enchantment.DIG_SPEED) == i) {
                    if (balance >= price) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/" + price);
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/" + price);
                    }
                }
            }
        } else if (inhand.getType() == IRON_PICKAXE) {
            for (int i = 1; i <= 5; i++) {
                int price = App.getInstance().getConfig().getInt("upgrade.price.iron." + (i + 1)); // добавляется плюс чтобы шло от 2 значения в конфиге
                if (inhand.getEnchantments().get(Enchantment.DIG_SPEED) == i ) {
                    if (balance >= price) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/" + price);
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/" + price);
                    }
                }
            }
        } else if (inhand.getType() == DIAMOND_PICKAXE) {
            for (int i = 1; i <= 4; i++) {
                int price = App.getInstance().getConfig().getInt("upgrade.price.diamond." + (i + 1)); // добавляется плюс чтобы шло от 2 значения в конфиге
                if (inhand.getEnchantments().get(Enchantment.DIG_SPEED) == i ){
                    if (balance >= price) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/" + price);
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/" + price);
                    }
                } else if (inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5) {
                    lore.add(ChatColor.RED + "Кирка максимально улучшена");
                    break;
                }
            }
        } else if (player.getInventory().getItemInMainHand().getType() == DIAMOND_PICKAXE
                && player.getInventory().getItemInMainHand().getEnchantments().get(Enchantment.DIG_SPEED) == 5) {
            lore.add(ChatColor.RED + "Кирка максимально улучшена");
        }

        lore.add("");
        lore.add("§e▶ Нажмите, чтобы улучшить предмет");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§cУлучшение кирки");
        diamond_pickaxe1.setItemMeta(itemMeta);
    }

}