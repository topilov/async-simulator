package me.topilov.Commands;

import me.topilov.NPCs.NPC;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class CreateNPC implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if(cmd.getName().equalsIgnoreCase("createnpc")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "You cannot use this");
                return true;
            }
            Player player = (Player) sender;
            if (args.length != 2) {
                player.sendTitle(ChatColor.RED + "Usage:", "/createnpc [skinName] [nameNPC]");
                return true;
            }
            NPC.createNPC(player, args[0], args[1]);
            player.sendTitle(ChatColor.GREEN + "NPC created", "", 20, 40, 20);
        }
        return true;
    }
}