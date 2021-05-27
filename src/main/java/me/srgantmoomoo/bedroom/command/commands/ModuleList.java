package me.srgantmoomoo.bedroom.command.commands;

import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.ModuleManager;

public class ModuleList extends Command {
	
	public ModuleList() {
		super("modulelist", "gets a list of all the modules.", "moduleList", "ml");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 0) {
			for(Module module : ModuleManager.getModules()) {
				CommandManager.addChatMessage(TextFormatting.WHITE + module.getCategory().name + ": " + TextFormatting.GRAY + module.getName());
			}
		} if(args.length > 0) CommandManager.correctUsageMsg(name, syntax);
	}
}