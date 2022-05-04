package me.topilom.mainplugin.Events;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    MainPlugin plugin;

    public MySQL SQL;
    public SQLGetter data;

    public QuitEvent(MainPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit (PlayerQuitEvent event) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(plugin);

        Player player = event.getPlayer();

        int globalBoosterBalance = data.getGlobalBoosterBalance(plugin.getName());
        int globalBoosterEXP = data.getGlobalBoosterEXP(plugin.getName());
        int globalBoosterBlocks = data.getGlobalBoosterBlocks(plugin.getName());
        int globalBoosterArtefacts = data.getGlobalBoosterArtefacts(plugin.getName());

        data.removeBoosterBalance(player.getUniqueId(), globalBoosterBalance);
        data.removeBoosterEXP(player.getUniqueId(), globalBoosterEXP);
        data.removeBoosterBlocks(player.getUniqueId(), globalBoosterBlocks);
        data.removeBoosterArtefacts(player.getUniqueId(), globalBoosterArtefacts);
    }
}
