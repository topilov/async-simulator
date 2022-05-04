package me.topilom.mainplugin.GUI;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
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

import java.util.ArrayList;

public class LocationsGUI implements CommandExecutor {

    public ItemStack location1 = new ItemStack(Material.SANDSTONE);
    public ItemStack location2 = new ItemStack(Material.STONE_SLAB);
    public ItemStack location3 = new ItemStack(Material.CRACKED_STONE_BRICKS);
    public ItemStack location4 = new ItemStack(Material.BROWN_TERRACOTTA);
    public ItemStack location5 = new ItemStack(Material.YELLOW_TERRACOTTA);
    public ItemStack location6 = new ItemStack(Material.QUARTZ_BLOCK);

    MainPlugin main;

    public LocationsGUI(MainPlugin main) {
        this.main = main;
    }

    public MySQL SQL;
    public SQLGetter data;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(main);

        if (cmd.getName().equalsIgnoreCase("locations")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }

            Player player = (Player) sender;
            int level = data.getLevel(player.getUniqueId());

            if (args.length == 0) {

                Inventory locations = Bukkit.getServer().createInventory(null, 9, "Локации");

                ArrayList<String> lore = new ArrayList<String>();


                ItemMeta metaref = location1.getItemMeta();


                lore.add("");
                lore.add("§6На 1 локации ты можешь ломать:");
                lore.add(" §f- §eПесчаник");
                lore.add(" §f- §eЭндерняк");
                metaref.setLore(lore);
                metaref.setDisplayName("§6Локация 1");


                metaref.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                location1.setItemMeta(metaref);
                locations.setItem(1, location1);

                // NEW SLOT

                ArrayList<String> lore_2 = new ArrayList<String>();


                ItemMeta metaref_2 = location2.getItemMeta();


                lore_2.add("");
                lore_2.add("§6На 2 локации ты можешь ломать:");
                lore_2.add(" §f- §eКаменные плиты");
                metaref_2.setLore(lore_2);
                metaref_2.setDisplayName("§6Локация 2");


                metaref_2.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                location2.setItemMeta(metaref_2);
                locations.setItem(2, location2);

                // NEW SLOT

                ArrayList<String> lore_3 = new ArrayList<String>();


                ItemMeta metaref_3 = location3.getItemMeta();


                lore_3.add("");
                lore_3.add("§6На 3 локации ты можешь ломать:");
                lore_3.add(" §f- §eПотрескавшиеся каменные кирпичи");
                metaref_3.setLore(lore_3);
                metaref_3.setDisplayName("§6Локация 3");


                metaref_3.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                location3.setItemMeta(metaref_3);
                locations.setItem(3, location3);

                // NEW SLOT

                ArrayList<String> lore_4 = new ArrayList<String>();


                ItemMeta metaref_4 = location4.getItemMeta();


                lore_4.add("");
                lore_4.add("§6На 4 локации ты можешь ломать:");
                lore_4.add(" §f- §eКоричневую терракоту");
                metaref_4.setLore(lore_4);
                metaref_4.setDisplayName("§6Локация 4");


                metaref_4.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                location4.setItemMeta(metaref_4);
                locations.setItem(4, location4);

                // NEW SLOT

                ArrayList<String> lore_5 = new ArrayList<String>();


                ItemMeta metaref_5 = location5.getItemMeta();


                lore_5.add("");
                lore_5.add("§6На 5 локации ты можешь ломать:");
                lore_5.add(" §f- §eЖелтая терракота");
                metaref_5.setLore(lore_5);
                metaref_5.setDisplayName("§6Локация 5");


                metaref_5.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                location5.setItemMeta(metaref_5);
                locations.setItem(5, location5);

                // NEW SLOT

                ArrayList<String> lore_6 = new ArrayList<String>();


                ItemMeta metaref_6 = location6.getItemMeta();


                lore_6.add("");
                lore_6.add("§6На 6 локации ты можешь ломать:");
                lore_6.add(" §f- §eКварцевый блок");
                metaref_6.setLore(lore_6);
                metaref_6.setDisplayName("§6Локация 6");


                metaref_6.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                location6.setItemMeta(metaref_6);
                locations.setItem(6, location6);

                player.openInventory(locations);

                return true;
            }


            if(args[0].equalsIgnoreCase("1")) {
                player.teleport(new Location(Bukkit.getWorld("world"), -21.430, 124, 486.575));
            }
            if(args[0].equalsIgnoreCase("2")) {
                if(level < 2) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), 53.429, 130, 269.473));
            }
            if(args[0].equalsIgnoreCase("3")) {
                if(level < 3) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -142.226, 134, 68.533));
            }
            if(args[0].equalsIgnoreCase("4")) {
                if(level < 4) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -333.412, 109, 44.940));
            }
            if(args[0].equalsIgnoreCase("5")) {
                if(level < 5) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -178.554, 154, -84.603));
            }
            if(args[0].equalsIgnoreCase("6")) {
                if(level < 6) {
                    player.sendMessage(ChatColor.RED + "Уровень мал для этой локации");
                    return true;
                }
                player.teleport(new Location(Bukkit.getWorld("world"), -556.603, 137, 151.178));
            }
        }
        return true;
    }
}