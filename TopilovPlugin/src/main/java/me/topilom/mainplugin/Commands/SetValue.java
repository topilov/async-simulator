package me.topilom.mainplugin.Commands;

import me.topilom.mainplugin.MainPlugin;
import me.topilom.sql.MySQL;
import me.topilom.sql.SQLGetter;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetValue implements CommandExecutor {

    MainPlugin plugin;

    public SetValue(MainPlugin plugin) {
        this.plugin = plugin;
    }

    public MySQL SQL;
    public SQLGetter data;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        this.SQL = new MySQL();
        this.data = new SQLGetter(plugin);

        if(cmd.getName().equalsIgnoreCase("setvalue")) {

            if (args.length != 3) return true;

            if (args[0].equalsIgnoreCase("rebirth")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountRebirth = args[2];

                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setRebirth(argPlayer.getUniqueId(), Integer.parseInt(amountRebirth));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен " + amountRebirth + " rebirth");
                return true;
            }



            if (args[0].equalsIgnoreCase("level")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountLevel = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setLevel(argPlayer.getUniqueId(), Integer.parseInt(amountLevel));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен " + amountLevel + " уровень");
                return true;
            }


            if (args[0].equalsIgnoreCase("blocks")) {
                Player player = (Player) sender;

                String playerName = args[1];
                String amountBlocks = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBlocks(argPlayer.getUniqueId(), Integer.parseInt(amountBlocks));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amountBlocks + " блоков");
                return true;
            }


            if (args[0].equalsIgnoreCase("bits")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountBits = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBits(argPlayer.getUniqueId(), Integer.parseInt(amountBits));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amountBits + " битсов");
                return true;
            }

            if (args[0].equalsIgnoreCase("artefacts")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountArtefacts = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setArtefacts(argPlayer.getUniqueId(), Integer.parseInt(amountArtefacts));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amountArtefacts + " артефактов");
                return true;
            }

            if (args[0].equalsIgnoreCase("blocksbp")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountBlocksBP = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBlocksBP(argPlayer.getUniqueId(), Integer.parseInt(amountBlocksBP));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amountBlocksBP + " блоков в рюкзак");
                return true;
            }

            if (args[0].equalsIgnoreCase("backpack")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountBackPack = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBackPack(argPlayer.getUniqueId(), Integer.parseInt(amountBackPack));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен рюкзак с вместимостью " + amountBackPack);
                return true;
            }

            if (args[0].equalsIgnoreCase("exp")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountExp = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setExp(argPlayer.getUniqueId(), Integer.parseInt(amountExp));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amountExp + " опыта");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterExp")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountBoosterExp = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBoosterEXP(argPlayer.getUniqueId(), Integer.parseInt(amountBoosterExp));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен х" + amountBoosterExp + " бустер опыта");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterBlocks")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountBoosterBlocks = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBoosterBlocks(argPlayer.getUniqueId(), Integer.parseInt(amountBoosterBlocks));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено х" + amountBoosterBlocks + " бустер блоков");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterArtefacts")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountBoosterArtefacts = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBoosterArtefacts(argPlayer.getUniqueId(), Integer.parseInt(amountBoosterArtefacts));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено х" + amountBoosterArtefacts + " бустер артефактов");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterBalance")) {

                Player player = (Player) sender;

                String playerName = args[1];
                String amountBoosterBalance = args[2];


                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }

                Player argPlayer = plugin.getServer().getPlayer(playerName);
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBoosterBalance(argPlayer.getUniqueId(), Integer.parseInt(amountBoosterBalance));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено х" + amountBoosterBalance + " бустер денег");
                return true;
            }
        }
        return true;
    }
}
