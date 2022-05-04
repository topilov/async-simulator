package me.topilom.mainplugin.Commands;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemsSell implements CommandExecutor {

    private final Economy economy = MainPlugin.economy;
    MainPlugin main;

    public ItemsSell(MainPlugin main) {
        this.main = main;
    }

    public MySQL SQL;
    public SQLGetter data;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(main);

        if(cmd.getName().equalsIgnoreCase("sellall")) {

            if(!(sender instanceof Player)) return true;

            Player player = (Player) sender;

            int get = data.getBlocksBP(player.getUniqueId());
            int booster = data.getBoosterBalance(player.getUniqueId());

            data.removeBlocksBP(player.getUniqueId(), get);

            economy.depositPlayer(player, 10 * get * booster);

            player.sendTitle(ChatColor.GREEN + "Предметы проданы", "");

        }
        return true;
    }
}
