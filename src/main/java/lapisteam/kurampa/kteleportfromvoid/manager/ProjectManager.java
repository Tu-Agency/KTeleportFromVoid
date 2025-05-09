package lapisteam.kurampa.kteleportfromvoid.manager;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.configs.MainConfig;

public class ProjectManager {

    private final Main plugin;
    private ConfigManager configManager;
    private MainConfig mainConfig;
    private CommandsManager commandsManager;
    private EventsManager eventsManager;

    public ProjectManager(Main plugin) {
        this.plugin = plugin;
    }

    public void init() {
        configManager = new ConfigManager(plugin);
        mainConfig = new MainConfig(plugin);
        commandsManager = new CommandsManager(plugin);
        eventsManager = new EventsManager(plugin);
    }

    public CommandsManager getCommandManager() {
        return commandsManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }

    public EventsManager getRegisterEvents() {
        return eventsManager;
    }
}