package main;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import configfiles.DefaultConfig;
import listeners.JoinListener;
import listeners.VoltramListener;
import tasks.DropEvent;

// Main class, Event Listeners and what not


public class VoltramDrops extends JavaPlugin {
	public static VoltramDrops plugin;
	
	DefaultConfig con = new DefaultConfig();
	@Override
	public void onEnable() {
		plugin = this;
		
		//Setup config
		con.defaultSetup();
		//getConfig().addDefault("Regions", null);
		/*
		CustomConfig.setup();
		CustomConfig.get().addDefault("MinForDrop", "1");
		CustomConfig.get().options().copyDefaults(true);
		CustomConfig.save();
		*/
		
		
		
		//WorldEditPlugin wep = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		
		getCommand("vd").setExecutor(new CommandVD());
		getServer().getPluginManager().registerEvents(new VoltramListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		BukkitTask dropEvent = (BukkitTask) new DropEvent(this).runTaskTimer(this, 100, 60 * 20);
		
	}
	

	
	public void onDisable() {
		plugin = null;
	}

}
