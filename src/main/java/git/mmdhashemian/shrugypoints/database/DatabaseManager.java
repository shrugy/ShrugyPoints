package git.mmdhashemian.shrugypoints.database;

import git.mmdhashemian.shrugypoints.ShrugyPoints;
import git.mmdhashemian.shrugypoints.storages.StorageType;

/**
 * The database manager
 * 
 * @author mark
 */
public class DatabaseManager {
    private final ShrugyPoints plugin;
    private final StorageType storageType;

    public DatabaseManager(ShrugyPoints plugin, StorageType storageType){
        this.plugin = plugin;
        this.storageType = storageType;
    }
}
