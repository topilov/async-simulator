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
                    for (int level = 1; level <= 4; level++) {
                        if (inhand.getEnchantments().get(Enchantment.DIG_SPEED) == level) {
                            player.chat("/upgrade <w" + level);
                        }
                    }
                    if (inhand.getType() == WOODEN_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5) {
                        player.chat("/upgrade <i1");
                    }
                }

                if (player.getInventory().getItemInMainHand().getType() == IRON_PICKAXE) {
                    for (int level = 1; level <= 4; level++) {
                         if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == level) {
                             player.chat("/upgrade <i" + (level + 1));
                         }
                    }
                        if (inhand.getType() == IRON_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5) {
                            player.chat("/upgrade <d1");
                    }
                }

                if (player.getInventory().getItemInMainHand().getType() == DIAMOND_PICKAXE) {
                    for (int level = 1; level <= 4; level++) {
                        if (inhand.getEnchantments().containsKey(Enchantment.DIG_SPEED) && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == level) {
                            player.chat("/upgrade <d" + (level + 1));
                        }
                    }
                        if (inhand.getType() == DIAMOND_PICKAXE && inhand.getEnchantments().get(Enchantment.DIG_SPEED) == 5) {
                            player.sendMessage(ChatColor.RED + "Кирка имеет максимальный уровень");
                    }
                }
                e.setCancelled(true);
                player.chat("/upgrade");
            }
        }
    }
}
