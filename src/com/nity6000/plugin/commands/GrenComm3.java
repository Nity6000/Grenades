package com.nity6000.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("deprecation")
public class GrenComm3 implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command");
			return false;
		}
		Player player = (Player) sender;
		player.sendMessage(ChatColor.DARK_RED + "(Grenade out)");

		// -------------------------------------------------------------------------------------------------------------------------------\\

		Location blockLoc = player.getEyeLocation().add(0, -1, 0);
		if (blockLoc.getBlock().getType().equals(Material.AIR)
				|| blockLoc.getBlock().getType().equals(Material.LONG_GRASS)) {
			blockLoc.getBlock().setType(Material.LAVA);
			player.sendMessage(ChatColor.DARK_RED + "Bubble! ");
			player.playEffect(player.getLocation(), Effect.BLAZE_SHOOT, (10));

		} else {
			player.sendMessage(ChatColor.DARK_RED + "Grenade had trouble detonating, "
					+ (ChatColor.GOLD + "make sure the block you are standing in is air! "));
			return false;
		}
		return true;
	}
}
