package me.topilov.Commands;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import javax.annotation.Nonnull;

public class TestCMD implements CommandExecutor {

    SQLGetter data = App.getInstance().data;

    ItemStack wooden_pickaxe = new ItemStack(Material.WOODEN_PICKAXE);

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if(cmd.getName().equalsIgnoreCase("test")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "You cannot use this");
                return true;
            }

            Player player = (Player) sender;

            player.sendMessage("x " +  player.getLocation().getX() + " y " + player.getLocation().getY() + " z " + player.getLocation().getZ());

        }
        return true;
    }
}