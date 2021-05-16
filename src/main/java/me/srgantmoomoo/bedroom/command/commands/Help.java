package me.srgantmoomoo.bedroom.command.commands;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;
public class Help extends Command {
	
	public Help() {
		super("help", "helps u penis.", "help", "h");
	}

	@Override
	public void onCommand(String[] args, String command) {
		
		CommandManager.addChatMessage(TextFormatting.BOLD + Main.name + " " + Main.version + "!");
		
		CommandManager.addChatMessage("prefix - " + TextFormatting.ITALIC + "allows you to change the command prefix" + " -> "  + CommandManager.prefix + "prefix <key>");
		
		CommandManager.addChatMessage("toggle - " + TextFormatting.ITALIC + "toggles modules on and off" + " -> "  + CommandManager.prefix + "toggle <module>");
		
		CommandManager.addChatMessage("modulelist - " + TextFormatting.ITALIC + "shows all of the modules in the client" + " -> " + CommandManager.prefix + "modulelist");
		
	}

}