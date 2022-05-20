package me.smajt.traitorsintown.Functions;

import me.smajt.traitorsintown.GameEnums;
import me.smajt.traitorsintown.Models.User;
import me.smajt.traitorsintown.Storages.UserStorage;
import me.smajt.traitorsintown.TraitorsInTown;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;
import java.util.logging.Level;

public class GameFunctions {

    public static NamespacedKey playerBookKey = new NamespacedKey(TraitorsInTown.getPlugin(), "playerBook");
    public static String gamePrefix = TraitorsInTown.GamePrefix;

    public static void RestartGame(Player sender){
        UserStorage.clearUsers();
        for (Player player : Bukkit.getOnlinePlayers()){
            player.setHealth(player.getHealth());
            player.setFoodLevel(20);
            player.teleport(sender.getLocation());
            player.getInventory().clear();
        }

        StartGame(sender);
    }

    private static void StartGame(Player sender){
        Random r = new Random();
        int traitorMax = 1;
        int playersCount = Bukkit.getOnlinePlayers().size();
        int nowPlayersCount = playersCount;

        if(playersCount >= 8){
            traitorMax = 3;
        }
        else if(playersCount >= 6){
            traitorMax = 2;
        }

        ArrayList<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
        TraitorsInTown.getPlugin().getLogger().log(Level.INFO, String.valueOf(playersCount));

        for(Player p : players){
            int i = r.nextInt(1, 3);
            if(i == 1 && traitorMax != 0){
                UserStorage.createUser(p, GameEnums.RandomTraitorRole(), true);
                traitorMax -= 1;
            }
            else{
                if (playersCount - 2 <= nowPlayersCount && traitorMax > 0)
                    UserStorage.createUser(p, GameEnums.RandomTraitorRole(), true);
                else
                    UserStorage.createUser(p, GameEnums.RandomInnocentRole(), false);
            }
            User userData = UserStorage.findUser(p.getUniqueId());
            nowPlayersCount -= 1;


            ItemStack playerBook = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta newItemMeta = playerBook.getItemMeta();
            newItemMeta.displayName(Component.text(ChatColor.translateAlternateColorCodes('&', "&a&lPlayer Book")));
            List<Component> lore = new ArrayList<Component>();
            lore.add(Component.text(ChatColor.translateAlternateColorCodes('&', "&6&lKsięga gracza.")));
            newItemMeta.lore(lore);
            newItemMeta.getPersistentDataContainer().set(playerBookKey, PersistentDataType.INTEGER, 1);
            playerBook.setItemMeta(newItemMeta);
            p.getInventory().addItem(playerBook);
            p.sendMessage(Component.text(ChatColor.translateAlternateColorCodes('&', gamePrefix + "&a&lOtrzymałeś książke gracza.")));
        }
    }
}
