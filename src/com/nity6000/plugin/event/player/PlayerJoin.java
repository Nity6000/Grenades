package com.nity6000.plugin.event.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.nity6000.plugin.Grenades;

public class PlayerJoin implements Listener {

	private Grenades plugin;

	public PlayerJoin(Grenades pl) {
		plugin = pl;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&',
				plugin.getConfig().getString("Welcome Message"));

		Player player = event.getPlayer();
		player.sendMessage(welcomeMessage);
	}
}
