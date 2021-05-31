package me.srgantmoomoo.bedroom.command.commands;

import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;

public class Prefix extends Command {
	
	public Prefix() {
		super("prefix", "allows you to change the command prefix.", "prefix <key>", "p");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 1) {
			String key = args[0];
			CommandManager.setCommandPrefix(key);
			CommandManager.addChatMessage(String.format(TextFormatting.GREEN + "prefix " + TextFormatting.GRAY + "was set to " + TextFormatting.GREEN + CommandManager.prefix));
		} if(args.length == 0) CommandManager.correctUsageMsg(name, syntax);
	}
}
