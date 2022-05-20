package me.smajt.traitorsintown.Listeners;

import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.Menu;
import me.kodysimpson.simpapi.menu.MenuManager;
import me.smajt.traitorsintown.Commands.AdminBookCommand;
import me.smajt.traitorsintown.Functions.GameFunctions;
import me.smajt.traitorsintown.Menus.ABMain;
import me.smajt.traitorsintown.Menus.PBMain;
import me.smajt.traitorsintown.Storages.UserStorage;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class GeneralListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) throws MenuManagerException, MenuManagerNotSetupException {
        Player p = e.getPlayer();
        if(e.getAction().isRightClick()){
            if(e.getItem() != null)
                if(Objects.requireNonNull(e.getItem()).getItemMeta().getPersistentDataContainer().has(AdminBookCommand.adminBookKey)){
                    if(p.isOp())
                        MenuManager.openMenu(ABMain.class, p);
                }
                else if(Objects.requireNonNull(e.getItem()).getItemMeta().getPersistentDataContainer().has(GameFunctions.playerBookKey)){
                    if(UserStorage.findUser(p.getUniqueId()) != null)
                        MenuManager.openMenu(PBMain.class, p);
                }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player player = e.getPlayer();
        Item item = e.getItemDrop();
        if(Objects.requireNonNull(item.getItemStack()).getItemMeta().getPersistentDataContainer().has(GameFunctions.playerBookKey))
            e.setCancelled(true);
    }

}
