package dev.zeplr.zcosmetic;

import dev.zeplr.zcosmetic.listener.GadgetsListener;
import dev.zeplr.zcosmetic.listener.PlayerListener;
import dev.zeplr.zcosmetic.commands.OpenMenuCommand;
import dev.zeplr.zcosmetic.manager.PlayerData;
import dev.zeplr.zcosmetic.utils.menu.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Zeplr extends JavaPlugin {

    @Override
    public void onEnable() {

        reloadConfig();
        saveDefaultConfig();

        this.init();


    }

    @Override
    public void onDisable() {}

    public void init() {
        this.registerListeners(
                new MenuListener(),
                new PlayerListener(),
                new GadgetsListener()
        );

        getServer().getPluginCommand("menu").setExecutor(new OpenMenuCommand());
    }

    private void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> Bukkit.getServer().getPluginManager().registerEvents(l, this));
    }

    public static Zeplr getInstance(){
        return Zeplr.getPlugin(Zeplr.class);
    }

    public PlayerData getPlayerData(){
        return new PlayerData();
    }
}
