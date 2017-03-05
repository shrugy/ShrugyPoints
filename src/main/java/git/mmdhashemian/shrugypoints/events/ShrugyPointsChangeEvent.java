package git.mmdhashemian.shrugypoints.events;

import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import org.bukkit.event.Cancellable;

public class ShrugyPointsChangeEvent extends Event implements Cancellable {

	/**
	 * Bukkit Handler list
	 */
	private static final HandlerList handlers = new HandlerList();
	/**
	 * sourceID = who sent the points. targetID = who received the points.
	 */
	private final UUID sourceID, targetID;
	/**
	 * Amount of points being changed by sourceID
	 */
	private int change;
	/**
	 * Cancelled flag.
	 */
	private boolean cancelled;

	/**
	 * Public constructor.
	 * 
	 * @param source
	 *            - Point sender UUID
	 * @param target
	 *            - Point receiver UUID
	 * @param change
	 *            - Amount of change applied to current points.
	 */
	public ShrugyPointsChangeEvent(UUID source, UUID target, int change) {
		this.sourceID = source;
		this.targetID = target;
		this.change = change;
	}

	/**
	 * Get amount of points applied to previous points.
	 * 
	 * @return - Amount of change.
	 */
	public int getChange() {
		return change;
	}

	/**
	 * Set the amount of change that will be used to adjust the player's
	 * balance.
	 * 
	 * @param change
	 *            - Amount of change.
	 */
	public void setChange(int change) {
		this.change = change;
	}

	/**
	 * Get Source UUID if not null ...!
	 * 
	 * @return Source player UUID if not null (Console)
	 */
	public UUID getSourceID() {
		return sourceID;
	}

	/**
	 * Get Target UUID.
	 * 
	 * @return Target player UUID
	 */
	public UUID getTargetID() {
		return targetID;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
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
