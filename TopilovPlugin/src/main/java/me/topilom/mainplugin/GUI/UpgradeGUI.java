package me.topilom.mainplugin.GUI;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.mainplugin.Other.InventoryManagement;
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

import java.util.ArrayList;

import static org.bukkit.Material.*;

public class UpgradeGUI implements CommandExecutor {

    private final Economy economy = MainPlugin.economy;


    public ItemStack wooden_pickaxe = new ItemStack(WOODEN_PICKAXE);
    public ItemStack iron_pickaxe = new ItemStack(IRON_PICKAXE);
    public ItemStack diamond_pickaxe = new ItemStack(DIAMOND_PICKAXE);
    public ItemStack iron_pickaxe_0 = new ItemStack(IRON_PICKAXE);
    public ItemStack diamond_pickaxe1 = new ItemStack(DIAMOND_PICKAXE);

    public UpgradeGUI(MainPlugin mainPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        if (command.getName().equalsIgnoreCase("upgrade")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }

            Player player = (Player) sender;
            ItemStack inhand = player.getInventory().getItemInMainHand();

            if (args.length == 0){

                if (inhand.getType() != WOODEN_PICKAXE && inhand.getType() != DIAMOND_PICKAXE && inhand.getType() != IRON_PICKAXE) {
                    player.sendMessage("Вы должны держать кирку в руках");
                    return true;
                }

                Inventory upgrade = Bukkit.getServer().createInventory(null, 9, "Улучшение предмета");

                ArrayList<String> lore = new ArrayList<String>();

                ItemMeta metaref = diamond_pickaxe1.getItemMeta();

                if (inhand.getType() == WOODEN_PICKAXE) {
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 1) {
                        lore.add("");
                        lore.add("§e§lЦена: 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 2) {
                        lore.add("");
                        lore.add("§e§lЦена: 1 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 3) {
                        lore.add("");
                        lore.add("§e§lЦена: 1 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 4) {
                        lore.add("");
                        lore.add("§e§lЦена: 2 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getType() == WOODEN_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5)  {
                        lore.add("");
                        lore.add("§e§lЦена: 3 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                }

                if (inhand.getType() == IRON_PICKAXE) {
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 0) {
                        lore.add("");
                        lore.add("§e§lЦена: 4 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 1) {
                        lore.add("");
                        lore.add("§e§lЦена: 5 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 2) {
                        lore.add("");
                        lore.add("§e§lЦена: 8 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 3) {
                        lore.add("");
                        lore.add("§e§lЦена: 9 500$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 4) {
                        lore.add("");
                        lore.add("§e§lЦена: 10 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getType() == IRON_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5)  {
                        lore.add("");
                        lore.add("§e§lЦена: 12 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                }

                if (player.getInventory().getItemInMainHand().getType() == DIAMOND_PICKAXE) {
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 0) {
                        lore.add("");
                        lore.add("§e§lЦена: 14 000");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 1) {
                        lore.add("");
                        lore.add("§e§lЦена: 16 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 2) {
                        lore.add("");
                        lore.add("§e§lЦена: 18 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 3) {
                        lore.add("");
                        lore.add("§e§lЦена: 20 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 4) {
                        lore.add("");
                        lore.add("§e§lЦена: 22 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getType() == DIAMOND_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5)  {
                        lore.add("");
                        lore.add("§e§lЦена: 25 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getType() == DIAMOND_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 6)  {
                        lore.add("");
                        lore.add("§e§lЦена: 30 000$");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 7) {
                        lore.add("");
                        lore.add("§c§lКирка максимально улучшена");
                        metaref.setLore(lore);
                        metaref.setDisplayName("§cУлучшение кирки");
                    }
                }

                metaref.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                diamond_pickaxe1.setItemMeta(metaref);
                upgrade.setItem(4, diamond_pickaxe1);

                player.openInventory(upgrade);
                return true;
            }
                if (args[0].equalsIgnoreCase("wooden_pickaxe_1")) {

                    assert player != null;
                    int price = 1000;
                    int balance = (int) economy.getBalance(player);

                    if(balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                        return true;

                    }

                    InventoryManagement.removeItem(player, wooden_pickaxe);

                    economy.depositPlayer(player, price);

                    ItemMeta itemMeta = wooden_pickaxe.getItemMeta();
                    itemMeta.setDisplayName("Кирка ур.1");

                    itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                    wooden_pickaxe.setItemMeta(itemMeta);

                    player.getInventory().addItem(wooden_pickaxe); //выдача
                }



                if (args[0].equalsIgnoreCase("wooden_pickaxe_2")) {

                    assert player != null;
                    int price = 500;
                    int balance = (int) economy.getBalance(player);

                    if(balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                        return true;

                    }


                    InventoryManagement.removeItem(player, wooden_pickaxe);

                    economy.depositPlayer(player, price);

                    ItemMeta itemMeta = wooden_pickaxe.getItemMeta(); //получает меты
                    itemMeta.setDisplayName("Кирка ур.2"); // установка названия

                    itemMeta.addEnchant(Enchantment.DIG_SPEED, 2, true);
                    wooden_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                    player.getInventory().addItem(wooden_pickaxe); //выдача
                }



                if (args[0].equalsIgnoreCase("wooden_pickaxe_3")) {

                    assert player != null;
                    int price = 1000;
                    int balance = (int) economy.getBalance(player);

                    if(balance < price) {
                        player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                        return true;

                    }

                    InventoryManagement.removeItem(player, wooden_pickaxe);

                    economy.depositPlayer(player, price);

                    ItemMeta itemMeta = wooden_pickaxe.getItemMeta(); //получает меты
                    itemMeta.setDisplayName("Кирка ур.3"); // установка названия

                    itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    wooden_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                    player.getInventory().addItem(wooden_pickaxe); //выдача
                }




            if (args[0].equalsIgnoreCase("wooden_pickaxe_4")) {

                assert player != null;
                int price = 1500;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, wooden_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = wooden_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.4"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 4, true);
                wooden_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(wooden_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("wooden_pickaxe_5")) {

                assert player != null;
                int price = 2500;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, wooden_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = wooden_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.5"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                wooden_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(wooden_pickaxe); //выдача
            }






            if (args[0].equalsIgnoreCase("iron_pickaxe_0")) {
                int balance = (int) economy.getBalance(player);
                assert player != null;
                int price = 3500;

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                economy.depositPlayer(player, price);


                ItemMeta itemMeta_0 = iron_pickaxe_0.getItemMeta(); //получает меты
                itemMeta_0.setDisplayName("Кирка ур.6"); // установка названия

                itemMeta_0.addEnchant(Enchantment.DIG_SPEED, 0, true);
                iron_pickaxe_0.setItemMeta(itemMeta_0); //вешает мету (енчант и название)

                InventoryManagement.removeItem(player, wooden_pickaxe);
                player.getInventory().addItem(iron_pickaxe_0); //выдача
            }



            if (args[0].equalsIgnoreCase("iron_pickaxe_1")) {

                assert player != null;
                int price = 4500;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = iron_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.7"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                iron_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                InventoryManagement.removeItem(player, iron_pickaxe_0);
                player.getInventory().addItem(iron_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("iron_pickaxe_2")) {

                assert player != null;
                int price = 5500;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, iron_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = iron_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.8"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 2, true);
                iron_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(iron_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("iron_pickaxe_3")) {

                assert player != null;
                int price = 8500;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, iron_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = iron_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.9"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                iron_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(iron_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("iron_pickaxe_4")) {

                assert player != null;
                int price = 9500;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, iron_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = iron_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.10"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 4, true);
                iron_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(iron_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("iron_pickaxe_5")) {

                assert player != null;
                int price = 10000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, iron_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = iron_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.11"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                iron_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(iron_pickaxe); //выдача
            }





            if (args[0].equalsIgnoreCase("diamond_pickaxe_0")) {
                int balance = (int) economy.getBalance(player);
                assert player != null;
                int price = 12000;

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                economy.depositPlayer(player, price);


                ItemMeta itemMeta = diamond_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.12"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 0, true);
                diamond_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                InventoryManagement.removeItem(player, iron_pickaxe);
                player.getInventory().addItem(diamond_pickaxe);

            }



            if (args[0].equalsIgnoreCase("diamond_pickaxe_1")) {

                assert player != null;
                int price = 14000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);;

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.13"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                diamond_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("diamond_pickaxe_2")) {

                assert player != null;
                int price = 16000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.14"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 2, true);
                diamond_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("diamond_pickaxe_3")) {

                assert player != null;
                int price = 18000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);;

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.15"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                diamond_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("diamond_pickaxe_4")) {

                assert player != null;
                int price = 20000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.16"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 4, true);
                diamond_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("diamond_pickaxe_5")) {

                assert player != null;
                int price = 22000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.17"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                diamond_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_pickaxe); //выдача
            }



            if (args[0].equalsIgnoreCase("diamond_pickaxe_6")) {

                assert player != null;
                int price = 25000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Кирка ур.18"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 6, true);
                diamond_pickaxe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_pickaxe); //выдача
            }




            if (args[0].equalsIgnoreCase("diamond_pickaxe_7")) {

                assert player != null;
                int price = 30000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                economy.depositPlayer(player, price);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta();
                itemMeta.setDisplayName("Кирка ур.19");

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 7, true);
                diamond_pickaxe.setItemMeta(itemMeta);

                player.getInventory().addItem(diamond_pickaxe);
            }




            if (args[0].equalsIgnoreCase("diamond_pickaxe_7")) {

                assert player != null;
                int price = 30000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta();
                itemMeta.setDisplayName("Кирка ур.19");

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 7, true);
                diamond_pickaxe.setItemMeta(itemMeta);

                player.getInventory().addItem(diamond_pickaxe);
            }
            if (args[0].equalsIgnoreCase("diamond_pickaxe_20")) {

                assert player != null;
                int price = 60000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_pickaxe);

                economy.depositPlayer(player, price);

                ItemMeta itemMeta = diamond_pickaxe.getItemMeta();
                itemMeta.setDisplayName("Кирка ур.20");

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 20, true);
                diamond_pickaxe.setItemMeta(itemMeta);

                player.getInventory().addItem(diamond_pickaxe);
            }

            }








        /*if (command.getName().equalsIgnoreCase("buyaxe")) {
            if (args[0].equalsIgnoreCase("0")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_axe);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_axe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Топор ур.0"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 0, true);
                diamond_axe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_axe); //выдача
            }
            if (args[0].equalsIgnoreCase("1")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_axe);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_axe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Топор ур.1"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                diamond_axe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_axe); //выдача
                sender.sendMessage("Топор улучшен");
            }
            if (args[0].equalsIgnoreCase("2")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_axe);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_axe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Топор ур.2"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 2, true);
                diamond_axe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_axe); //выдача
                sender.sendMessage("Топор улучшен");
            }
            if (args[0].equalsIgnoreCase("3")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_axe);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_axe.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Топор ур.3"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                diamond_axe.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_axe); //выдача
                sender.sendMessage("Топор улучшен");
            }

        }
        if (command.getName().equalsIgnoreCase("buyshovel")) {
            if (args[0].equalsIgnoreCase("0")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_shovel);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_shovel.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Лопата ур.0"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 0, true);
                diamond_shovel.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_shovel); //выдача
            }
            if (args[0].equalsIgnoreCase("1")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_shovel);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_shovel.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Лопата ур.1"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                diamond_shovel.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_shovel); //выдача
                sender.sendMessage("Лопата улучшена");
            }
            if (args[0].equalsIgnoreCase("2")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_shovel);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_shovel.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Лопата ур.2"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 2, true);
                diamond_shovel.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_shovel); //выдача
                sender.sendMessage("Лопата улучшена");
            }
            if (args[0].equalsIgnoreCase("3")) {
                Player player = (Player) sender; //плеер это тот кто отправил сообщение

                assert player != null;
                int price = 1000;
                int balance = (int) economy.getBalance(player);

                if(balance < price) {
                    player.sendMessage(ChatColor.RED + "Недостаточно денег, нужно: " + price);
                    return true;

                }

                InventoryManagement.removeItem(player, diamond_shovel);

                player.chat("/eco remove " + price);

                ItemMeta itemMeta = diamond_shovel.getItemMeta(); //получает меты
                itemMeta.setDisplayName("Лопата ур.3"); // установка названия

                itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                diamond_shovel.setItemMeta(itemMeta); //вешает мету (енчант и название)

                player.getInventory().addItem(diamond_shovel); //выдача
                sender.sendMessage("Лопата улучшена");
            }

        }*/
        return true;
        }
    }