package me.topilom.sql;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLGetter {


    private MainPlugin plugin;
    public SQLGetter(MainPlugin plugin) {
        this.plugin = plugin;
    }

    public void createTablePlayers() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS players "
                    + "(name VARCHAR(100),uuid VARCHAR(100),rebirth INT(100) NOT NULL,level INT(100) NOT NULL DEFAULT '1',bits INT(100) NOT NULL,blocksBP INT(100) NOT NULL,backpack INT(100) NOT NULL DEFAULT '50',blocks INT(100) NOT NULL,artefacts INT(100) NOT NULL,exp INT(100) NOT NULL,boosterBalance INT(100) NOT NULL DEFAULT '1',boosterEXP INT(100) NOT NULL DEFAULT '1',boosterBlocks INT(100) NOT NULL DEFAULT '1',boosterArtefacts INT(100) NOT NULL DEFAULT '1', PRIMARY KEY (NAME))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if (!exists(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT IGNORE INTO players"
                        + " (name,uuid) VALUES (?,?)");
                ps2.setString(1, player.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();

                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(UUID uuid){
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());

            ResultSet results = ps.executeQuery();
            if(results.next()) {
                // player is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createTableBoosters() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS boosters "
                    + "(uuid VARCHAR(100),boosterBalance INT(100) NOT NULL DEFAULT '0',boosterEXP INT(100) NOT NULL DEFAULT '0',boosterBlocks INT(100) NOT NULL DEFAULT '0',boosterArtefacts INT(100) NOT NULL DEFAULT '0', PRIMARY KEY (UUID))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createBoosters(Server server) {
        try {
            String serverID = plugin.getName();
            if (!existsBooster(serverID)) {
                PreparedStatement ps3 = plugin.SQL.getConnection().prepareStatement("INSERT IGNORE INTO boosters"
                        + " (uuid) VALUES (?)");
                ps3.setString(1, serverID);
                ps3.executeUpdate();

                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existsBooster(String server){
        try {
            PreparedStatement ps4 = plugin.SQL.getConnection().prepareStatement("SELECT * FROM boosters WHERE uuid=?");
            ps4.setString(1, server.toString());

            ResultSet results = ps4.executeQuery();
            if(results.next()) {
                // player is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void createTableLocalBoosters() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS localboosters "
                    + "(name VARCHAR(100),uuid VARCHAR(100),boosterBalance INT(100) NOT NULL DEFAULT '0',boosterEXP INT(100) NOT NULL DEFAULT '0',boosterBlocks INT(100) NOT NULL DEFAULT '0',boosterArtefacts INT(100) NOT NULL DEFAULT '0', PRIMARY KEY (NAME))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createLocalBoosters(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if (!existsLocalBoosters(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT IGNORE INTO localboosters"
                        + " (name,uuid) VALUES (?,?)");
                ps2.setString(1, player.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();

                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existsLocalBoosters(UUID uuid){
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM localboosters WHERE uuid=?");
            ps.setString(1, uuid.toString());

            ResultSet results = ps.executeQuery();
            if(results.next()) {
                // player is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public void addBlocks(UUID uuid, int blocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET blocks=? WHERE uuid=?");
            ps.setInt(1, (getBlocks(uuid) +  blocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBlocks(UUID uuid, int blocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET blocks=? WHERE uuid=?");
            ps.setInt(1, (getBlocks(uuid) -  blocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBlocks(UUID uuid, int blocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET blocks=? WHERE uuid=?");
            ps.setInt(1, (blocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBlocks(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT blocks FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            int blocks = 0;
            if (rs.next()) {
                blocks = rs.getInt("blocks");
                return blocks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void addBits(UUID uuid, int bits) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET bits=? WHERE uuid=?");
            ps.setInt(1, (getBits(uuid) +  bits));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBits(UUID uuid, int bits) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET bits=? WHERE uuid=?");
            ps.setInt(1, (getBits(uuid) -  bits));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBits(UUID uuid, int bits) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET bits=? WHERE uuid=?");
            ps.setInt(1, (bits));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBits(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT bits FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int bits = 0;
            if (rs.next()) {
                bits = rs.getInt("bits");
                return bits;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addRebirth(UUID uuid, int rebirth) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET rebirth=? WHERE uuid=?");
            ps.setInt(1, (getRebirth(uuid) +  rebirth));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeRebirth(UUID uuid, int rebirth) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET rebirth=? WHERE uuid=?");
            ps.setInt(1, (getRebirth(uuid) -  rebirth));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setRebirth(UUID uuid, int rebirth) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET rebirth=? WHERE uuid=?");
            ps.setInt(1, (rebirth));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRebirth(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT rebirth FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int rebirth = 0;
            if (rs.next()) {
                rebirth = rs.getInt("rebirth");
                return rebirth;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addLevel(UUID uuid, int level) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET level=? WHERE uuid=?");
            ps.setInt(1, (getLevel(uuid) +  level));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeLevel(UUID uuid, int level) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET level=? WHERE uuid=?");
            ps.setInt(1, (getLevel(uuid) -  level));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLevel(UUID uuid, int level) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET level=? WHERE uuid=?");
            ps.setInt(1, (level));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLevel(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT level FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int level = 1;
            if (rs.next()) {
                level = rs.getInt("level");
                return level;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    public void addExp(UUID uuid, int exp) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET exp=? WHERE uuid=?");
            ps.setInt(1, (getExp(uuid) +  exp));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeExp(UUID uuid, int exp) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET exp=? WHERE uuid=?");
            ps.setInt(1, (getExp(uuid) -  exp));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setExp(UUID uuid, int exp) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET exp=? WHERE uuid=?");
            ps.setInt(1, (exp));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getExp(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT exp FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int exp = 1;
            if (rs.next()) {
                exp = rs.getInt("exp");
                return exp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    public void addArtefacts(UUID uuid, int artefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET artefacts=? WHERE uuid=?");
            ps.setInt(1, (getArtefacts(uuid) +  artefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeArtefacts(UUID uuid, int artefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET artefacts=? WHERE uuid=?");
            ps.setInt(1, (getArtefacts(uuid) -  artefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setArtefacts(UUID uuid, int artefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET artefacts=? WHERE uuid=?");
            ps.setInt(1, (artefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getArtefacts(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT artefacts FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int artefacts = 1;
            if (rs.next()) {
                artefacts = rs.getInt("artefacts");
                return artefacts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void addBackPack(UUID uuid, int backpack) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET backpack=? WHERE uuid=?");
            ps.setInt(1, (getBackPack(uuid) +  backpack));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBackPack(UUID uuid, int backpack) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET backpack=? WHERE uuid=?");
            ps.setInt(1, (getBackPack(uuid) -  backpack));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBackPack(UUID uuid, int backpack) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET backpack=? WHERE uuid=?");
            ps.setInt(1, (backpack));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBackPack(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT backpack FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int backpack = 1;
            if (rs.next()) {
                backpack = rs.getInt("backpack");
                return backpack;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addBlocksBP(UUID uuid, int blocksBP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET blocksBP=? WHERE uuid=?");
            ps.setInt(1, (getBlocksBP(uuid) +  blocksBP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBlocksBP(UUID uuid, int blocksBP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET blocksBP=? WHERE uuid=?");
            ps.setInt(1, (getBlocksBP(uuid) -  blocksBP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBlocksBP(UUID uuid, int blocksBP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET blocksBP=? WHERE uuid=?");
            ps.setInt(1, (blocksBP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBlocksBP(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT blocksBP FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int blocksBP = 1;
            if (rs.next()) {
                blocksBP = rs.getInt("blocksBP");
                return blocksBP;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    public void addBoosterBlocks(UUID uuid, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (getBoosterBlocks(uuid) +  boosterBlocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBoosterBlocks(UUID uuid, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (getBoosterBlocks(uuid) -  boosterBlocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBoosterBlocks(UUID uuid, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (boosterBlocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBoosterBlocks(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterBlocks FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterBlocks = 1;
            if (rs.next()) {
                boosterBlocks = rs.getInt("boosterBlocks");
                return boosterBlocks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void addBoosterEXP(UUID uuid, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (getBoosterEXP(uuid) +  boosterEXP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBoosterEXP(UUID uuid, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (getBoosterEXP(uuid) -  boosterEXP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBoosterEXP(UUID uuid, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (boosterEXP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBoosterEXP(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterEXP FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterEXP = 1;
            if (rs.next()) {
                boosterEXP = rs.getInt("boosterEXP");
                return boosterEXP;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void addBoosterBalance(UUID uuid, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (getBoosterBalance(uuid) +  boosterBalance));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBoosterBalance(UUID uuid, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (getBoosterBalance(uuid) -  boosterBalance));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBoosterBalance(UUID uuid, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (boosterBalance));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBoosterBalance(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterBalance FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterBalance = 1;
            if (rs.next()) {
                boosterBalance = rs.getInt("boosterBalance");
                return boosterBalance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void addBoosterArtefacts(UUID uuid, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (getBoosterArtefacts(uuid) +  boosterArtefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBoosterArtefacts(UUID uuid, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (getBoosterArtefacts(uuid) -  boosterArtefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBoosterArtefacts(UUID uuid, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE players SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (boosterArtefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBoosterArtefacts(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterArtefacts FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterArtefacts = 1;
            if (rs.next()) {
                boosterArtefacts = rs.getInt("boosterArtefacts");
                return boosterArtefacts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addGlobalBoosterBalance(String serverID, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterBalance(serverID) +  boosterBalance));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeGlobalBoosterBalance(String serverID, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterBalance(serverID) -  boosterBalance));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGlobalBoosterBalance(String serverID, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (boosterBalance));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getGlobalBoosterBalance(String serverID) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterBalance FROM boosters WHERE uuid=?");
            ps.setString(1, serverID);
            ResultSet rs = ps.executeQuery();

            int boosterBalance = 1;
            if (rs.next()) {
                boosterBalance = rs.getInt("boosterBalance");
                return boosterBalance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addGlobalBoosterEXP(String serverID, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterEXP(serverID) +  boosterEXP));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeGlobalBoosterEXP(String serverID, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterEXP(serverID) -  boosterEXP));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGlobalBoosterEXP(String serverID, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (boosterEXP));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getGlobalBoosterEXP(String serverID) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterEXP FROM boosters WHERE uuid=?");
            ps.setString(1, serverID);
            ResultSet rs = ps.executeQuery();

            int boosterEXP = 1;
            if (rs.next()) {
                boosterEXP = rs.getInt("boosterEXP");
                return boosterEXP;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addGlobalBoosterBlocks(String serverID, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterBlocks(serverID) +  boosterBlocks));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeGlobalBoosterBlocks(String serverID, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterBlocks(serverID) -  boosterBlocks));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGlobalBoosterBlocks(String serverID, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (boosterBlocks));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getGlobalBoosterBlocks(String serverID) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterBlocks FROM boosters WHERE uuid=?");
            ps.setString(1, serverID);
            ResultSet rs = ps.executeQuery();

            int boosterBlocks = 1;
            if (rs.next()) {
                boosterBlocks = rs.getInt("boosterBlocks");
                return boosterBlocks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addGlobalBoosterArtefacts(String serverID, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterArtefacts(serverID) +  boosterArtefacts));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeGlobalBoosterArtefacts(String serverID, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (getGlobalBoosterArtefacts(serverID) -  boosterArtefacts));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGlobalBoosterArtefacts(String serverID, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE boosters SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (boosterArtefacts));
            ps.setString(2, serverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getGlobalBoosterArtefacts(String serverID) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterArtefacts FROM boosters WHERE uuid=?");
            ps.setString(1, serverID);
            ResultSet rs = ps.executeQuery();

            int boosterArtefacts = 1;
            if (rs.next()) {
                boosterArtefacts = rs.getInt("boosterArtefacts");
                return boosterArtefacts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addLocalBoosterBalance(UUID uuid, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterBalance(uuid) +  boosterBalance));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeLocalBoosterBalance(UUID uuid, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterBalance(uuid) -  boosterBalance));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLocalBoosterBalance(UUID uuid, int boosterBalance) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterBalance=? WHERE uuid=?");
            ps.setInt(1, (boosterBalance));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLocalBoosterBalance(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterBalance FROM localboosters WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterBalance = 1;
            if (rs.next()) {
                boosterBalance = rs.getInt("boosterBalance");
                return boosterBalance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addLocalBoosterEXP(UUID uuid, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterEXP(uuid) +  boosterEXP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeLocalBoosterEXP(UUID uuid, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterEXP(uuid) -  boosterEXP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLocalBoosterEXP(UUID uuid, int boosterEXP) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterEXP=? WHERE uuid=?");
            ps.setInt(1, (boosterEXP));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLocalBoosterEXP(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterEXP FROM localboosters WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterEXP = 1;
            if (rs.next()) {
                boosterEXP = rs.getInt("boosterEXP");
                return boosterEXP;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addLocalBoosterBlocks(UUID uuid, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterBlocks(uuid) +  boosterBlocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeLocalBoosterBlocks(UUID uuid, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterBlocks(uuid) -  boosterBlocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLocalBoosterBlocks(UUID uuid, int boosterBlocks) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterBlocks=? WHERE uuid=?");
            ps.setInt(1, (boosterBlocks));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLocalBoosterBlocks(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterBlocks FROM localboosters WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterBlocks = 1;
            if (rs.next()) {
                boosterBlocks = rs.getInt("boosterBlocks");
                return boosterBlocks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addLocalBoosterArtefacts(UUID uuid, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterArtefacts(uuid) +  boosterArtefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeLocalBoosterArtefacts(UUID uuid, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (getLocalBoosterArtefacts(uuid) -  boosterArtefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLocalBoosterArtefacts(UUID uuid, int boosterArtefacts) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE localboosters SET boosterArtefacts=? WHERE uuid=?");
            ps.setInt(1, (boosterArtefacts));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLocalBoosterArtefacts(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT boosterArtefacts FROM localboosters WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            int boosterArtefacts = 1;
            if (rs.next()) {
                boosterArtefacts = rs.getInt("boosterArtefacts");
                return boosterArtefacts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
