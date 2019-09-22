package main;

import org.bukkit.plugin.java.JavaPlugin;

// Main class, Event Listeners and what not
public class VoltramDrops extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new VoltramListener(), this);
	}
	
	
	
	public void onDisable() {
		
	}

}
