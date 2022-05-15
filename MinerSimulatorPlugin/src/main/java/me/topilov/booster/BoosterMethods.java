package me.topilov.booster;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import org.bukkit.Bukkit;

public class BoosterMethods {

    public static void onDisablePlugin(){
        SQLGetter data = App.getInstance().data;

        int globalBoosterBalance = data.getGlobalBoosterBalance(App.getInstance().getName());
        int globalBoosterEXP = data.getGlobalBoosterEXP(App.getInstance().getName());
        int globalBoosterBlocks = data.getGlobalBoosterBlocks(App.getInstance().getName());
        int globalBoosterArtefacts = data.getGlobalBoosterArtefacts(App.getInstance().getName());

        Bukkit.getOnlinePlayers().forEach(onlinePlayers -> {
            int localBoosterBalance = data.getLocalBoosterBalance(onlinePlayers.getUniqueId());
            int localBoosterEXP = data.getLocalBoosterEXP(onlinePlayers.getUniqueId());
            int localBoosterBlocks = data.getLocalBoosterBlocks(onlinePlayers.getUniqueId());
            int localBoosterArtefacts = data.getLocalBoosterArtefacts(onlinePlayers.getUniqueId());

            data.removeBoosterBalance(onlinePlayers.getUniqueId(), localBoosterBalance);
            data.removeBoosterEXP(onlinePlayers.getUniqueId(), localBoosterEXP);
            data.removeBoosterBlocks(onlinePlayers.getUniqueId(), localBoosterBlocks);
            data.removeBoosterArtefacts(onlinePlayers.getUniqueId(), localBoosterArtefacts);

            data.setLocalBoosterBalance(onlinePlayers.getUniqueId(), 0);
            data.setLocalBoosterEXP(onlinePlayers.getUniqueId(), 0);
            data.setLocalBoosterBlocks(onlinePlayers.getUniqueId(), 0);
            data.setLocalBoosterArtefacts(onlinePlayers.getUniqueId(), 0);
        });

        Bukkit.getOnlinePlayers().forEach(onlinePlayers -> {
            data.removeBoosterBalance(onlinePlayers.getUniqueId(), globalBoosterBalance);
            data.removeBoosterEXP(onlinePlayers.getUniqueId(), globalBoosterEXP);
            data.removeBoosterBlocks(onlinePlayers.getUniqueId(), globalBoosterBlocks);
            data.removeBoosterArtefacts(onlinePlayers.getUniqueId(), globalBoosterArtefacts);
        });
        data.setGlobalBoosterBalance(App.getInstance().getName(), 0);
        data.setGlobalBoosterEXP(App.getInstance().getName(), 0);
        data.setGlobalBoosterBlocks(App.getInstance().getName(), 0);
        data.setGlobalBoosterArtefacts(App.getInstance().getName(), 0);

    }



}
