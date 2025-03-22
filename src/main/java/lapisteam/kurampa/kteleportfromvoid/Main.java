package lapisteam.kurampa.kteleportfromvoid;

import lapisteam.kurampa.kteleportfromvoid.commands.ReloadCommand;
import lapisteam.kurampa.kteleportfromvoid.listeners.VoidTeleportListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private FileConfiguration config;
    Logger logger = this.getLogger();
    PluginManager pluginManager = getServer().getPluginManager();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();

        pluginManager.registerEvents(new VoidTeleportListener(this), this);
        getCommand("kteleportfromvoid").setExecutor(new ReloadCommand(this));

        logger.info("KTeleportFromVoid plugin is up and running!");
    }

    @Override
    public void onDisable() {
        logger.info("The KTeleportFromVoid plugin has been disabled!");
    }

    public void reloadPluginConfig() {
        reloadConfig();
        config = getConfig();
    }
}
