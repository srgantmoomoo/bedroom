package me.srgantmoomoo.bedroom.command.commands;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;
import me.srgantmoomoo.bedroom.module.ModuleManager;

public class Help extends Command {
	
	public Help() {
		super("help", "helps u penis.", "help", "h");
	}

	@Override
	public void onCommand(String[] args, String command) {
		
		ModuleManager.addChatMessage(TextFormatting.BOLD + Main.name + " " + Main.version + "!");
		
		ModuleManager.addChatMessage("prefix - " + TextFormatting.ITALIC + "allows you to change the command prefix" + " -> "  + CommandManager.prefix + "prefix <key>");
		
		ModuleManager.addChatMessage("toggle - " + TextFormatting.ITALIC + "toggles modules on and off" + " -> "  + CommandManager.prefix + "toggle <module>");
		
	}

}