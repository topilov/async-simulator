/*package me.topilom.mainplugin.GUIEvent;

import me.topilom.mainplugin.GUI.MenuPerks;
import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DragItemEventPerks implements Listener {

    MainPlugin main;
    public DragItemEventPerks(MainPlugin main) {
        this.main = main;
    }



    public MySQL SQL;
    public SQLGetter data;

    @EventHandler
    public boolean onItemDrag(InventoryClickEvent e) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(main);

        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();

        int lvlPerk1 = data.getPerk1(player.getUniqueId());
        int artefacts = data.getArtefacts(player.getUniqueId());
        int rebirth = data.getRebirth(player.getUniqueId());

        if(inventory.getTitle().contains("Перки")) {

            if(clicked.getType() == Material.ENDER_PEARL) {

                if(lvlPerk1 == 0) {

                    int price = 1000;
                    int rebirthAmount = 1;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 1) {

                    int price = 1250;
                    int rebirthAmount = 2;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 2) {

                    int price = 1500;
                    int rebirthAmount = 3;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 3) {

                    int price = 1750;
                    int rebirthAmount = 4;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 4) {

                    int price = 2000;
                    int rebirthAmount = 5;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 5) {

                    int price = 2500;
                    int rebirthAmount = 6;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 6) {

                    int price = 3000;
                    int rebirthAmount = 7;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 7) {

                    int price = 4000;
                    int rebirthAmount = 8;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 8) {

                    int price = 5000;
                    int rebirthAmount = 9;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 9) {

                    int price = 6000;
                    int rebirthAmount = 10;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 10) {

                    int price = 7000;
                    int rebirthAmount = 11;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 11) {

                    int price = 8000;
                    int rebirthAmount = 12;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 12) {

                    int price = 9000;
                    int rebirthAmount = 13;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 13) {

                    int price = 10000;
                    int rebirthAmount = 14;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 14) {

                    int price = 15000;
                    int rebirthAmount = 15;

                    if(price > artefacts) {
                        player.sendMessage(ChatColor.RED + "Недостаточно артефактов");
                        return true;
                    }
                    if(rebirthAmount > rebirth) {
                        player.sendMessage(ChatColor.RED + "Недостаточно ребитхов");
                        return true;
                    }

                    data.addArtefacts(player.getUniqueId(), -price);
                    data.addPerk1(player.getUniqueId(), 1);

                    player.sendMessage(ChatColor.GREEN + "Перк улучшен");

                    player.closeInventory();
                }

                if(lvlPerk1 == 15) {

                    player.sendMessage(ChatColor.RED + "У вас максимальный уровень перка");

                    player.closeInventory();

                }
            }
        }
        return true;

    }



}*/
