package me.topilov.Commands;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class ItemsSell implements CommandExecutor {
    private final Economy economy = App.economy;
    SQLGetter data = App.getInstance().data;

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if(cmd.getName().equalsIgnoreCase("sellall")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "You cannot use this");
                return true;
            }
            Player player = (Player) sender;
            int getBlocks = data.getBlocksBP(player.getUniqueId());
            int booster = data.getBoosterBalance(player.getUniqueId());

            for (int i = 1; i <= 6; i++) {
                if (args[0].equalsIgnoreCase("<" + i)) {
                    data.setBlocksBP(player.getUniqueId(), 0);
                    economy.depositPlayer(player, i * getBlocks * booster);
                    player.sendMessage("§8[§ai§8]§f Вы продали §b" + getBlocks + "§f блоков собирайте ещё!");
                }
            }
        }
        return true;
    }
}
