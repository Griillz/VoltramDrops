package main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.internal.annotation.Selection;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;

public class CommandVD implements CommandExecutor {
	
	Player player;


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getServer().getLogger().warning("The console cannot run this command!");
			return true;
		}
		Player p = (Player) sender;
		player = p;
		if(label.equalsIgnoreCase("vd") && args.length == 0) {
			p.sendMessage(ChatColor.DARK_RED + "NOT ENOUGH ARGUMENTS!");
		}
		else if ( label.equalsIgnoreCase("vd") && args[0].equalsIgnoreCase("create") && args.length == 1) {
			p.sendMessage(ChatColor.DARK_RED + "Please type in a name for your region!");
			
		}
		else if(label.equalsIgnoreCase("vd") && args[0].equals("create") && args.length >= 2) {
			newRegion(p, args[1]);
			p.sendMessage(ChatColor.LIGHT_PURPLE + "REGION CREATED!");
		}
		return true;
	}
	
	
	public void newRegion(Player p, String name){
	    WorldEditPlugin worldEdit = getWorldEdit();
	    com.sk89q.worldedit.regions.Region selection = null;
		try {
			selection = worldEdit.getSession(p).getSelection(BukkitAdapter.adapt(p.getWorld()));
		} catch (IncompleteRegionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {

	    Location pos1 = BukkitAdapter.adapt(p.getWorld(), selection.getMinimumPoint());//Max
	    Location pos2 = BukkitAdapter.adapt(p.getWorld(), selection.getMaximumPoint());//Min
	    Region r = new Region(name, pos1.getBlockX() + .5, pos2.getBlockX() + .5, pos1.getBlockZ() + .5, pos2.getBlockZ() + .5, p);
	    p.sendMessage(name + " " + pos1.getBlockX() + " " + pos2.getBlockX() + " " + pos1.getBlockZ() + " " + pos2.getBlockZ());
		}
		catch(NullPointerException e) {
			System.out.println("SOMEHOW NULL??????????");
		}


	}

	public WorldEditPlugin getWorldEdit() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		if (p instanceof WorldEditPlugin)
			return (WorldEditPlugin) p;
		else
			return null;
	}

}
