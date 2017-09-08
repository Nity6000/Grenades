package com.nity6000.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GrenComm1 implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		player.sendMessage(ChatColor.BLUE + "(Grenade Out)");
		/*-------------------------------------------------------------------------------------------------------------------------------*/
		Location blockLoc = player.getEyeLocation().add(0, -1, 0);
		if (blockLoc.getBlock().getType().equals(Material.AIR)
				|| blockLoc.getBlock().getType() == (Material.LONG_GRASS)) {
			blockLoc.getBlock().setType(Material.WATER);
			player.sendMessage(ChatColor.BLUE + "Splash! ");
			player.playEffect(player.getLocation(), Effect.BREWING_STAND_BREW, 10);
		} else {
			player.sendMessage(ChatColor.DARK_RED + "Grenade had trouble detonating, "
					+ (ChatColor.GOLD + "make sure the block you are standing in is air! "));
			return false;
		}
		// -------------------------------------------------------------------------------------------------------------------------------\\
		return true;
	}
}