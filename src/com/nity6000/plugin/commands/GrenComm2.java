package com.nity6000.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class GrenComm2 implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be player to use this command");
			return false;
		}
		Player player = (Player) sender;
		player.sendMessage((ChatColor.GREEN + "(Grenade Out)"));

		TNTPrimed tnt = player.getWorld().spawn(player.getLocation().add(0, 1, 0), TNTPrimed.class);
		// -------------------------------------------------------------------------------------------------------------------------------\\
		Location blockLoc = player.getEyeLocation().add(0, -1, 0);
		if (blockLoc.getBlock().getType().equals(Material.AIR)
				|| blockLoc.getBlock().getType() == (Material.LONG_GRASS)) {
			tnt.eject();
			player.playEffect(player.getLocation(), Effect.EXTINGUISH, 10);
		} else {
			player.sendMessage(ChatColor.DARK_RED + "Grenade had trouble detonating, "
					+ (ChatColor.GOLD + "make sure the block you are standing in is air! "));
			return false;
		}
		return true;
	}
}
