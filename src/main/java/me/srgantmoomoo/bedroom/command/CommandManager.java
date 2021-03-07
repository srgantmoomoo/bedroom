package me.srgantmoomoo.bedroom.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.module.ModuleManager;

public class CommandManager {
	
	public static List<Command> commands = new ArrayList<Command>();
	public static String prefix = ",";
	public boolean commandFound = false;
	
	public CommandManager() {
		//Main.EVENTBUS.subscribe(listener);
		register();
	}
	
	public void register() {
		commands.add(new Toggle());
	}
	
	public static void callCommandReturn(String input) {
        String message = input;
        
        if(!message.startsWith(prefix))
        	return;
        
        message = message.substring(prefix.length());
        if(message.split(" ").length > 0) {
        	boolean commandFound = false;
        	String commandName = message.split(" ")[0];
        	for(Command c : commands) {
        		if(c.aliases.contains(commandName) || c.name.equalsIgnoreCase(commandName)) {
        		c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
        		commandFound = true;
        		break;
        		}
        	}
        	if(!commandFound) {
        		ModuleManager.addChatMessage(TextFormatting.DARK_RED + "command does not exist, use " + TextFormatting.ITALIC + prefix + "help " + TextFormatting.RESET + "" + TextFormatting.DARK_RED + "for help.");
        	}
        }
    }
	
	/* @EventHandler
	private final Listener<EventKeyPress> listener = new Listener<>(e -> {
		if (prefix.length() == 1) {
            final char key = Keyboard.getEventCharacter();
            if (prefix.charAt(0) == key) {
                MinecraftClient.getInstance().openScreen(new ChatScreen(""));
                ((ChatScreen) MinecraftClient.getInstance().currentScreen).inputeField.setText(prefix);
            }
        }
	}); */

	public static void setCommandPrefix(String pre) {
        prefix = pre;
    }
	
}