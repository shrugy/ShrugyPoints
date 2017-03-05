package git.mmdhashemian.shrugypoints.database;

import git.mmdhashemian.shrugypoints.ShrugyPoints;
import git.mmdhashemian.shrugypoints.database.drivers.DatabaseDriver;
import git.mmdhashemian.shrugypoints.database.drivers.YamlDatabaseDriver;
import git.mmdhashemian.shrugypoints.storages.StorageType;

/**
 * The database manager
 * 
 * @author mark
 */
public class DatabaseManager {
    private final ShrugyPoints plugin;
    private final StorageType storageType;
    private final DatabaseDriver driver;

    public DatabaseManager(ShrugyPoints plugin, StorageType storageType){
        this.plugin = plugin;
        this.storageType = storageType;
        switch (storageType){
            case YAML:
                driver = new YamlDatabaseDriver(plugin);
                break;
            case H2:
                driver = null;
                break;
            case MYSQL:
                driver = null;
                break;
            default:
                driver = null;
                break;
        }
    }
}
