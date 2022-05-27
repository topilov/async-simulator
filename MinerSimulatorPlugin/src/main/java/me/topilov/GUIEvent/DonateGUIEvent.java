package me.topilov.GUIEvent;

import me.topilov.App;
import me.topilov.sql.SQLGetter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class DonateGUIEvent implements Listener {

    SQLGetter data = App.getInstance().data;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if(e.getInventory().getTitle().equalsIgnoreCase("Донат-магазин")) {
            if (e.getCurrentItem() == null) return;

            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                data.setAutosell(player.getUniqueId(), 1);

                player.sendMessage(ChatColor.GREEN + "Автоматическая продажа успешно приобретена");
                e.setCancelled(true);
            }

            if (e.getCurrentItem().getType() == Material.MELON_SLICE) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 10,  true, false));

                player.sendMessage(ChatColor.GREEN + "Эффект скорости х10 успешно куплен");
                e.setCancelled(true);
            }

            if (e.getCurrentItem().getType() == Material.GOLDEN_PICKAXE) {
                data.setPickaxe(player.getUniqueId(), 1);

                ItemStack pickaxe = new ItemStack(Material.GOLDEN_PICKAXE);
                ItemMeta meta_pickaxe = pickaxe.getItemMeta();

                meta_pickaxe.setDisplayName(ChatColor.GOLD + "Супер Кирка");
                List<String> lore3 = new ArrayList<>();

                lore3.add("");
                lore3.add(ChatColor.WHITE + "Супер кирка, которая дает уникальные способности");

                meta_pickaxe.addEnchant(Enchantment.DIG_SPEED, 300, true);
                meta_pickaxe.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta_pickaxe.setLore(lore3);
                pickaxe.setItemMeta(meta_pickaxe);

                player.getInventory().addItem(pickaxe);

                player.sendMessage(ChatColor.GREEN + "Супер курка успешно приобретена");
                e.setCancelled(true);
            }
        }
    }
}
