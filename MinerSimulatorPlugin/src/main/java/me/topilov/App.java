package me.topilov;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.topilov.Commands.CreateNPC;
import me.topilov.Commands.ItemsSell;
import me.topilov.Commands.SetValue;
import me.topilov.Commands.TestCMD;
import me.topilov.Events.*;
import me.topilov.GUI.*;
import me.topilov.GUIEvent.*;
import me.topilov.NPCs.ClickNPC;
import me.topilov.NPCs.NPC;
import me.topilov.ScoreBoard.ScoreBoard;
import me.topilov.Vault.EconomyCommands;
import me.topilov.booster.BoosterMethods;
import me.topilov.sql.MySQL;
import me.topilov.sql.SQLGetter;
import me.topilov.utils.DataManager;
import me.topilov.utils.PacketReader;
import net.milkbowl.vault.economy.Economy;
import net.minecraft.server.v1_13_R2.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.UUID;

public final class App extends JavaPlugin implements Listener {

    private static App instance;

    public MySQL SQL;
    public SQLGetter data;
    public static Economy economy;
    public static DataManager manager;

    @Override
    public void onEnable() {
        instance = this;
        manager = new DataManager(this);

        if (manager.getConfig().contains("data")) {
            loadNPC();
        }

        setupDatabase();

        if (!setupEconomy()) {
            Bukkit.getPluginManager().disablePlugin(this);
            Bukkit.getLogger().warning("Any plugins for economy not found! Please install eco plugin!");
        }

        setupCommands();

        setupEvents();

        this.saveDefaultConfig();

        if (!Bukkit.getOnlinePlayers().isEmpty())
            for (Player player : Bukkit.getOnlinePlayers()) {
                PacketReader reader = new PacketReader();
                reader.inject(player);
            }
    }

    @Override
    public void onDisable () {
        BoosterMethods.onDisablePlugin();
        SQL.disconnect();

        if (!Bukkit.getOnlinePlayers().isEmpty())
            for (Player player : Bukkit.getOnlinePlayers()) {
                PacketReader reader = new PacketReader();
                reader.uninject(player);
                for (EntityPlayer npc : NPC.getNPCs()) {
                    NPC.removeNPC(player, npc);
                }
            }
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
        getServer().getPluginManager().registerEvents(new ClickNPC(), this);
        getServer().getPluginManager().registerEvents(new DonateGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new ScoreBoard(), this);
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
        getServer().getPluginCommand("createnpc").setExecutor(new CreateNPC());
        getServer().getPluginCommand("donate").setExecutor(new DonateGUI());
        getServer().getPluginCommand("test").setExecutor(new TestCMD());
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

    public static FileConfiguration getData() {
        return manager.getConfig();
    }

    public static void saveData() {
        manager.saveConfig();
    }

    public void loadNPC() {
        FileConfiguration file = manager.getConfig();
        manager.getConfig().getConfigurationSection("data").getKeys(false).forEach(npc -> {
            Location location = new Location(Bukkit.getWorld(file.getString("data." + npc + ".world")),
                    file.getInt("data." + npc + ".x"), file.getInt("data." + npc + ".y"), file.getInt("data." + npc + ".z"));
            location.setPitch((float) file.getDouble("data." + npc + ".p"));
            location.setYaw((float) file.getDouble("data." + npc + ".yaw"));

            String name = file.getString("data." + npc + ".name");
            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), ChatColor.GRAY + name);
            gameProfile.getProperties().put("textures", new Property("textures", file.getString("data." + npc + ".text"),
                    file.getString("data." + npc + ".signature")));
            NPC.loadNPC(location, gameProfile);
        });
    }
}
