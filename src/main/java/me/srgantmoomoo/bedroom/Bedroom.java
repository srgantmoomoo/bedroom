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
import me.srgantmoomoo.bedroom.ui.UI;
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
	
	public static class variables {
		public static String modid;
		public static String modname;
		public static String modversion;	
	}
	
	public static class includes {
		public static boolean includeDefaultCommands;
		public static boolean includeUI;	
	}

	public static UI ui;
	public static ModuleManager moduleManager;
	public static SettingManager settingManager;
	public static SaveLoad saveLoad;
	public static EventProcessor eventProcessor;
	public static CommandManager commandManager;
	
	public static final Logger LOGGER = LogManager.getLogger("bedroom");
	public static EventBus EVENTBUS = new EventManager();
	
	public static Object syncronize = new Object();
	public static void printLog(String text) {
		synchronized (syncronize) {
			LOGGER.info(text);
		}
	}
	
	public static void addModule(Module module) {
		ModuleManager.modules.add(module);
	}
	
	public static void addCommand(Command command) {
		CommandManager.commands.add(command);
	}

	public File directory = MinecraftClient.getInstance().runDirectory;
	
	public static void init() {
		printLog("welcome to bedroom!");
		printLog("\n" +
                " __                     __                                       \n" +
                "[  |                   |  ]                                      \n" +
                " | |.--.   .---.   .--.| |  _ .--.   .--.    .--.   _ .--..--.   \n" +
                " | '/'`\\ \\/ /__\\\\/ /'`\\' | [ `/'`\\]/ .'`\\ \\/ .'`\\ \\[ `.-. .-. |  \n" +
                " |  \\__/ || \\__.,| \\__/  |  | |    | \\__. || \\__. | | | | | | |  \n" +
                "[__;.__.'  '.__.' '.__.;__][___]    '.__.'  '.__.' [___||__||__] \n");
		
		eventProcessor = new EventProcessor();
		printLog("event system initialized.");
		
		//commandManager = new CommandManager();
		printLog("command system initialized.");
		
		moduleManager = new ModuleManager();
		printLog("module system initialized.");
		
		settingManager = new SettingManager();
		printLog("setting system initialized.");

		ui = new UI();
		printLog("ui initialized.");
		
		saveLoad = new SaveLoad();
		printLog("config initialized.");
	}

}