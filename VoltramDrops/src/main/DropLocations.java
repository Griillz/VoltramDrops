package main;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import managers.CrateManager;

public class DropLocations {

	private ArrayList<Location> locations = new ArrayList<Location>();

	public DropLocations(String name) {
		makeDropLocs(name);
	}

	public void makeDropLocs(String name) {
		World world = Bukkit.getWorld(VoltramDrops.plugin.getConfig().getString("Regions." + name + ".world"));
		System.out.println(name);
		double minX = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".minX");
		double maxX = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".maxX");
		double minZ = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".minZ");
		double maxZ = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".maxZ");
		boolean minXNeg = false;
		boolean maxXNeg = false;
		boolean minZNeg = false;
		boolean maxZNeg = false;
		double xPass = 0;
		double zPass = 0;
		if (minX < 0) {
			minXNeg = true;
		}
		if (maxX < 0) {
			maxXNeg = true;
		}
		if (minZ < 0) {
			minZNeg = true;
		}
		if (maxZ < 0) {
			maxZNeg = true;
		}
		Random rand = new Random();
		for (int i = 0; i < VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".numCrates"); i++) {
			if (minXNeg == true && maxXNeg == false) {
				System.out.println("Here for " + name + " minXNeg == " + minXNeg + " maxXNeg " + maxXNeg);
				double newNum = maxX + (minX * -1);
				xPass = rand.nextInt((int) newNum + 1);
				if (xPass > maxX) {
					xPass = (xPass - maxX) * -1;
				}
			} else if (minXNeg == true && maxXNeg == true) {
				System.out.println("Here for " + name + " minXNeg == " + minXNeg + " maxXNeg " + maxXNeg);
				double newNum = (-1 * maxX) - (-1 * minX);
				xPass = rand.nextInt((int) newNum);
				xPass = (minX + xPass) * -1;
			} else {
				System.out.println("Here for " + name + " minXNeg == " + minXNeg + " maxXNeg " + maxXNeg);
				double newNum = maxX - minX;
				xPass = rand.nextInt((int) newNum);
				xPass = minX + xPass;
			}
			if (minZNeg == true && maxZNeg == false) {
				System.out.println("Here for " + name + " minZNeg == " + minZNeg + " maxZNeg " + maxZNeg);
				double newNum = maxZ + (minZ * -1);
				zPass = rand.nextInt((int) newNum + 1);
				if (zPass > maxZ) {
					zPass = (zPass - maxZ) * -1;
				}
			} else if (minZNeg == true && maxZNeg == true) {
				System.out.println("Here for " + name + " minZNeg == " + minZNeg + " maxZNeg " + maxZNeg);
				double newNum = (-1 * maxZ) - (-1 * minZ);
				zPass = rand.nextInt((int) newNum);
				zPass = (minZ + zPass) * -1;
			} else {
				System.out.println("Here for " + name + " minZNeg == " + minZNeg + " maxZNeg " + maxZNeg);
				double newNum = maxZ - minZ;
				zPass = rand.nextInt((int) newNum);
				zPass = minZ + zPass;
			}
			Location loc = new Location(Bukkit.getWorld("world"), xPass,
					VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".dropFromHeight"), zPass);

			while (loc.getBlock().getType().equals(Material.AIR)) {
				loc.setY(loc.getBlockY() - 1);
			}
			if (!(loc.getBlock().getType().equals(VoltramDrops.plugin.getConfig().getString("Regions." + name + ".NoNoBlock")))) {
				loc.setY(loc.getBlockY() + 1);
				locations.add(loc);
				System.out.println(loc);
			} else {
				i--;
			}
		}
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}

}
