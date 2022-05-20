package me.smajt.traitorsintown.Commands;

import me.smajt.traitorsintown.TraitorsInTown;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminBookCommand implements CommandExecutor {
    public static NamespacedKey adminBookKey = new NamespacedKey(TraitorsInTown.getPlugin(), "adminBook");
    String gamePrefix = TraitorsInTown.GamePrefix;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (player != null) {
                if(player.isOp()){
                    ItemStack adminBook = new ItemStack(Material.ENCHANTED_BOOK);
                    ItemMeta newItemMeta = adminBook.getItemMeta();
                    newItemMeta.displayName(Component.text(ChatColor.translateAlternateColorCodes('&', "&4&lAdmin Book")));
                    List<Component> lore = new ArrayList<Component>();
                    lore.add(Component.text(ChatColor.translateAlternateColorCodes('&', "&6&lKsiążka dla giga kocurów.")));
                    newItemMeta.lore(lore);
                    newItemMeta.getPersistentDataContainer().set(adminBookKey, PersistentDataType.INTEGER, 1);
                    adminBook.setItemMeta(newItemMeta);
                    player.getInventory().addItem(adminBook);
                    player.sendMessage(Component.text(ChatColor.translateAlternateColorCodes('&', gamePrefix + "&a&lDostałeś książke.")));
                } else {
                    player.sendMessage(Component.text(ChatColor.translateAlternateColorCodes('&', gamePrefix + "&c&lNie jesteś giga kocurem żeby dostać tą książke.")));
                }
            }
        }
        return true;
    }
}
