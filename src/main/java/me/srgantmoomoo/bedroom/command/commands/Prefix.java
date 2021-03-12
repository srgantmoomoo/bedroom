package me.srgantmoomoo.bedroom.command.commands;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;
import me.srgantmoomoo.bedroom.module.ModuleManager;

public class Prefix extends Command {
	
	public Prefix() {
		super("prefix", "change the prefix", "prefix", "p");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 1) {
			String key = args[0];
			CommandManager.setCommandPrefix(key);
			ModuleManager.addChatMessage(String.format(TextFormatting.GREEN + "prefix " + TextFormatting.GRAY + "was set to " + TextFormatting.GREEN + CommandManager.prefix));
		} if(args.length == 0) ModuleManager.addChatMessage("correct usage of prefix command -> " + CommandManager.prefix + "prefix <key>");
	}
}
