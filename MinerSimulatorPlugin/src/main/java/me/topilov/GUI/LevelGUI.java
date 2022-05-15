package me.topilov.GUI;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
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

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class LevelGUI implements CommandExecutor {
    private final Economy economy = App.economy;
    SQLGetter data = App.getInstance().data;

    public ItemStack levelItem = new ItemStack(Material.EXPERIENCE_BOTTLE);
    public ItemStack keyPetItem = new ItemStack(Material.TRIPWIRE_HOOK);

    public Inventory levelup = Bukkit.getServer().createInventory(null, 9, "Повышение уровня");

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if(cmd.getName().equalsIgnoreCase("level")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
            Player player = (Player) sender;
            int blocks = data.getBlocks(player.getUniqueId());
            int balance = (int) economy.getBalance(player);
            int level = data.getLevel(player.getUniqueId());
            ArrayList<String> lore = new ArrayList<>();
            ItemMeta metaref = levelItem.getItemMeta();

            if(args.length == 0) {
                if(level == 1) {
                    lore.add("");
                    lore.add("§6С новым уровнем вы получите");
                    lore.add("§f + Доступ к новой Локации");
                    lore.add("§f + §b5000 Опыта");
                    lore.add("");
                    lore.add("§aДополнительная награда:");
                    lore.add("§6 ✪ §f+ §d5 Битсов");
                    lore.add("§6 ✪ §725% на §bКлюч от Ящика с Питомцами");
                    lore.add("");
                    lore.add("§6Необходимая статистика");
                    if(balance > 500) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/500");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/500");
                    }
                    if(blocks > 100) {
                        lore.add(" §fБлоки: §a§l✔ §a" + blocks + "§a/100");
                    } else {
                        lore.add(" §fБлоки: §c§l✖ §c" + blocks + "§a/100");
                    }
                    lore.add("§e§l▶ §eНажмите, чтобы прокачать уровень");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Прокачка уровня: §71 §6➜ §e2 Уровень");
                }
                if(level == 2) {
                    lore.add("");
                    lore.add("§6С новым уровнем вы получите");
                    lore.add("§f + Доступ к новой Локации");
                    lore.add("§f + §b5000 Опыта");
                    lore.add("");
                    lore.add("§aДополнительная награда:");
                    lore.add("§6 ✪ §f+ §d5 Битсов");
                    lore.add("§6 ✪ §725% на §bКлюч от Ящика с Питомцами");
                    lore.add("");
                    lore.add("§6Необходимая статистика");
                    if(balance > 2000) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/2000");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/2000");
                    }
                    if(blocks > 500) {
                        lore.add(" §fБлоки: §a§l✔ §a" + blocks + "§a/500");
                    } else {
                        lore.add(" §fБлоки: §c§l✖ §c" + blocks + "§a/500");
                    }
                    lore.add("§e§l▶ §eНажмите, чтобы прокачать уровень");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Прокачка уровня: §72 §6➜ §e3 Уровень");
                }
                if(level == 3) {
                    lore.add("");
                    lore.add("§6С новым уровнем вы получите");
                    lore.add("§f + Доступ к новой Локации");
                    lore.add("§f + §b5000 Опыта");
                    lore.add("");
                    lore.add("§aДополнительная награда:");
                    lore.add("§6 ✪ §f+ §d5 Битсов");
                    lore.add("§6 ✪ §725% на §bКлюч от Ящика с Питомцами");
                    lore.add("");
                    lore.add("§6Необходимая статистика");
                    if(balance > 5000) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/5000");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/5000");
                    }
                    if(blocks > 1000) {
                        lore.add(" §fБлоки: §a§l✔ §a" + blocks + "§a/1000");
                    } else {
                        lore.add(" §fБлоки: §c§l✖ §c" + blocks + "§a/1000");
                    }
                    lore.add("§e§l▶ §eНажмите, чтобы прокачать уровень");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Прокачка уровня: §73 §6➜ §e4 Уровень");
                }
                if(level == 4) {
                    lore.add("");
                    lore.add("§6С новым уровнем вы получите");
                    lore.add("§f + Доступ к новой Локации");
                    lore.add("§f + §b5000 Опыта");
                    lore.add("");
                    lore.add("§aДополнительная награда:");
                    lore.add("§6 ✪ §f+ §d5 Битсов");
                    lore.add("§6 ✪ §725% на §bКлюч от Ящика с Питомцами");
                    lore.add("");
                    lore.add("§6Необходимая статистика");
                    if(balance > 7500) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/7500");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/7500");
                    }
                    if(blocks > 2000) {
                        lore.add(" §fБлоки: §a§l✔ §a" + blocks + "§a/2000");
                    } else {
                        lore.add(" §fБлоки: §c§l✖ §c" + blocks + "§a/2000");
                    }
                    lore.add("§e§l▶ §eНажмите, чтобы прокачать уровень");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Прокачка уровня: §74 §6➜ §e5 Уровень");
                }
                if(level == 5) {
                    lore.add("");
                    lore.add("§6С новым уровнем вы получите");
                    lore.add("§f + Доступ к новой Локации");
                    lore.add("§f + §b5000 Опыта");
                    lore.add("");
                    lore.add("§aДополнительная награда:");
                    lore.add("§6 ✪ §f+ §d5 Битсов");
                    lore.add("§6 ✪ §725% на §bКлюч от Ящика с Питомцами");
                    lore.add("");
                    lore.add("§6Необходимая статистика");
                    if(balance > 15000) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/15000");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/15000");
                    }
                    if(blocks > 5000) {
                        lore.add(" §fБлоки: §a§l✔ §a" + blocks + "§a/5000");
                    } else {
                        lore.add(" §fБлоки: §c§l✖ §c" + blocks + "§a/5000");
                    }
                    lore.add("§e§l▶ §eНажмите, чтобы прокачать уровень");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Прокачка уровня: §75 §6➜ §e6 Уровень");
                }
                if(level == 6) {
                player.sendTitle(ChatColor.RED + "У вас максимальный уровень!",ChatColor.GRAY + "Используйте /rebirth чтобы переродиться", 20,40,20);
                return true;
                }

                metaref.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                levelItem.setItemMeta(metaref);
                levelup.setItem(4, levelItem);
                player.openInventory(levelup);
                return true;
            }

            if(args[0].equalsIgnoreCase("up")) {
                if (level == 1) {
                    int price = 500;
                    if (blocks < 100) {
                        player.sendMessage(ChatColor.RED + "Недостаточно блоков для повышения уровня");
                        return true;
                    }
                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для повышения уровня");
                        return true;
                    }
                    player.chat("/eco remove " + price);
                }
                if (level == 2) {
                    int price = 2000;
                    if (blocks < 500) {
                        player.sendMessage(ChatColor.RED + "Недостаточно блоков для повышения уровня");
                        return true;
                    }
                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для повышения уровня");
                        return true;
                    }
                    player.chat("/eco remove " + price);
                }
                if (level == 3) {
                    int price = 5000;
                    if (blocks < 1000) {
                        player.sendMessage(ChatColor.RED + "Недостаточно блоков для повышения уровня");
                        return true;
                    }
                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для повышения уровня");
                        return true;
                    }
                    player.chat("/eco remove " + price);
                }
                if (level == 4) {
                    int price = 7500;
                    if (blocks < 2000) {
                        player.sendMessage(ChatColor.RED + "Недостаточно блоков для повышения уровня");
                        return true;
                    }
                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для повышения уровня");
                        return true;
                    }
                    player.chat("/eco remove " + price);
                }
                if (level == 5) {
                    int price = 15000;
                    if (blocks < 5000) {
                        player.sendMessage(ChatColor.RED + "Недостаточно блоков для повышения уровня");
                        return true;
                    }
                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для повышения уровня");
                        return true;
                    }
                    player.chat("/eco remove " + price);
                }
                if (level == 6 || level > 6) {
                    player.sendTitle(ChatColor.RED + "У вас максимальный уровень!",ChatColor.GRAY + "Используйте /rebirth чтобы переродиться", 20,40,20);
                    return true;
                }

                int random = (int) (Math.random() * 4) + 1;
                switch (random) {
                    case 1: {

                        ItemMeta meta = keyPetItem.getItemMeta();

                        meta.setDisplayName("§bКлюч от Ящика с Питомцами");
                        lore.add("");
                        lore.add("§7Нажми ПКМ по кейсу на спавне");
                        meta.setLore(lore);
                        keyPetItem.setItemMeta(meta);

                        player.getInventory().addItem(keyPetItem);
                        player.sendMessage(ChatColor.WHITE + "Вы получили " + ChatColor.AQUA + "Ключ от Ящика с Питомцами");
                        break;
                    }
                    case 2: {

                    }
                }

                data.addLevel(player.getUniqueId(), 1);
                data.addExp(player.getUniqueId(), 5000);
                data.addBits(player.getUniqueId(), 5);
                player.sendMessage(ChatColor.GREEN + "Уровень повышен");
                return true;
            }

        }
        return true;
    }
}
