package git.mmdhashemian.shrugypoints.events;

import java.util.UUID;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Class will call when a point transfer happen
 * 
 * @author Mohammad_Hashemian
 *
 */
public class OnShrugyPointsChange extends ShrugyPointsChangeEvent implements Cancellable {

    /**
     * Bukkit handler list.
     */
    private static final HandlerList handlers = new HandlerList();

    /**
     * Constructor.
     * 
     * @param source
     *            - UUID of source player.
     * @param target
     *            - UUID of target player.
     * 
     * @param change
     *            - Amount of points to be changed.
     */
    public OnShrugyPointsChange(UUID source, UUID target, int change) {
        super(source, target, change);
    }

    /**
     * Static method to get HandlerList.
     * 
     * @return HandlerList.
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
