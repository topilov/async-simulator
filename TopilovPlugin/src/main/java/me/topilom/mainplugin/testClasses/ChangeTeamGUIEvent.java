package me.topilom.mainplugin.testClasses;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ChangeTeamGUIEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("Выбор команды")) {
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();

        if (e.getSlot() == 0 && e.getCurrentItem().getType() == Material.BLUE_CONCRETE) {
            //BLUE TEAM
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.BLUE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "Ты изменил свою команду");
        }
        if (e.getSlot() == 1 && e.getCurrentItem().getType() == Material.RED_CONCRETE) {
            //RED TEAM
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.RED);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "Ты изменил свою команду");
        }
        if (e.getSlot() == 2 && e.getCurrentItem().getType() == Material.LIME_CONCRETE) {
            //GREEN TEAM
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.LIME);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "Ты изменил свою команду");
        }
            if (e.getSlot() == 3 && e.getCurrentItem().getType() == Material.ORANGE_CONCRETE) {
             //ORANGE TEAM
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.ORANGE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "Ты изменил свою команду");
        }
            if (e.getSlot() == 4 && e.getCurrentItem().getType() == Material.PURPLE_CONCRETE) {
            //PURPLE TEAM
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.PURPLE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "Ты изменил свою команду");
        }
            if (e.getSlot() == 5 && e.getCurrentItem().getType() == Material.CYAN_CONCRETE) {
            //CYAN TEAM
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.AQUA);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "Ты изменил свою команду");
        }
        if (e.getSlot() == 6 && e.getCurrentItem().getType() == Material.BLACK_CONCRETE) {
            //BLACK TEAM
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.BLACK);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "Ты изменил свою команду");
        }
        if (e.getSlot() == 8) {
            //CLOSE BUTTON
            player.closeInventory();
            }
        }
        return;
    }

    public ItemStack[] changeColor(ItemStack[] a, Color color) {
        for (ItemStack item : a) {
            try {
                if (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_CHESTPLATE || item.getType() == Material.LEATHER_HELMET || item.getType() == Material.LEATHER_LEGGINGS) {
                    LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
                    meta.setColor(color);
                    item.setItemMeta(meta);
                }
            } catch (Exception e) {
                // do nothing
            }
        }

        return a;
    }

}
