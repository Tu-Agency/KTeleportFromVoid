package lapisteam.kurampa.kteleportfromvoid.manager;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.listeners.*;
import org.bukkit.plugin.PluginManager;

import static org.bukkit.Bukkit.getServer;

public class EventsManager {

    private final Main plugin;
    private final PluginManager pluginManager;
    private final ProjectManager projectManager;

    public EventsManager(Main plugin) {
        this.plugin = plugin;
        this.pluginManager = getServer().getPluginManager();
        this.projectManager = plugin.getProjectManager();
    }

    public void RegEvents() { // Регистрация всех событий
        pluginManager.registerEvents(new VoidTeleportListener(plugin), plugin);
    }
}