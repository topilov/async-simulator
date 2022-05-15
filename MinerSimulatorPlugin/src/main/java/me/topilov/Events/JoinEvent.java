package me.topilov.Events;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    SQLGetter data = App.getInstance().data;

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Server server = App.getInstance().getServer();

        int globalBoosterBalance = data.getGlobalBoosterBalance(App.getInstance().getName());
        int globalBoosterEXP = data.getGlobalBoosterEXP(App.getInstance().getName());
        int globalBoosterBlocks = data.getGlobalBoosterBlocks(App.getInstance().getName());
        int globalBoosterArtefacts = data.getGlobalBoosterArtefacts(App.getInstance().getName());

        data.createPlayer(player);
        data.createBoosters(server);
        data.createLocalBoosters(player);

        data.addBoosterBalance(player.getUniqueId(), globalBoosterBalance);
        data.addBoosterEXP(player.getUniqueId(), globalBoosterEXP);
        data.addBoosterBlocks(player.getUniqueId(), globalBoosterBlocks);
        data.addBoosterArtefacts(player.getUniqueId(), globalBoosterArtefacts);
    }
}
