package tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import main.DropLocations;
import main.VoltramDrops;
import managers.CrateManager;
import managers.DropLocationsManager;

public class DropEvent extends BukkitRunnable {
	
	VoltramDrops plugin;
	int count = 0;
	int time = 0;
	String name = "";
	
	public DropEvent(String name, int time, int count, VoltramDrops plugin) {
		this.plugin = plugin;
		this.name = name;
		this.time = time;
		this.count = count;
	}
	@Override
	public void run() {
		
		if(count <= Bukkit.getServer().getOnlinePlayers().size()) {
			DropLocations drop = DropLocationsManager.createNewDropLocations(name);
			for(Location l : drop.getLocations()) {
				CrateManager.createNewCrate(l);
			}
		}
		new BukkitRunnable() {

			@Override
			public void run() {
				new DropEvent(name, time, count, plugin).run();
				
			}
			
		}.runTaskLater(plugin, time * 20);
		
		
		
	}
	
	public void newCase() {
		
	}
}

