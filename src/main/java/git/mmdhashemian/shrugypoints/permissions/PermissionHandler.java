package git.mmdhashemian.shrugypoints.permissions;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Making better performance for permission management.
 * 
 * @author Mohammad_Hashemian
 *
 */
public class PermissionHandler {

	/**
	 * Check if the player has permission.
	 * 
	 * @param player
	 * @param permissionnode
	 * @return if player has permission return true else false.
	 */
	public boolean has(Player player, PermissionNodes permissionnode) {
		if (player.isOp()) {
			return true;
		} else {
			return player.hasPermission(permissionnode.getNode());
		}
	}

	/**
	 * Check if the command sender has permission.
	 * 
	 * @param sender
	 * @param node
	 * @return if command sender has permission return true else false.
	 */
	public boolean has(CommandSender sender, PermissionNodes permissionnode) {
		if (sender.isOp()) {
			return true;
		} else {
			return sender.hasPermission(permissionnode.getNode());
		}
	}
}
