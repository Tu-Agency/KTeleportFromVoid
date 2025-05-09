package lapisteam.kurampa.kteleportfromvoid.configs;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.manager.ConfigManager;

public class MainConfig {

    private final ConfigManager configManager;

    public MainConfig(Main plugin) {
        configManager = plugin.getProjectManager().getConfigManager();
    }

    public String getCommandData(String commandName, String dataName) {
        return configManager.getColored("Commands." + commandName + "." + dataName);
    }

    public String getMessage(String messageName) {
        return configManager.getColored("messages." + messageName);
    }

    public Boolean getParamBoolean(String ParamName) {
        return configManager.getBoolean(ParamName);
    }
}