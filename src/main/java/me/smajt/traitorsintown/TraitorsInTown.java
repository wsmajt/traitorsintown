package me.smajt.traitorsintown;

import me.kodysimpson.simpapi.menu.MenuManager;
import me.smajt.traitorsintown.Commands.AdminBookCommand;
import me.smajt.traitorsintown.Listeners.GeneralListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TraitorsInTown extends JavaPlugin {

    private static TraitorsInTown plugin;
    public static TraitorsInTown getPlugin(){
        return plugin;
    }

    public static String GamePrefix = "&7&l[&6&l TT &7&l] ";

    @Override
    public void onEnable() {
        plugin = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new GeneralListener(), this);

        MenuManager.setup(getServer(), this);

        Objects.requireNonNull(this.getCommand("adminbook")).setExecutor(new AdminBookCommand());
    }

    @Override
    public void onDisable() {

    }
}
