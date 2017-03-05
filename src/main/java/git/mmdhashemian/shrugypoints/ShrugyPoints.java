package git.mmdhashemian.shrugypoints;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin main class
 */
public class ShrugyPoints extends JavaPlugin {

	/**
	 * @return Plugin name
	 */
	public  String SERVICENAME = "[" + this.getDescription().getName() + "]";

	@Override
	public void onEnable() {
		getLogger().info("Enabling");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabling");
	}
}
