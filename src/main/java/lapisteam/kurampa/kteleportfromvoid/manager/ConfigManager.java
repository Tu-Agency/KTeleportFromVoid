package lapisteam.kurampa.kteleportfromvoid.manager;

import lapisteam.kurampa.kteleportfromvoid.Main;
import org.bukkit.configuration.file.FileConfiguration;
import lapisteam.kurampa.kteleportfromvoid.utils.ColorUtils;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private FileConfiguration config;
    private final Main plugin;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    private final Map<String, String> cachedColoredStrings = new HashMap<>();
    private final Map<String, String> cachedSimpleStrings = new HashMap<>();
    private final Map<String, Integer> cachedIntegerValue = new HashMap<>();
    private final Map<String, Long> cachedLongValue = new HashMap<>();
    private final Map<String, Boolean> cachedBooleanValue = new HashMap<>();

    public String getString(String ConfigPath) {
        return cachedSimpleStrings.computeIfAbsent(ConfigPath, p ->
            config.getString(p, "&cНе обработанные данные конфига: " + p )
        );
    }

    public Boolean getBoolean(String ConfigPath) {
        return (cachedBooleanValue.computeIfAbsent(ConfigPath, p -> config.getBoolean(p, false)));
    }

    public Long getLong(String ConfigPath) {
        return (cachedLongValue.computeIfAbsent(ConfigPath, p -> config.getLong(p, 0)));
    }

    public Integer getInteger(String ConfigPath) {
        return (cachedIntegerValue.computeIfAbsent(ConfigPath, p -> config.getInt(p, 0)));
    }

    public String getColored(String ConfigPath) {
        return cachedColoredStrings.computeIfAbsent(ConfigPath, p ->
            ColorUtils.applyColors(config.getString(p, "&cНе обработанное сообщение конфига: " + p ))
        );
    }

    public FileConfiguration getConfiguration() {
        return config;
    } // Получение конфигурации файла

    public void reloadPluginConfig() {
        clearStringsMap(); // Очистка Мап с кешированными строками
        plugin.reloadConfig();
        config = plugin.getConfig();
    } // Перезагрузка данных плагина

    private void clearStringsMap() {
        cachedColoredStrings.clear();
        cachedSimpleStrings.clear();
        cachedIntegerValue.clear();
        cachedLongValue.clear();
    }
}