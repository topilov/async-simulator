package me.topilom.mainplugin.Events;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    MainPlugin plugin;

    public MySQL SQL;
    public SQLGetter data;

    public JoinEvent(MainPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(plugin);

        Player player = event.getPlayer();
        Server server = plugin.getServer();

        int globalBoosterBalance = data.getGlobalBoosterBalance(plugin.getName());
        int globalBoosterEXP = data.getGlobalBoosterEXP(plugin.getName());
        int globalBoosterBlocks = data.getGlobalBoosterBlocks(plugin.getName());
        int globalBoosterArtefacts = data.getGlobalBoosterArtefacts(plugin.getName());

        data.createPlayer(player);
        data.createBoosters(server);
        data.createLocalBoosters(player);

        data.addBoosterBalance(player.getUniqueId(), globalBoosterBalance);
        data.addBoosterEXP(player.getUniqueId(), globalBoosterEXP);
        data.addBoosterBlocks(player.getUniqueId(), globalBoosterBlocks);
        data.addBoosterArtefacts(player.getUniqueId(), globalBoosterArtefacts);
    }
}
