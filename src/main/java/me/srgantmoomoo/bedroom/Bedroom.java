package me.srgantmoomoo.bedroom;

import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.srgantmoomoo.bedroom.api.config.SaveLoad;
import me.srgantmoomoo.bedroom.api.event.EventProcessor;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.ModuleManager;
import me.srgantmoomoo.bedroom.module.setting.SettingManager;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;

import java.io.File;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class Bedroom {
	public static Bedroom INSTANCE;
	
	public Bedroom() {
		INSTANCE = this;
	}
	public String modid = "def";
	public String modname = "default";
	public String modversion = "1";

	public ModuleManager moduleManager;
	public SettingManager settingManager;
	public static SaveLoad saveLoad;
	public EventProcessor eventProcessor;
	public CommandManager commandManager;
	
	public static final Logger LOGGER = LogManager.getLogger("bedroom");
	public static EventBus EVENTBUS = new EventManager();
	
	public static Object syncronize = new Object();
	public static void printLog(String text) {
		synchronized (syncronize) {
			LOGGER.info(text);
		}
	}
	
	public void addModule(Module module) {
		ModuleManager.modules.add(module);
	}
	
	public void addCommand(Command command) {
		CommandManager.commands.add(command);
	}
	
	public static void init() {
		printLog("welcome to bedroom!");
		printLog("\n" +
                " __                     __                                       \n" +
                "[  |                   |  ]                                      \n" +
                " | |.--.   .---.   .--.| |  _ .--.   .--.    .--.   _ .--..--.   \n" +
                " | '/'`\\ \\/ /__\\\\/ /'`\\' | [ `/'`\\]/ .'`\\ \\/ .'`\\ \\[ `.-. .-. |  \n" +
                " |  \\__/ || \\__.,| \\__/  |  | |    | \\__. || \\__. | | | | | | |  \n" +
                "[__;.__.'  '.__.' '.__.;__][___]    '.__.'  '.__.' [___||__||__] \n");
		
		Bedroom.INSTANCE.eventProcessor = new EventProcessor();
		printLog("event system initialized.");

		Bedroom.INSTANCE.commandManager = new CommandManager();
		printLog("command system initialized.");

		Bedroom.INSTANCE.moduleManager = new ModuleManager();
		printLog("module system initialized.");

		Bedroom.INSTANCE.settingManager = new SettingManager();
		printLog("setting system initialized.");
		
		saveLoad = new SaveLoad();
		printLog("config initialized.");
	}

}