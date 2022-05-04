package me.topilom.mainplugin;

import me.topilom.mainplugin.Commands.*;
import me.topilom.mainplugin.Events.*;
import me.topilom.mainplugin.GUI.*;
import me.topilom.mainplugin.GUIEvent.*;
import me.topilom.mainplugin.Vault.EconomyCommands;
import me.topilom.mainplugin.testClasses.*;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class MainPlugin extends JavaPlugin implements Listener {

    public MySQL SQL;
    public SQLGetter data;

    public static Economy economy;

    @Override
    public void onEnable() {

        this.SQL = new MySQL();
        this.data = new SQLGetter(this);

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            Bukkit.getLogger().info("Database not connected");
        }

        if (SQL.isConnected()) {
            Bukkit.getLogger().info("Database is connected!");
            data.createTablePlayers();
            data.createTableBoosters();
            data.createTableLocalBoosters();
            getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
            getServer().getPluginManager().registerEvents(new QuitEvent(this), this);
        }


        if (!setupEconomy()) {
            Bukkit.shutdown();
        }

        this.saveDefaultConfig();



        getServer().getPluginCommand("sellall").setExecutor(new ItemsSell(this));
        this.getCommand("eco").setExecutor(new EconomyCommands());
        getServer().getPluginCommand("upgrade").setExecutor(new UpgradeGUI(this));
        getServer().getPluginCommand("menu").setExecutor(new MenuGUI(this));
        getServer().getPluginCommand("locations").setExecutor(new LocationsGUI(this));
        getServer().getPluginCommand("rebirth").setExecutor(new RebirthGUI(this));
        getServer().getPluginCommand("level").setExecutor(new LevelGUI(this));
        getServer().getPluginCommand("bp").setExecutor(new BackPackGUI(this));
        getServer().getPluginCommand("bits").setExecutor(new BitsGUI(this));
        getServer().getPluginCommand("setvalue").setExecutor(new SetValue(this));
       // getServer().getPluginCommand("perks").setExecutor(new PerksGUI(this));
        //getServer().getPluginCommand("doctor").setExecutor(new Heal(this));
        //getServer().getPluginCommand("godboots").setExecutor(new GodBoots(this));
        //getServer().getPluginCommand("boost").setExecutor(new TridentGod(this));
        // getServer().getPluginCommand("changeteam").setExecutor(new ChangeTeamGUI(this));
        //getServer().getPluginCommand("gamble").setExecutor(new GambleCMD(this));
        //getServer().getPluginCommand("skull").setExecutor(new Skull(this));
        // getServer().getPluginCommand("randomblock").setExecutor(new TestWithConfig(this));

        getServer().getPluginManager().registerEvents(new UpgradeGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new MenuGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new RebirthGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new LocationsGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new LevelGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new BackPackGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropEvent(), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChange(), this);
        getServer().getPluginManager().registerEvents(new BitsGUIEvent(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(this), this);
        //getServer().getPluginManager().registerEvents(new RandomBlockBreak(this), this);
        //getServer().getPluginManager().registerEvents(new DragItemEventPerks(this), this);
        //getServer().getPluginManager().registerEvents(new GodBootsEvent(), this);
        //getServer().getPluginManager().registerEvents(new TridentGodEvent(), this);
        //getServer().getPluginManager().registerEvents(new ChangeTeamGUIEvent(), this);
        //getServer().getPluginManager().registerEvents(new GambleGUIEvent(), this);

    }

    @Override
    public Logger getSLF4JLogger() {
        return super.getSLF4JLogger();
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    @Override
    public void onDisable () {

        int globalBoosterBalance = data.getGlobalBoosterBalance(this.getName());
        int globalBoosterEXP = data.getGlobalBoosterEXP(this.getName());
        int globalBoosterBlocks = data.getGlobalBoosterBlocks(this.getName());
        int globalBoosterArtefacts = data.getGlobalBoosterArtefacts(this.getName());

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

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
        }


        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

        data.removeBoosterBalance(onlinePlayers.getUniqueId(), globalBoosterBalance);
        data.removeBoosterEXP(onlinePlayers.getUniqueId(), globalBoosterEXP);
        data.removeBoosterBlocks(onlinePlayers.getUniqueId(), globalBoosterBlocks);
        data.removeBoosterArtefacts(onlinePlayers.getUniqueId(), globalBoosterArtefacts);

    }
        data.setGlobalBoosterBalance(this.getName(), 0);
        data.setGlobalBoosterEXP(this.getName(), 0);
        data.setGlobalBoosterBlocks(this.getName(), 0);
        data.setGlobalBoosterArtefacts(this.getName(), 0);
        SQL.disconnect();
    }
}
