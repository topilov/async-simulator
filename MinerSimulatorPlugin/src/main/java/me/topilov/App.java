package me.topilov;

import me.topilov.Commands.ItemsSell;
import me.topilov.Commands.SetValue;
import me.topilov.Events.*;
import me.topilov.GUI.*;
import me.topilov.GUIEvent.*;
import me.topilov.Vault.EconomyCommands;
import me.topilov.booster.BoosterMethods;
import me.topilov.sql.MySQL;
import me.topilov.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class App extends JavaPlugin implements Listener {

    private static App instance;

    public MySQL SQL;
    public SQLGetter data;

    public static Economy economy;

    @Override
    public void onEnable() {

        instance = this;

        setupDatabase();

        if (!setupEconomy()) {
            Bukkit.getPluginManager().disablePlugin(this);
            Bukkit.getLogger().warning("Any plugins for economy not found! Please install eco plugin!");
        }

        setupCommands();

        setupEvents();
    }

    @Override
    public void onDisable () {
        BoosterMethods.onDisablePlugin();
        SQL.disconnect();
    }

    void setupEvents(){
        getServer().getPluginManager().registerEvents(new UpgradeGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new MenuGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new RebirthGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new LocationsGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new LevelGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new BackPackGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new MainEvents(), this);
        getServer().getPluginManager().registerEvents(new BitsGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new MineBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new CaseInteractEvent(), this);
    }

    void setupCommands(){
        getCommand("eco").setExecutor(new EconomyCommands());
        getServer().getPluginCommand("sellall").setExecutor(new ItemsSell());
        getServer().getPluginCommand("upgrade").setExecutor(new UpgradeGUI());
        getServer().getPluginCommand("menu").setExecutor(new MenuGUI());
        getServer().getPluginCommand("locations").setExecutor(new LocationsGUI());
        getServer().getPluginCommand("rebirth").setExecutor(new RebirthGUI());
        getServer().getPluginCommand("level").setExecutor(new LevelGUI());
        getServer().getPluginCommand("bp").setExecutor(new BackPackGUI());
        getServer().getPluginCommand("bits").setExecutor(new BitsGUI());
        getServer().getPluginCommand("setvalue").setExecutor(new SetValue());
    }

    void setupDatabase(){
        SQL = new MySQL();
        data = new SQLGetter();
        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            Bukkit.getLogger().warning("Database not connected");
        }
        if (SQL.isConnected()) {
            Bukkit.getLogger().info("Database is connected!");
            data.createTablePlayers();
            data.createTableBoosters();
            data.createTableLocalBoosters();
            getServer().getPluginManager().registerEvents(new JoinEvent(), this);
            getServer().getPluginManager().registerEvents(new QuitEvent(), this);
        }
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) { economy = economyProvider.getProvider(); }
        return (economy != null);
    }

    public static App getInstance() {
        return instance;
    }
}
