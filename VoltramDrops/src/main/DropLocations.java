package main;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class DropLocations {
	
	ArrayList<Location> locations = new ArrayList<Location>();
	
	public DropLocations(String name) {
		makeDropLocs(name);
	}
	
	public void makeDropLocs(String name) {
		World world = Bukkit.getWorld(VoltramDrops.plugin.getConfig().getString("Regions." + name + ".world"));
		System.out.println(name);
		double minX = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".minX") + .5;
		double maxX = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".maxX") + .5;
		double minZ = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".minZ") + .5;
		double maxZ = VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".maxZ") + .5;
		boolean minXNeg = false;
		boolean maxXNeg = false;
		boolean minZNeg = false;
		boolean maxZNeg = false;
		double xPass = 0;
		double zPass = 0;
		if(minX < 0) {
			minXNeg = true;
		}
		if(maxX < 0) {
			maxXNeg = true;
		}
		if(minZ < 0) {
			minZNeg = true;
		}
		if(maxZ < 0) {
			maxZNeg = true;
		}
		Random rand = new Random();
		for(int i = 0; i < VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".numCrates"); i++) {
			if(minXNeg == true && maxXNeg == false) {
				System.out.println("Here for " + name + " minXNeg == " + minXNeg + " maxXNeg " + maxXNeg);
				double newNum = maxX + (minX * -1);
				xPass = rand.nextInt((int) newNum) + 1;
				if(xPass > maxX ) {
					xPass = (xPass - maxX) * -1;
				}
			}
			else if(minXNeg == true && maxXNeg == true) {
				System.out.println("Here for " + name + " minXNeg == " + minXNeg + " maxXNeg " + maxXNeg);
				double newNum = (-1 * maxX) - (-1 * minX);
				xPass = rand.nextInt((int) newNum) + 1;
				xPass = (minX + xPass) * -1;
			}
			else {
				System.out.println("Here for " + name + " minXNeg == " + minXNeg + " maxXNeg " + maxXNeg);
				double newNum = maxX - minX;
				xPass = rand.nextInt((int) newNum) + 1;
				xPass = minX + xPass;
			}
			if(minZNeg == true && maxZNeg == false) {
				System.out.println("Here for " + name + " minZNeg == " + minZNeg + " maxZNeg " + maxZNeg);
				double newNum = maxZ + (minX * -1);
				zPass = rand.nextInt((int) newNum) + 1;
				if(zPass > maxZ ) {
					zPass = (zPass - maxZ) * -1;
				}
			}
			else if(minZNeg == true && maxZNeg == true) {
				System.out.println("Here for " + name + " minZNeg == " + minZNeg + " maxZNeg " + maxZNeg);
				double newNum = (-1 * maxZ) - (-1 * minX);
				zPass = rand.nextInt((int) newNum) + 1;
				zPass = (minZ + zPass) * -1;
			}
			else {
				System.out.println("Here for " + name + " minZNeg == " + minZNeg + " maxZNeg " + maxZNeg);
				double newNum = maxZ - minZ;
				zPass = rand.nextInt((int) newNum) + 1;
				zPass = minZ + zPass;
			}
				Location loc = new Location(Bukkit.getWorld("world"), xPass, VoltramDrops.plugin.getConfig().getInt("Regions." + name + ".dropFromHeight"), zPass);
				locations.add(loc);
				System.out.println(loc);
			}
		}
	}

