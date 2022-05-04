package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestWithConfig implements CommandExecutor {

    MainPlugin main;

    public TestWithConfig(MainPlugin main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("randomblock")) {
            if (!sender.hasPermission("randomblock.reload")) {
                sender.sendMessage(ChatColor.RED + "Ты не можешь использовать эту команду");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "/randomblock reload");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    for (String msg : main.getConfig().getStringList("reload.message")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                msg));
                    }
                    main.reloadConfig();
                }
            }
        }
        return false;
    }
}
