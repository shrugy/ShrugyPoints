package git.mmdhashemian.shrugypoints.database.drivers;

import git.mmdhashemian.shrugypoints.api.ShrugyPoint;

import java.util.List;
import java.util.UUID;

public interface DatabaseDriver {
    /**
     * Save points
     *
     * @param points {@link ShrugyPoint} object
     * @throws Exception If object saving fails
     */
    void savePoints(ShrugyPoint points) throws Exception;

    /**
     * Load points
     *
     * @param owner Points owner UUID
     * @return {@link ShrugyPoint} object
     * @throws Exception If object loading fails
     */
    ShrugyPoint loadPoints(UUID owner) throws Exception;

    /**
     * Gets all recorded points
     *
     * @return List of {@link ShrugyPoint} objects
     * @throws Exception If loading objects fails
     */
    List<ShrugyPoint> getAllPoints() throws Exception;

    /**
     * Saves cached data to database
     *
     * @throws Exception If data fails to save
     */
    void saveData() throws Exception;

    /**
     * Deinitializes database driver
     *
     * @throws Exception If deinitialization fails
     */
    void deinitializeDatabase() throws Exception;
}
