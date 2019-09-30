package main;

import org.bukkit.plugin.java.JavaPlugin;

import listeners.DropBlockListener;
import listeners.JoinListener;
import listeners.VoltramListener;

// Main class, Event Listeners and what not


public class VoltramDrops extends JavaPlugin {
	public static VoltramDrops plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		Init.init();
		
		//Setup config


		
		getCommand("vd").setExecutor(new CommandVD());
		getServer().getPluginManager().registerEvents(new VoltramListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		getServer().getPluginManager().registerEvents(new DropBlockListener(), this);
		
	}
	

	
	public void onDisable() {
		plugin = null;
	}

}
