package git.mmdhashemian.shrugypoints.database.drivers;

import git.mmdhashemian.shrugypoints.ShrugyPoints;
import git.mmdhashemian.shrugypoints.api.ShrugyPoint;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class YamlDatabaseDriver implements DatabaseDriver {
    private final ShrugyPoints plugin;
    private final File databaseFile;
    private YamlConfiguration database;

    /*
    YAML formatting:

     uuid:
         points
         history:
             timestamp:
                 transferId
                 points
     */
    public YamlDatabaseDriver(ShrugyPoints plugin){
        this.plugin = plugin;
        this.databaseFile = new File(plugin.getDataFolder(), "points.yml");
        databaseFile.getParentFile().mkdirs();
        try {
            if (!databaseFile.exists()) databaseFile.createNewFile();
            database = YamlConfiguration.loadConfiguration(databaseFile);
        } catch (IOException e){
            plugin.getLogger().severe("Failed to initialize YamlDatabaseDriver!");
            e.printStackTrace();
        }
    }

    @Override
    public void savePoints(ShrugyPoint points) throws Exception {
        toConfigurationSection(points);
        save();
    }

    @Override
    public ShrugyPoint loadPoints(UUID owner) throws Exception {
        return toShrugyPoint(database.getConfigurationSection(owner.toString()))
                .orElse(new ShrugyPoint(owner, 0, new ArrayList<>()));
    }

    @Override
    public List<ShrugyPoint> getAllPoints() throws Exception {
        return null;
    }

    @Override
    public void saveData() throws Exception {
        save();
    }

    @Override
    public void deinitializeDatabase() throws Exception {
        saveData();
    }

    /* Helper methods */
    private synchronized void save() throws IOException {
        database.save(databaseFile);
    }

    private ConfigurationSection toConfigurationSection(ShrugyPoint points){
        ConfigurationSection section = database.createSection(points.getPlayer().toString());
        ConfigurationSection historySect = section.createSection("history");
        section.set("points", points.getPoints());
        points.getPointsHistory().forEach(history -> {
            ConfigurationSection historyObject = historySect.createSection(""+history.getTimeStamp());
            historyObject.set("points", history.getPoints());
            historyObject.set("transferId", history.getTransferId().toString());
        });
        return section;
    }

    private Optional<ShrugyPoint> toShrugyPoint(ConfigurationSection section){
        if(section == null) return Optional.empty();
        /* TODO: Code */
        return Optional.empty();
    }
}
