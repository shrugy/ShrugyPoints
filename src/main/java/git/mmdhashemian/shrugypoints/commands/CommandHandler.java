package git.mmdhashemian.shrugypoints.commands;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import git.mmdhashemian.shrugypoints.ShrugyPoints;
import git.mmdhashemian.shrugypoints.models.Locator;

/**
 * The CommandHandler is dealing with commands
 * 
 * @author Special thanks to black_ixx
 */
public abstract class CommandHandler implements CommandExecutor {

	/**
	 * Registered commands for this handler.
	 */
	protected final Map<String, ShrugyCommand> registeredCommands = new HashMap<String, ShrugyCommand>();
	/**
	 * Registered subcommands and the handler associated with it.
	 */
	protected final Map<String, CommandHandler> registeredHandlers = new HashMap<String, CommandHandler>();
	/**
	 * Root plugin so that commands and handlers have access to the information.
	 */
	protected ShrugyPoints PLUGIN;

	/**
	 * Command name.
	 */
	protected String cmd;

	/**
	 * Constructor.
	 * 
	 * @param plugin
	 *            - Root plugin.
	 */
	public CommandHandler(ShrugyPoints plugin, String cmd) {
		this.PLUGIN = plugin;
		this.cmd = cmd;
	}

	/**
	 * Register a command with an execution handler.
	 * 
	 * @param label
	 *            - Command to listen for.
	 * @param command
	 *            - Execution handler that will handle the logic behind the
	 *            command.
	 */
	public void registerCommand(String label, ShrugyCommand command) {
		if (registeredCommands.containsKey(label)) {
			PLUGIN.getLogger().warning("Replacing existing command for: " + label);
		}
		registeredCommands.put(label, command);
	}

	/**
	 * Unregister a command for this handler.
	 * 
	 * @param label
	 *            - Command to stop handling.
	 */
	public void unregisterCommand(String label) {
		registeredCommands.remove(label);
	}

	/**
	 * Register a subcommand with a command handler.
	 * 
	 * @param label
	 *            - Subcommand to register.
	 * @param handler
	 *            - Command handler.
	 */
	public void registerHandler(CommandHandler handler) {
		if (registeredHandlers.containsKey(handler.getCommand())) {
			PLUGIN.getLogger().warning("Replacing existing handler for: " + handler.getCommand());
		}
		registeredHandlers.put(handler.getCommand(), handler);
	}

	/**
	 * Unregister a subcommand.
	 * 
	 * @param label
	 *            - Subcommand to remove.
	 */
	public void unregisterHandler(String label) {
		registeredHandlers.remove(label);
	}

	/**
	 * Command loop that will go through the linked handlers until it finds the
	 * appropriate handler or command execution handler to do the logic for.
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		EnumMap<Locator, String> info = new EnumMap<Locator, String>(Locator.class);
		info.put(Locator.SERVICENAME, PLUGIN.SERVICENAME);
		if (args.length == 0) {
			return noArgs(sender, command, label, info);
		} else {
			final String subcmd = args[0].toLowerCase();
			// Check known handlers first and pass to them
			final CommandHandler handler = registeredHandlers.get(subcmd);
			if (handler != null) {
				return handler.onCommand(sender, command, label, shortenArgs(args));
			}
			// Its our command, so handle it if its registered.
			final ShrugyCommand subCommand = registeredCommands.get(subcmd);
			if (subCommand == null) {
				return unknownCommand(sender, command, label, args, info);
			}
			// Execute command
			boolean value = true;
			try {
				value = subCommand.execute(PLUGIN, sender, command, label, shortenArgs(args), info);
			} catch (ArrayIndexOutOfBoundsException e) {
				sender.sendMessage(ChatColor.GRAY + PLUGIN.SERVICENAME + ChatColor.RED + " Missing parameters.");
			}
			return value;
		}
	}

	/**
	 * Method that is called on a CommandHandler if there is no additional
	 * arguments given that specify a specific command.
	 * 
	 * @param sender
	 *            - Sender of the command.
	 * @param command
	 *            - Command used.
	 * @param label
	 *            - Command label.
	 * @return True if handled. Should not need to return false...
	 */
	public abstract boolean noArgs(CommandSender sender, Command command, String label, EnumMap<Locator, String> info);

	/**
	 * Allow for the command handler to have special logic for unknown commands.
	 * Useful for when expecting a player name parameter on a root command
	 * handler command.
	 * 
	 * @param sender
	 *            - Sender of the command.
	 * @param command
	 *            - Command used.
	 * @param label
	 *            - Command label.
	 * @param args
	 *            - Arguments.
	 * @return True if handled. Should not need to return false...
	 */
	public abstract boolean unknownCommand(CommandSender sender, Command command, String label, String[] args,
			EnumMap<Locator, String> info);

	/**
	 * Shortens the given string array by removing the first entry.
	 * 
	 * @param args
	 *            - Array to shorten.
	 * @return Shortened array.
	 */
	protected String[] shortenArgs(String[] args) {
		if (args.length == 0) {
			return args;
		}
		final List<String> argList = new ArrayList<String>();
		for (int i = 1; i < args.length; i++) {
			argList.add(args[i]);
		}
		return argList.toArray(new String[0]);
	}

	/**
	 * Get the command for this handler.
	 * 
	 * @return Command
	 */
	public String getCommand() {
		return cmd;
	}
}
