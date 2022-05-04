package me.topilom.mainplugin.GUI;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.mainplugin.Other.InventoryManagement;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
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

import java.util.ArrayList;
public class RebirthGUI implements CommandExecutor {

    public ItemStack rebirthItem = new ItemStack(Material.PINK_CONCRETE);

    private final Economy economy = MainPlugin.economy;

    MainPlugin main;

    public RebirthGUI(MainPlugin main) {
        this.main = main;
    }

    public MySQL SQL;
    public SQLGetter data;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(main);

        if (cmd.getName().equalsIgnoreCase("rebirth")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }

            Player player = (Player) sender;

            int rebirth = data.getRebirth(player.getUniqueId());
            int balance = (int) economy.getBalance(player);
            int level = data.getLevel(player.getUniqueId());


            if(args.length == 0) {

                    Inventory rebirthMenu = Bukkit.getServer().createInventory(null, 9, "Перерождение");

                    ArrayList<String> lore = new ArrayList<String>();

                    ItemMeta metaref = rebirthItem.getItemMeta();

                    if(rebirth == 0) {
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
                        if(balance > 500000) {
                            lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/500000");
                        } else {
                            lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/500000");
                        }
                        if(level == 6) {
                            lore.add(" §fУровень: §a§l✔ §a" + level + "§a/6");
                        } else {
                            lore.add(" §fУровень: §c§l✖ §c" + level + "§a/6");
                        }
                    /*if(artefacts > 500) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/500");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + artefacts + "§a/500");
                    }*/
                        lore.add("§e§l▶ §eНажмите, чтобы переродиться");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§6Перерождение");
                }

                if (rebirth == 1) {
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
                    if(balance > 1000000) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/1000000");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/1000000");
                    }
                    if(level == 6) {
                        lore.add(" §fУровень: §a§l✔ §a" + level + "§a/6");
                    } else {
                        lore.add(" §fУровень: §c§l✖ §c" + level + "§a/6");
                    }
                    /*if(artefacts > 500) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/500");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + artefacts + "§a/500");
                    }*/
                    lore.add("§e§l▶ §eНажмите, чтобы переродиться");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Перерождение");
                }

                if (rebirth == 2) {
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
                    if(balance > 500000) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/2000000");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/2000000");
                    }
                    if(level == 6) {
                        lore.add(" §fУровень: §a§l✔ §a" + level + "§a/6");
                    } else {
                        lore.add(" §fУровень: §c§l✖ §c" + level + "§a/6");
                    }
                    /*if(artefacts > 500) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/500");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + artefacts + "§a/500");
                    }*/
                    lore.add("§e§l▶ §eНажмите, чтобы переродиться");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Перерождение");
                }

                if (rebirth == 3) {
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
                    if(balance > 500000) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/3000000");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/3000000");
                    }
                    if(level == 6) {
                        lore.add(" §fУровень: §a§l✔ §a" + level + "§a/6");
                    } else {
                        lore.add(" §fУровень: §c§l✖ §c" + level + "§a/6");
                    }
                    /*if(artefacts > 500) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/500");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + artefacts + "§a/500");
                    }*/
                    lore.add("§e§l▶ §eНажмите, чтобы переродиться");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Перерождение");
                }

                if (rebirth == 4) {
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
                    if(balance > 4000000) {
                        lore.add(" §fМонеты: §a§l✔ §a" + balance + "§a/4000000");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + balance + "§a/4000000");
                    }
                    if(level == 6) {
                        lore.add(" §fУровень: §a§l✔ §a" + level + "§a/6");
                    } else {
                        lore.add(" §fУровень: §c§l✖ §c" + level + "§a/6");
                    }
                    /*if(artefacts > 500) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/500");
                    } else {
                        lore.add(" §fМонеты: §c§l✖ §c" + artefacts + "§a/500");
                    }*/
                    lore.add("§e§l▶ §eНажмите, чтобы переродиться");
                    metaref.setLore(lore);
                    metaref.setDisplayName("§6Перерождение");
                }

                if (rebirth == 5 || rebirth > 5) {

                    player.sendMessage(ChatColor.RED + "У вас максимальный rebirth");
                    return true;
                }

                    metaref.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                    rebirthItem.setItemMeta(metaref);
                    rebirthMenu.setItem(4, rebirthItem);

                    player.openInventory(rebirthMenu);
                    return true;
                }
            if (args[0].equalsIgnoreCase("create")) {
                if (!(sender instanceof Player)) return true;

                if(rebirth == 0) {
                    int price = 500000;


                if (balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег для перерождения");
                    return true;
                    }
                if (level != 6) {
                    player.sendMessage(ChatColor.RED + "Недостаточно уровня для перерождения");
                    return true;
                }
            }

                if(rebirth == 1) {
                    int price = 1000000;


                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для перерождения");
                        return true;
                    }
                    if (level != 6) {
                        player.sendMessage(ChatColor.RED + "Недостаточно уровня для перерождения");
                        return true;
                    }
                }

                if(rebirth == 2) {
                    int price = 2000000;


                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для перерождения");
                        return true;
                    }
                    if (level != 6) {
                        player.sendMessage(ChatColor.RED + "Недостаточно уровня для перерождения");
                        return true;
                    }
                }

                if(rebirth == 3) {
                    int price = 3000000;


                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для перерождения");
                        return true;
                    }
                    if (level != 6) {
                        player.sendMessage(ChatColor.RED + "Недостаточно уровня для перерождения");
                        return true;
                    }
                }

                if(rebirth == 4) {
                    int price = 4000000;


                    if (balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег для перерождения");
                        return true;
                    }
                    if (level != 6) {
                        player.sendMessage(ChatColor.RED + "Недостаточно уровня для перерождения");
                        return true;
                    }
                }

                if(rebirth == 5) {

                    player.sendMessage(ChatColor.RED + "У вас максимальный rebirth");
                    return true;
                }

                ItemStack wooden_pickaxe = new ItemStack(Material.WOODEN_PICKAXE);



                InventoryManagement.clear(player);

                ItemMeta itemMeta = wooden_pickaxe.getItemMeta();
                itemMeta.setDisplayName("Кирка ур.1");
                itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                wooden_pickaxe.setItemMeta(itemMeta);

                player.chat("/spawn");
                InventoryManagement.addItem(player, wooden_pickaxe);

                economy.withdrawPlayer(player, balance);
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
        return true;
    }
}
