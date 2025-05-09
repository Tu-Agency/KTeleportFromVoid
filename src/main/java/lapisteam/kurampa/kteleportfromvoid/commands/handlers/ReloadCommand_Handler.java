package lapisteam.kurampa.kteleportfromvoid.commands.handlers;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.configs.MainConfig;
import lapisteam.kurampa.kteleportfromvoid.manager.ConfigManager;
import lapisteam.kurampa.kteleportfromvoid.manager.ProjectManager;
import org.bukkit.command.CommandSender;

import java.util.logging.Logger;

public class ReloadCommand_Handler {

    private final MainConfig cfg;
    private final ConfigManager configManager;
    private final Logger logger;

    public ReloadCommand_Handler(Main plugin) {
        ProjectManager projectManager = plugin.getProjectManager();
        this.logger = plugin.getLogger();
        this.cfg = projectManager.getMainConfig();
        this.configManager = projectManager.getConfigManager();
    }

    public boolean Handler(CommandSender sender, String[] args) {
        configManager.reloadPluginConfig(); // Перезагружаем конфиг плагина
        String outputMessage = cfg.getCommandData("reload", "outPutMessage");
        sender.sendMessage(outputMessage);
        logger.info(outputMessage);
        return true;
    }
}