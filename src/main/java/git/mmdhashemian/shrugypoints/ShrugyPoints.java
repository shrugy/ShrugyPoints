package git.mmdhashemian.shrugypoints;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Plugin main class
 */
public class ShrugyPoints extends JavaPlugin {

	/**
	 * @return Plugin name
	 */
	public String SERVICENAME = "[" + this.getDescription().getName() + "]";
	
	private ConsoleCommandSender sender = Bukkit.getConsoleSender();
	private static String info,warning,notice;
	
	static {
		info = ChatColor.GREEN + "[Info]";
		warning = ChatColor.RED + "[Warning]";
		notice = ChatColor.YELLOW + "[Notice]";
	}
	
	@Override
	public void onEnable() {
		sender.sendMessage(info + " " + "Enabling");
	}

	@Override
	public void onDisable() {
		sender.sendMessage(info + " " + "Disabling");
	}
}
