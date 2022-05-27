package me.topilov.ScoreBoard;

import me.clip.placeholderapi.PlaceholderAPI;
import me.topilov.App;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

public class ScoreBoard implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        createBoard(player);
        startReloadingScoreBoard(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        stopReloadingScoreBoard();
    }

    public void createBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("simulator-1", "dummy", "§e         Симулятор         ");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        String level_placeHolder =  " §fУровень: §6%mysql_level% Ур.";
        String level = PlaceholderAPI.setPlaceholders(player, level_placeHolder);
        String rebirth_placeHolder =  " §fРебитхов: §a%mysql_rebirth%";
        String rebirth = PlaceholderAPI.setPlaceholders(player, rebirth_placeHolder);
        String exp_placeHolder =  " §fОпыт: §b%mysql_exp%";
        String exp = PlaceholderAPI.setPlaceholders(player, exp_placeHolder);
        String bits_placeHolder =  " §fБитсы: §d%mysql_bits%";
        String bits = PlaceholderAPI.setPlaceholders(player, bits_placeHolder);
        String balance_placeHolder =  " §fБаланс: §a%vault_eco_balance_formatted%";
        String balance = PlaceholderAPI.setPlaceholders(player, balance_placeHolder);
        String backpack_placeHolder =  " §fРюкзак: §6%mysql_blocksbp%/§7%mysql_backpack%";
        String backpack = PlaceholderAPI.setPlaceholders(player, backpack_placeHolder);
        String blocks_placeHolder =  " §fДобыто: §e%mysql_blocks%";
        String blocks = PlaceholderAPI.setPlaceholders(player, blocks_placeHolder);
        String artefacts_placeHolder =  " §fАртефактов: §6%mysql_artefacts%";
        String artefacts = PlaceholderAPI.setPlaceholders(player, artefacts_placeHolder);
        String online_placeHolder =  " §fОнлайн: §6%server_online%";
        String online = PlaceholderAPI.setPlaceholders(player, online_placeHolder);

        Score score = obj.getScore("           ");
        Score score2 = obj.getScore(level);
        Score score3 = obj.getScore(rebirth);
        Score score4 = obj.getScore(exp);
        Score score5 = obj.getScore("    ");
        Score score6 = obj.getScore(bits);
        Score score7 = obj.getScore(balance);
        Score score8 = obj.getScore("     ");
        Score score9 = obj.getScore(backpack);
        Score score10 = obj.getScore(blocks);
        Score score11 = obj.getScore(artefacts);
        Score score12 = obj.getScore("        ");
        Score score14 = obj.getScore("         ");
        Score score13 = obj.getScore(online);
        Score score15 = obj.getScore("            www.async.ru");
        score.setScore(14);
        score2.setScore(13);
        score3.setScore(12);
        score4.setScore(11);
        score5.setScore(10);
        score6.setScore(9);
        score7.setScore(8);
        score8.setScore(7);
        score9.setScore(6);
        score10.setScore(5);
        score11.setScore(4);
        score12.setScore(3);
        score13.setScore(2);
        score14.setScore(1);
        score15.setScore(0);
        player.setScoreboard(board);
    }

    public int taskID;

    public void startReloadingScoreBoard(Player player) {
        taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(App.getPlugin(App.class), new Runnable() {
            @Override
            public void run() {
                createBoard(player);
            }
        }, 5, 5);
    }

    public void stopReloadingScoreBoard() {
        Bukkit.getServer().getScheduler().cancelTask(taskID);
    }
}
