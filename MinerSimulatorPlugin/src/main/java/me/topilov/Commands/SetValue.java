package me.topilov.Commands;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class SetValue implements CommandExecutor {
    SQLGetter data = App.getInstance().data;

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("setvalue")) {
            if (args.length != 3) {
                sender.sendMessage(ChatColor.RED + "Usage: /setvalue <databaseValue> <player> <value>");
                return true;
            }

            String playerName = args[1];
            String amount = args[2];
            Player argPlayer = App.getInstance().getServer().getPlayer(playerName);

            if (args[0].equalsIgnoreCase("rebirth")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setRebirth(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен " + amount + " rebirth");
                return true;
            }

            if (args[0].equalsIgnoreCase("level")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setLevel(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен " + amount + " уровень");
                return true;
            }

            if (args[0].equalsIgnoreCase("blocks")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setBlocks(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amount + " блоков");
                return true;
            }

            if (args[0].equalsIgnoreCase("bits")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setBits(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amount + " битсов");
                return true;
            }

            if (args[0].equalsIgnoreCase("artefacts")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setArtefacts(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amount + " артефактов");
                return true;
            }

            if (args[0].equalsIgnoreCase("blocksbp")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setBlocksBP(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amount + " блоков в рюкзак");
                return true;
            }

            if (args[0].equalsIgnoreCase("backpack")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setBackPack(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен рюкзак с вместимостью " + amount);
                return true;
            }

            if (args[0].equalsIgnoreCase("exp")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setExp(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено " + amount + " опыта");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterExp")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setBoosterEXP(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлен х" + amount + " бустер опыта");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterBlocks")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setBoosterBlocks(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено х" + amount + " бустер блоков");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterArtefacts")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }

                data.setBoosterArtefacts(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено х" + amount + " бустер артефактов");
                return true;
            }

            if (args[0].equalsIgnoreCase("boosterBalance")) {
                if (!(player.isOp())) {
                    player.sendMessage(ChatColor.RED + "Недостаточно прав");
                    return true;
                }
                if (argPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Игрок не в сети");
                    return true;
                }
                data.setBoosterBalance(argPlayer.getUniqueId(), Integer.parseInt(amount));
                player.sendMessage(ChatColor.YELLOW + "Игроку установлено х" + amount + " бустер денег");
                return true;
            }
        }
        return true;
    }
}
