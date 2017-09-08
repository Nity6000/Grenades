package com.nity6000.plugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nity6000.plugin.commands.GrenComm;
import com.nity6000.plugin.commands.GrenComm1;
import com.nity6000.plugin.commands.GrenComm2;
import com.nity6000.plugin.commands.GrenComm3;
import com.nity6000.plugin.event.block.BlockBreak;
import com.nity6000.plugin.event.player.PlayerChat;
import com.nity6000.plugin.event.player.PlayerJoin;

public class Grenades extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		registerCommands();
		registerEvents();
		registerConfig();

		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
	}

	public void registerCommands() {
		getCommand("firegrenade").setExecutor(new GrenComm());
		getCommand("watergrenade").setExecutor(new GrenComm1());
		getCommand("grenade").setExecutor(new GrenComm2());
		getCommand("fg").setExecutor(new GrenComm());
		getCommand("wg").setExecutor(new GrenComm1());
		getCommand("g").setExecutor(new GrenComm2());
		getCommand("lavagrenade").setExecutor(new GrenComm3());
		getCommand("lg").setExecutor(new GrenComm3());

	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerJoin(this), this);

	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
}
