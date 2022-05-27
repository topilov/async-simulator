package me.topilov.Events;

import me.topilov.App;
import me.topilov.NPCs.NPC;
import me.topilov.sql.SQLGetter;
import me.topilov.utils.PacketReader;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Material.WOODEN_PICKAXE;

public class JoinEvent implements Listener {

    public ItemStack wooden_pickaxe = new ItemStack(WOODEN_PICKAXE);
    SQLGetter data = App.getInstance().data;

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Server server = App.getInstance().getServer();

        event.setJoinMessage("");

        /*
        if player doesn't play before
        */
        if (!event.getPlayer().hasPlayedBefore()) {
            setMetaWoodenPickaxe();
            player.getInventory().addItem(wooden_pickaxe);
        }

        /*
        DataBase
        */
        addBoosters(player);
        createTables(player, server);

        /*
        NPC Packets
        */
        Bukkit.getServer().getScheduler().runTaskTimer(App.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                NPC.addJoinPacket(player);
            }
        }, 20, 100);
        PacketReader reader = new PacketReader();
        reader.inject(event.getPlayer());
    }

    private void createTables(Player player, Server server) {
        data.createPlayer(player);
        data.createBoosters(server);
        data.createLocalBoosters(player);
    }

    private void addBoosters(Player player) {
        int globalBoosterBalance = data.getGlobalBoosterBalance(App.getInstance().getName());
        int globalBoosterEXP = data.getGlobalBoosterEXP(App.getInstance().getName());
        int globalBoosterBlocks = data.getGlobalBoosterBlocks(App.getInstance().getName());
        int globalBoosterArtefacts = data.getGlobalBoosterArtefacts(App.getInstance().getName());

        data.addBoosterBalance(player.getUniqueId(), globalBoosterBalance);
        data.addBoosterEXP(player.getUniqueId(), globalBoosterEXP);
        data.addBoosterBlocks(player.getUniqueId(), globalBoosterBlocks);
        data.addBoosterArtefacts(player.getUniqueId(), globalBoosterArtefacts);
    }

    private void setMetaWoodenPickaxe() {
        ItemMeta itemMeta = wooden_pickaxe.getItemMeta();
        if (itemMeta == null) return;
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName(ChatColor.AQUA + "Кирка ур.1");
        wooden_pickaxe.setItemMeta(itemMeta);
    }
}
