package main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import configfiles.CustomConfig;

// Main class, Event Listeners and what not
public class VoltramDrops extends JavaPlugin {
	@Override
	public void onEnable() {
		
		//Setup config
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		CustomConfig.setup();
		CustomConfig.get().addDefault("Taco", "Rice");
		CustomConfig.get().options().copyDefaults(true);
		CustomConfig.save();
		
		//WorldEditPlugin wep = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		
		//getCommand("vd").setExecutor(new CommandVD());
		getServer().getPluginManager().registerEvents(new VoltramListener(), this);
	}
	

	
	public void onDisable() {
		
	}

}
