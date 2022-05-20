package me.smajt.traitorsintown.Menus;

import me.kodysimpson.simpapi.colors.ColorTranslator;
import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.Menu;
import me.kodysimpson.simpapi.menu.PlayerMenuUtility;
import me.smajt.traitorsintown.Functions.GameFunctions;
import me.smajt.traitorsintown.Models.User;
import me.smajt.traitorsintown.Storages.UserStorage;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PBMain extends Menu {
    public PBMain(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ColorTranslator.translateColorCodes("&a&lPlayer Book");
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public boolean cancelAllClicks() {
        return true;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) throws MenuManagerNotSetupException, MenuManagerException {
        /*switch (e.getCurrentItem().getType()) {
            case MUSIC_DISC_FAR:
                GameFunctions.RestartGame(playerMenuUtility.getOwner());
                break;
        }*/
    }

    @Override
    public void setMenuItems() {
        User userData = UserStorage.findUser(p.getUniqueId());
        if (userData != null){
            boolean isTraitor = userData.isTraitor();
            if(isTraitor){
                ItemStack classBlock = makeItem(Material.RED_STAINED_GLASS_PANE, ColorTranslator.translateColorCodes("&c&lWinny : " + userData.getPlayerClass().toString()));
                inventory.setItem(4, classBlock);
            }
            else{
                ItemStack classBlock = makeItem(Material.GREEN_STAINED_GLASS_PANE, ColorTranslator.translateColorCodes("&c&lNie winny : " + userData.getPlayerClass().toString()));
                inventory.setItem(4, classBlock);
            }

        }
        else{
            ItemStack blackWool = makeItem(Material.BLACK_STAINED_GLASS_PANE, ColorTranslator.translateColorCodes("&4&lNie jesteś w grze."));
            inventory.setItem(4, blackWool);
        }
    }
}
