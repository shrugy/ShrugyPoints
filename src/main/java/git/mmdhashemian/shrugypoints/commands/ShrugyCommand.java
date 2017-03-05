package git.mmdhashemian.shrugypoints.commands;

import java.util.EnumMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import git.mmdhashemian.shrugypoints.ShrugyPoints;
import git.mmdhashemian.shrugypoints.models.Locator;

/**
 * Represents a command.
 * 
 * @author Mohammad_Hashemian
 */
public interface ShrugyCommand {
	boolean execute(final ShrugyPoints plugin, final CommandSender sender, final Command command, final String label,
			String[] args, EnumMap<Locator, String> info);

}
