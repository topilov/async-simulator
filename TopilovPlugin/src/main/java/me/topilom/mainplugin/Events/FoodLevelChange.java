package me.topilom.mainplugin.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

    @EventHandler
    public void FoodChange(FoodLevelChangeEvent e) {
        e.setFoodLevel(20);
    }
}
