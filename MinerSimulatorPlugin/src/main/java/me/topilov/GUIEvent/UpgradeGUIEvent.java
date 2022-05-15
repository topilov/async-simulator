package me.topilov.GUIEvent;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;

public class UpgradeGUIEvent implements Listener {

    @Deprecated
    @EventHandler
    public void onItemDrag(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();
        ItemStack inhand = player.getInventory().getItemInMainHand();

        if (inventory.getTitle().contains("Улучшение предмета")) {
            if (clicked == null) return;
            if (clicked.getType() == DIAMOND_PICKAXE) {
                if (player.getInventory().getItemInMainHand().getType() == WOODEN_PICKAXE) {
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 1) {
                        player.chat("/upgrade wooden_pickaxe_2");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 2) {
                        player.chat("/upgrade wooden_pickaxe_3");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 3) {
                        player.chat("/upgrade wooden_pickaxe_4");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 4) {
                        player.chat("/upgrade wooden_pickaxe_5");
                        player.closeInventory();
                    }
                    if (inhand.getType() == WOODEN_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5)  {
                        player.chat("/upgrade iron_pickaxe_0");
                        player.closeInventory();
                    }
                }

                if (player.getInventory().getItemInMainHand().getType() == IRON_PICKAXE) {
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 0) {
                        player.chat("/upgrade iron_pickaxe_1");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 1) {
                        player.chat("/upgrade iron_pickaxe_2");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 2) {
                        player.chat("/upgrade iron_pickaxe_3");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 3) {
                        player.chat("/upgrade iron_pickaxe_4");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 4) {
                        player.chat("/upgrade iron_pickaxe_5");
                        player.closeInventory();
                    }
                    if (inhand.getType() == IRON_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5) {
                        player.chat("/upgrade diamond_pickaxe_0");
                        player.closeInventory();
                    }
                }

                if (player.getInventory().getItemInMainHand().getType() == DIAMOND_PICKAXE) {
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 0) {
                        player.chat("/upgrade diamond_pickaxe_1");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 1) {
                        player.chat("/upgrade diamond_pickaxe_2");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 2) {
                        player.chat("/upgrade diamond_pickaxe_3");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 3) {
                        player.chat("/upgrade diamond_pickaxe_4");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 4) {
                        player.chat("/upgrade diamond_pickaxe_5");
                        player.closeInventory();
                    }
                    if (inhand.getType() == DIAMOND_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5) {
                        player.chat("/upgrade diamond_pickaxe_6");
                        player.closeInventory();
                    }
                    if (inhand.getType() == DIAMOND_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 6) {
                        player.chat("/upgrade diamond_pickaxe_7");
                        player.closeInventory();
                    }
                    if (inhand.getType() == DIAMOND_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 7) {
                        player.chat("/upgrade diamond_pickaxe_20");
                        player.closeInventory();
                    }
                    if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 20) {
                        player.sendMessage(ChatColor.RED + "Кирка имеет максимальный уровень");
                        player.closeInventory();
                    }
                }
            }
        }
    }
}
