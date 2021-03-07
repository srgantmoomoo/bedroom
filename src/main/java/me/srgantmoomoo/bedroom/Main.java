package me.srgantmoomoo.bedroom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.srgantmoomoo.bedroom.api.config.SaveLoad;
import me.srgantmoomoo.bedroom.api.event.EventProcessor;
import me.srgantmoomoo.bedroom.command.CommandManager;
import me.srgantmoomoo.bedroom.module.ModuleManager;
import me.srgantmoomoo.bedroom.setting.SettingManager;
import me.srgantmoomoo.bedroom.ui.UI;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	
	public static final String modid = "bed";
	public static final String name = "bedroom";
	public static final String nameCondensed = "bedroom";
	public static final String version = "0.0.1";
	
	public static final Logger LOGGER = LogManager.getLogger("bedroom");
	public static EventBus EVENTBUS = new EventManager();
	
	public static UI ui;
	public static ModuleManager moduleManager;
	public static SettingManager settingManager;
	public static SaveLoad saveLoad;
	public static EventProcessor eventProcessor;
	public static CommandManager commandManager;
	
	public Object syncronize = new Object();
	public void printLog(String text) {
		synchronized (syncronize) {
			LOGGER.info(text);
		}
	}
	
	@Override
	public void onInitialize() {
		printLog("welcome to bedroom!");
		
		printLog("\n" +
                " __                     __                                       \n" +
                "[  |                   |  ]                                      \n" +
                " | |.--.   .---.   .--.| |  _ .--.   .--.    .--.   _ .--..--.   \n" +
                " | '/'`\\ \\/ /__\\\\/ /'`\\' | [ `/'`\\]/ .'`\\ \\/ .'`\\ \\[ `.-. .-. |  \n" +
                " |  \\__/ || \\__.,| \\__/  |  | |    | \\__. || \\__. | | | | | | |  \n" +
                "[__;.__.'  '.__.' '.__.;__][___]    '.__.'  '.__.' [___||__||__] \n");
		
		// inits
		
		eventProcessor = new EventProcessor();
		Main.EVENTBUS.subscribe(eventProcessor);
		printLog("event system initialized.");
		
		ui = new UI();
		
		commandManager = new CommandManager();
		printLog("command system initialized.");
		
		moduleManager = new ModuleManager();
		printLog("module system initialized.");
		
		settingManager = new SettingManager();
		printLog("setting system initialized.");
		
		saveLoad = new SaveLoad();
		printLog("config initialized.");

		//
		
		printLog(Main.name + " has finished initialization :)");
	}

}