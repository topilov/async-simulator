package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Skull implements CommandExecutor {
    public Skull(MainPlugin mainPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("skull")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "Ты не можешь это использовать потому что ты консоль");
            }
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.GOLD  + "Тебе выдана голова игрока " + ChatColor.RED + player.getName());
                player.getInventory().addItem(getPlayerHead(player.getName()));
                return true;
            }
            player.sendMessage(ChatColor.GOLD  + "Тебе выдана голова игрока " + ChatColor.RED + args[0]);
            player.getInventory().addItem(getPlayerHead(args[0]));
            return true;
        }
        return false;
    }

    public ItemStack getPlayerHead(String player) {

        boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");

        Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
        ItemStack item = new ItemStack(type, 1);

        if (!isNewVersion)
            item.setDurability((short) 3);

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(player);

        item.setItemMeta(meta);

        return item;
    }
}
