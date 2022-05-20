package me.smajt.traitorsintown.Menus;

import me.kodysimpson.simpapi.colors.ColorTranslator;
import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.Menu;
import me.kodysimpson.simpapi.menu.MenuManager;
import me.kodysimpson.simpapi.menu.PlayerMenuUtility;
import me.smajt.traitorsintown.Functions.GameFunctions;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ABMain extends Menu {
    public ABMain(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ColorTranslator.translateColorCodes("&4&lAdmin Menu");
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
        switch (e.getCurrentItem().getType()) {
            case MUSIC_DISC_FAR:
                GameFunctions.RestartGame(playerMenuUtility.getOwner());
                break;
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack settingsMenu = makeItem(Material.MUSIC_DISC_FAR, ColorTranslator.translateColorCodes("&a&lRozpocznij nową gre"));
        inventory.setItem(4, settingsMenu);
    }
}
