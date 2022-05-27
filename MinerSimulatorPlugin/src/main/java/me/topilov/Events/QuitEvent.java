package me.topilov.Events;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import me.topilov.utils.PacketReader;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {
    SQLGetter data = App.getInstance().data;
    PacketReader reader = new PacketReader();

    @EventHandler
    public void onQuit (PlayerQuitEvent event) {

        event.setQuitMessage(null);

        removeBoosters(event.getPlayer());
        reader.uninject(event.getPlayer());
    }

    private void removeBoosters(Player player) {
        int globalBoosterBalance = data.getGlobalBoosterBalance(App.getInstance().getName());
        int globalBoosterEXP = data.getGlobalBoosterEXP(App.getInstance().getName());
        int globalBoosterBlocks = data.getGlobalBoosterBlocks(App.getInstance().getName());
        int globalBoosterArtefacts = data.getGlobalBoosterArtefacts(App.getInstance().getName());

        data.removeBoosterBalance(player.getUniqueId(), globalBoosterBalance);
        data.removeBoosterEXP(player.getUniqueId(), globalBoosterEXP);
        data.removeBoosterBlocks(player.getUniqueId(), globalBoosterBlocks);
        data.removeBoosterArtefacts(player.getUniqueId(), globalBoosterArtefacts);
    }
}
