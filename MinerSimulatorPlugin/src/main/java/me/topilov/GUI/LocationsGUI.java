package me.topilov.GUI;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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

public class LocationsGUI implements CommandExecutor {
    SQLGetter data = App.getInstance().data;
    public ItemStack location1 = new ItemStack(Material.GOLDEN_PICKAXE);
    public ItemStack location2 = new ItemStack(Material.IRON_PICKAXE);
    public ItemStack location3 = new ItemStack(Material.DIAMOND_PICKAXE);
    public ItemStack location4 = new ItemStack(Material.WOODEN_PICKAXE);
    public ItemStack location5 = new ItemStack(Material.STONE_PICKAXE);
    public ItemStack location6 = new ItemStack(Material.GOLDEN_PICKAXE);
    public ItemStack location7 = new ItemStack(Material.IRON_PICKAXE);
    public ItemStack unavailable = new ItemStack(Material.BARRIER);

    public Inventory locations = Bukkit.getServer().createInventory(null, 36, "Локации");

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if (cmd.getName().equalsIgnoreCase("locations")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
            Player player = (Player) sender;
            int level = data.getLevel(player.getUniqueId());
            if (args.length == 0) {

                setAllMeta(player);
                setItem(player);

                player.openInventory(locations);

                return true;
            }


            /*
            CMDs for locations:
            /locations spawn
            /locations 1
            /locations 2
            /locations 3
            /locations 4
            /locations 5
            /locations 6
            */
            if(args[0].equalsIgnoreCase("spawn")) {
                player.teleport(new Location(Bukkit.getWorld("world"), -339, 104, 415, (float) 179.466, (float) 3.3));
            }
            if(args[0].equalsIgnoreCase("1")) {
                player.teleport(new Location(Bukkit.getWorld("world"), -21.430, 124.0, 486.575, (float) 178.5, (float) -9.45));
            }
            if(args[0].equalsIgnoreCase("2")) {
                if(level < 2) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), 53.429, 130, 269.473, (float) 1.05, (float) 5.1));
            }
            if(args[0].equalsIgnoreCase("3")) {
                if(level < 3) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -142.226, 134, 68.533, (float) 2.1, (float) 2.85));
            }
            if(args[0].equalsIgnoreCase("4")) {
                if(level < 4) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -333.412, 109, 44.940, (float) 0.45, (float) 2.4));
            }
            if(args[0].equalsIgnoreCase("5")) {
                if(level < 5) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -178.554, 154, -84.603, (float) 179.101, (float) -3));
            }
            if(args[0].equalsIgnoreCase("6")) {
                if(level < 6) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -556.603, 137, 151.178, (float) 178.5, (float) -9.45));
            }
        }
        return true;
    }

    void setItem (Player player) {
        int level = data.getLevel(player.getUniqueId());
        /*
        Проверка имеет ли игрок нужный уровень для отображения локации
        */
        locations.setItem(12, location1);
        if (level >= 2) {
            locations.setItem(13, location2);
        } else {
            locations.setItem(13, unavailable);
        }
        if (level >= 3) {
            locations.setItem(14, location3);
        } else {
            locations.setItem(14, unavailable);
        }
        if (level >= 4) {
            locations.setItem(20, location4);
        } else {
            locations.setItem(20, unavailable);
        }
        if (level >= 5) {
            locations.setItem(21, location5);
        } else {
            locations.setItem(21, unavailable);
        }
        if (level >= 6) {
            locations.setItem(23, location6);
        } else {
            locations.setItem(23, unavailable);
        }
        if (level >= 7) {
            locations.setItem(24, location7);
        } else {
            locations.setItem(24, unavailable);
        }
    }
    void setAllMeta (Player player) {
        int level = data.getLevel(player.getUniqueId());
        setMeta(1);
        for (int i = 2; i <= 7; i++) {
            if (level >= i) {
                setMeta(i);
            } else {
                setUnavailableMeta();
            }
        }
    }

    void setUnavailableMeta() {
        ArrayList<String> lore_unavailable = new ArrayList<>();
        ItemMeta itemMetaUnavailable = location1.getItemMeta();

        lore_unavailable.add("");
        lore_unavailable.add("§7Ваш уровень слишком мал. Прокачивайте");
        lore_unavailable.add("§7свой уровень, чтобы открыть локацию.");

        itemMetaUnavailable.setLore(lore_unavailable);
        itemMetaUnavailable.setDisplayName("§cНедоступно");

        itemMetaUnavailable.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        unavailable.setItemMeta(itemMetaUnavailable);
    }
    void setMeta (int number) {
        if (number == 1) {
            ArrayList<String> lore_1 = new ArrayList<>();
            ItemMeta itemMeta1 = location1.getItemMeta();

            lore_1.add("");
            lore_1.add("§7Копай и находи дорогие сокровища");
            lore_1.add("§7и продавай их, чтобы стать богатым.");
            lore_1.add("§7На каждой локации разные сокровища.");
            lore_1.add("§7Сможешь собрать все сокровища?");
            lore_1.add("§7Удачи юный охотник за сокровищами!");
            lore_1.add("");
            lore_1.add("§7⊠§6Уровень для локации:§f 1");
            lore_1.add("");
            lore_1.add("§7§o Советуем вам всегда играть только");
            lore_1.add("§7§o на локации соответствующей вашему");
            lore_1.add("§7§o уровню, иначе вы будете получать");
            lore_1.add("§7§o меньше монет, чем могли бы!");
            lore_1.add("");
            lore_1.add("§e▶ Нажмите, чтобы телепортироваться");

            itemMeta1.setLore(lore_1);
            itemMeta1.setDisplayName("§eПляж");
            itemMeta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
            location1.setItemMeta(itemMeta1);
        }
        if (number == 2) {
            ArrayList<String> lore_2 = new ArrayList<>();
            ItemMeta itemMeta2 = location2.getItemMeta();
            
            lore_2.add("");
            lore_2.add("§7Копай и находи дорогие сокровища");
            lore_2.add("§7и продавай их, чтобы стать богатым.");
            lore_2.add("§7На каждой локации разные сокровища.");
            lore_2.add("§7Сможешь собрать все сокровища?");
            lore_2.add("§7Удачи юный охотник за сокровищами!");
            lore_2.add("");
            lore_2.add("§7⊠§6Уровень для локации:§f 2");
            lore_2.add("");
            lore_2.add("§7§o Советуем вам всегда играть только");
            lore_2.add("§7§o на локации соответствующей вашему");
            lore_2.add("§7§o уровню, иначе вы будете получать");
            lore_2.add("§7§o меньше монет, чем могли бы!");
            lore_2.add("");
            lore_2.add("§e▶ Нажмите, чтобы телепортироваться");

            itemMeta2.setLore(lore_2);
            itemMeta2.setDisplayName("§7Пещера");
            itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
            location2.setItemMeta(itemMeta2);
        }

        if (number == 3) {
            ArrayList<String> lore_3 = new ArrayList<>();
            ItemMeta itemMeta3 = location3.getItemMeta();
            
            lore_3.add("");
            lore_3.add("§7Копай и находи дорогие сокровища");
            lore_3.add("§7и продавай их, чтобы стать богатым.");
            lore_3.add("§7На каждой локации разные сокровища.");
            lore_3.add("§7Сможешь собрать все сокровища?");
            lore_3.add("§7Удачи юный охотник за сокровищами!");
            lore_3.add("");
            lore_3.add("§7⊠§6Уровень для локации:§f 3");
            lore_3.add("");
            lore_3.add("§7§o Советуем вам всегда играть только");
            lore_3.add("§7§o на локации соответствующей вашему");
            lore_3.add("§7§o уровню, иначе вы будете получать");
            lore_3.add("§7§o меньше монет, чем могли бы!");
            lore_3.add("");
            lore_3.add("§e▶ Нажмите, чтобы телепортироваться");

            itemMeta3.setLore(lore_3);
            itemMeta3.setDisplayName("§6Пустыня");
            itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
            location3.setItemMeta(itemMeta3);
        }

        if (number == 4) {
            ArrayList<String> lore_4 = new ArrayList<>();
            ItemMeta itemMeta4 = location4.getItemMeta();
            
            lore_4.add("");
            lore_4.add("§7Копай и находи дорогие сокровища");
            lore_4.add("§7и продавай их, чтобы стать богатым.");
            lore_4.add("§7На каждой локации разные сокровища.");
            lore_4.add("§7Сможешь собрать все сокровища?");
            lore_4.add("§7Удачи юный охотник за сокровищами!");
            lore_4.add("");
            lore_4.add("§7⊠§6Уровень для локации:§f 4");
            lore_4.add("");
            lore_4.add("§7§o Советуем вам всегда играть только");
            lore_4.add("§7§o на локации соответствующей вашему");
            lore_4.add("§7§o уровню, иначе вы будете получать");
            lore_4.add("§7§o меньше монет, чем могли бы!");
            lore_4.add("");
            lore_4.add("§e▶ Нажмите, чтобы телепортироваться");

            itemMeta4.setLore(lore_4);
            itemMeta4.setDisplayName("§4Ад");
            itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
            location4.setItemMeta(itemMeta4);
        }

        if (number == 5) {
            ArrayList<String> lore_5 = new ArrayList<>();
            ItemMeta itemMeta5 = location5.getItemMeta();
            
            lore_5.add("");
            lore_5.add("§7Копай и находи дорогие сокровища");
            lore_5.add("§7и продавай их, чтобы стать богатым.");
            lore_5.add("§7На каждой локации разные сокровища.");
            lore_5.add("§7Сможешь собрать все сокровища?");
            lore_5.add("§7Удачи юный охотник за сокровищами!");
            lore_5.add("");
            lore_5.add("§7⊠§6Уровень для локации:§f 5");
            lore_5.add("");
            lore_5.add("§7§o Советуем вам всегда играть только");
            lore_5.add("§7§o на локации соответствующей вашему");
            lore_5.add("§7§o уровню, иначе вы будете получать");
            lore_5.add("§7§o меньше монет, чем могли бы!");
            lore_5.add("");
            lore_5.add("§e▶ Нажмите, чтобы телепортироваться");

            itemMeta5.setLore(lore_5);
            itemMeta5.setDisplayName("§7§lТемный замок");
            itemMeta5.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
            location5.setItemMeta(itemMeta5);
        }

        if (number == 6) {
            ArrayList<String> lore_6 = new ArrayList<>();
            ItemMeta itemMeta6 = location6.getItemMeta();

            lore_6.add("");
            lore_6.add("§7Копай и находи дорогие сокровища");
            lore_6.add("§7и продавай их, чтобы стать богатым.");
            lore_6.add("§7На каждой локации разные сокровища.");
            lore_6.add("§7Сможешь собрать все сокровища?");
            lore_6.add("§7Удачи юный охотник за сокровищами!");
            lore_6.add("");
            lore_6.add("§7⊠§6Уровень для локации:§f 6");
            lore_6.add("");
            lore_6.add("§7§o Советуем вам всегда играть только");
            lore_6.add("§7§o на локации соответствующей вашему");
            lore_6.add("§7§o уровню, иначе вы будете получать");
            lore_6.add("§7§o меньше монет, чем могли бы!");
            lore_6.add("");
            lore_6.add("§e▶ Нажмите, чтобы телепортироваться");

            itemMeta6.setLore(lore_6);
            itemMeta6.setDisplayName("§eКрай");
            itemMeta6.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
            location6.setItemMeta(itemMeta6);
        }

        if (number == 7) {
            ArrayList<String> lore_7 = new ArrayList<>();
            ItemMeta itemMeta7 = location7.getItemMeta();

            lore_7.add("");
            lore_7.add("§7Копай и находи дорогие сокровища");
            lore_7.add("§7и продавай их, чтобы стать богатым.");
            lore_7.add("§7На каждой локации разные сокровища.");
            lore_7.add("§7Сможешь собрать все сокровища?");
            lore_7.add("§7Удачи юный охотник за сокровищами!");
            lore_7.add("");
            lore_7.add("§7⊠§6Уровень для локации:§f 7");
            lore_7.add("");
            lore_7.add("§o§7 Советуем вам всегда играть только");
            lore_7.add("§o§7 на локации соответствующей вашему");
            lore_7.add("§o§7 уровню, иначе вы будете получать");
            lore_7.add("§o§7 меньше монет, чем могли бы!");
            lore_7.add("");
            lore_7.add("§e▶ Нажмите, чтобы телепортироваться");

            itemMeta7.setLore(lore_7);
            itemMeta7.setDisplayName("§bЗамороженная пещера");
            itemMeta7.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
            location7.setItemMeta(itemMeta7);
        }
    }
}