package me.cooltimmetje.CoolVanish;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public class Main extends JavaPlugin{ //Extending JavaPlugin so that Bukkit knows its the main class...
    private static Plugin plugin;

    public static ArrayList<String> vansihedPlayers = new ArrayList<String>();

    public void onEnable() {
        plugin = this;

        getLogger().info("[CoolVanish] Registering Events...");
        registerEvents(this, new JoinQuitEvent());

        getLogger().info("[CoolVanish] Registering Commands...");
        getCommand("v").setExecutor(new VanishCommand());

        getLogger().info("[CoolVanish] Plugin enabled!");
    }

    public void onDisable() {
        plugin = null;//To stop memory leeks
        getServer().resetRecipes();
    }


    //Much easier then registering events in 10 different methods
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    //To access the plugin variable from other classes
    public static Plugin getPlugin() {
        return plugin;
    }

    public static String PluginTag = "§8[§cCoolVanish§8] §a";

}