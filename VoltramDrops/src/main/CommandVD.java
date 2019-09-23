package main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.session.ClipboardHolder;

public class CommandVD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getServer().getLogger().warning("The console cannot run this command!");
			return true;
		}
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("vd") && args[0].equals("create")) {
			try {
				ClipboardHolder clipboard = getWorldEdit().getSession(p).getClipboard();

			} catch (EmptyClipboardException e) {
				sender.sendMessage("You have not made a WorldEdit Selection!");
			}
		}
		return true;
	}

	public WorldEditPlugin getWorldEdit() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		if (p instanceof WorldEditPlugin)
			return (WorldEditPlugin) p;
		else
			return null;
	}

}
