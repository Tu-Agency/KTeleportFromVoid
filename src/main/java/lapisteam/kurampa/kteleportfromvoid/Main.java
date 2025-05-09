package lapisteam.kurampa.kteleportfromvoid;

import lapisteam.kurampa.kteleportfromvoid.manager.ProjectManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    Logger logger = this.getLogger();
    private ProjectManager projectManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        projectManager = new ProjectManager(this);
        projectManager.init();
        projectManager.getRegisterEvents().RegEvents();
        projectManager.getCommandManager().RegAllCommands();
        logger.info("KTeleportFromVoid plugin is up and running!");
    }

    @Override
    public void onDisable() {
        logger.info("The KTeleportFromVoid plugin has been disabled!");
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }
}