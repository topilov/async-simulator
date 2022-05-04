/*package me.topilom.mainplugin.GUI;

import me.topilom.mainplugin.GUIEvent.DragItemEventPerks;
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

public class MenuPerks implements CommandExecutor {

    public ItemStack perksItem1 = new ItemStack(Material.ENDER_PEARL);
    public ItemStack perksItem = new ItemStack(Material.WHITE_CONCRETE);

    MainPlugin main;
    public MenuPerks(MainPlugin main) {
        this.main = main;
    }

    public MySQL SQL;

    public SQLGetter data;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(main);

        if(cmd.getName().equalsIgnoreCase("perks")) {
                    if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }

            if (args.length == 0) {

                Player player = (Player) sender;
                int lvlPerk1 = data.getPerk1(player.getUniqueId());
                int artefacts = data.getArtefacts(player.getUniqueId());
                int rebirth = data.getRebirth(player.getUniqueId());


                Inventory perks = Bukkit.getServer().createInventory(null, 27, "Перки");

                ArrayList<String> lore = new ArrayList<String>();

                ItemMeta metaref = perksItem1.getItemMeta();

                if(lvlPerk1 == 0) {
                    
                    int price = 1000;
                    int rebirthAmount = 1;
                    
                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 1) {

                    int price = 1250;
                    int rebirthAmount = 2;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 2) {

                    int price = 1500;
                    int rebirthAmount = 3;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 3) {

                    int price = 1750;
                    int rebirthAmount = 4;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 4) {

                    int price = 2000;
                    int rebirthAmount = 5;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 5) {

                    int price = 2500;
                    int rebirthAmount = 6;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 6) {

                    int price = 3000;
                    int rebirthAmount = 7;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 7) {

                    int price = 4000;
                    int rebirthAmount = 8;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 8) {

                    int price = 5000;
                    int rebirthAmount = 9;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 9) {

                    int price = 6000;
                    int rebirthAmount = 10;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 10) {

                    int price = 7000;
                    int rebirthAmount = 11;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 11) {

                    int price = 8000;
                    int rebirthAmount = 12;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 12) {

                    int price = 9000;
                    int rebirthAmount = 13;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 13) {

                    int price = 10000;
                    int rebirthAmount = 14;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }

                if(lvlPerk1 == 14) {

                    int price = 15000;
                    int rebirthAmount = 15;

                    if(artefacts > price) {
                        lore.add(" §fАртефакты: §a§l✔ §a" + artefacts + "§a/" + price);
                    } else {
                        lore.add(" §fАртефакты: §c§l✖ §c" + artefacts + "§a/" + price);
                    }
                    if(rebirth > rebirthAmount) {
                        lore.add(" §fРебитх: §a§l✔ §a" + rebirth + "§a/" + rebirthAmount);
                    } else {
                        lore.add(" §fРебитх: §c§l✖ §c" + rebirth + "§a/" + rebirthAmount);
                    }
                }
                
                if(lvlPerk1 == 15) {
                    if(artefacts > 1250) {
                        lore.add(ChatColor.RED + "Максимальный уровень перка");
                    }
                }
                metaref.setLore(lore);
                metaref.setDisplayName("§bПерк §f- §6Разрушитель");

                perksItem1.setItemMeta(metaref);
                perks.setItem(10, perksItem1);

                /// NEW SLOT

                ArrayList<String> lore_2 = new ArrayList<String>();

                ItemMeta metaref_2 = perksItem.getItemMeta();

                lore_2.add(ChatColor.GOLD + "Перк номер 2");
                metaref_2.setLore(lore_2);
                metaref_2.setDisplayName("§bПерк номер 2");

                perksItem.setItemMeta(metaref_2);
                perks.setItem(11, perksItem);

                /// NEW SLOT

                ArrayList<String> lore_3 = new ArrayList<String>();

                ItemMeta metaref_3 = perksItem.getItemMeta();

                lore_3.add(ChatColor.GOLD + "Перк номер 3");
                metaref_3.setLore(lore_3);
                metaref_3.setDisplayName("§bПерк номер 3");

                perksItem.setItemMeta(metaref_3);
                perks.setItem(12, perksItem);

                /// NEW SLOT

                ArrayList<String> lore_4 = new ArrayList<String>();

                ItemMeta metaref_4 = perksItem.getItemMeta();

                lore_4.add(ChatColor.GOLD + "Перк номер 4");
                metaref_4.setLore(lore_4);
                metaref_4.setDisplayName("§bПерк номер 4");

                perksItem.setItemMeta(metaref_4);
                perks.setItem(13, perksItem);

                /// NEW SLOT

                ArrayList<String> lore_5 = new ArrayList<String>();

                ItemMeta metaref_5 = perksItem.getItemMeta();

                lore_5.add(ChatColor.GOLD + "Перк номер 5");
                metaref_5.setLore(lore_5);
                metaref_5.setDisplayName("§bПерк номер 5");

                perksItem.setItemMeta(metaref_5);
                perks.setItem(14, perksItem);

                /// NEW SLOT

                ArrayList<String> lore_6 = new ArrayList<String>();

                ItemMeta metaref_6 = perksItem.getItemMeta();

                lore_6.add(ChatColor.GOLD + "Перк номер 6");
                metaref_6.setLore(lore_6);
                metaref_6.setDisplayName("§bПерк номер 6");

                perksItem.setItemMeta(metaref_6);
                perks.setItem(15, perksItem);

                /// NEW SLOT

                ArrayList<String> lore_7 = new ArrayList<String>();

                ItemMeta metaref_7 = perksItem.getItemMeta();

                lore_7.add(ChatColor.GOLD + "Перк номер 7");
                metaref_7.setLore(lore_7);
                metaref_7.setDisplayName("§bПерк номер 7");

                perksItem.setItemMeta(metaref_7);
                perks.setItem(16, perksItem);


                player.openInventory(perks);
            }
        }

        return true;
    }
}*/
