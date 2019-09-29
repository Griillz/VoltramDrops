package tasks;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import main.DropLocations;
import main.VoltramDrops;

public class DropEvent extends BukkitRunnable {
	
	VoltramDrops plugin;
	
	public DropEvent(VoltramDrops plugin) {
		this.plugin = plugin;
	}
	@Override
	public void run() {
		DropLocations drop = new DropLocations("lol");
		DropLocations drop1 = new DropLocations("negativetesting");
	}
}

