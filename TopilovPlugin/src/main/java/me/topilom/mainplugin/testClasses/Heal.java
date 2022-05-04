package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    public Heal(MainPlugin mainPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("doctor")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("*консоль вылечена*");
                return true;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("doctor.use")) {
                player.sendMessage(ChatColor.RED + "Ты не можешь это использовать");
                return true;
            }
            if (args.length == 0) {
                TextComponent message = new TextComponent("Хотел бы ты исцелиться?");
                message.setColor(ChatColor.GOLD);
                message.setBold(true);
                message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                        new ComponentBuilder("Нажми здесь, чтобы исцелиться").color(ChatColor.AQUA).italic(true).create()));
                player.spigot().sendMessage(message);
                return true;
            }
            if (args[0].equalsIgnoreCase("healme")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal " + player.getName());
                player.sendMessage(ChatColor.GREEN + "Ты вылечен");
                return true;
            }
            player.sendMessage(ChatColor.RED + "/doctor");
            return true;
        }
        return true;
    }
}
