package me.mhasheiman.shrugypoints;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin main class
 */
public class ShrugyPoints extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Enabling");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling");
    }
}
