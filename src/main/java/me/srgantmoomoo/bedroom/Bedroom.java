package me.srgantmoomoo.bedroom;

import me.srgantmoomoo.bedroom.api.event.events.EventKeyPress;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.util.InputUtil;
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

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public abstract class Bedroom {
	public static Bedroom INSTANCE;
	
	public Bedroom() {
		INSTANCE = this;
	}

	public static ModuleManager moduleManager;
	public static SettingManager settingManager;
	public static SaveLoad saveLoad;
	public static EventProcessor eventProcessor;
	public static CommandManager commandManager;
	
	public static final Logger LOGGER = LogManager.getLogger("bedroom");
	public static EventBus EVENTBUS = new EventManager();

	public static final Object syncronize = new Object();
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

	public static String modid;
	public static String modname;
	public static String modversion;

	public static void setVariables(String id, String name, String version) {
		modid = id;
		modname = name;
		modversion = version;
	}

	public static void init(String id, String name, String version) {
		printLog("welcome to bedroom!");
		printLog("\n" +
                " __                     __                                       \n" +
                "[  |                   |  ]                                      \n" +
                " | |.--.   .---.   .--.| |  _ .--.   .--.    .--.   _ .--..--.   \n" +
                " | '/'`\\ \\/ /__\\\\/ /'`\\' | [ `/'`\\]/ .'`\\ \\/ .'`\\ \\[ `.-. .-. |  \n" +
                " |  \\__/ || \\__.,| \\__/  |  | |    | \\__. || \\__. | | | | | | |  \n" +
                "[__;.__.'  '.__.' '.__.;__][___]    '.__.'  '.__.' [___||__||__] \n");

		setVariables(id, name, version);
		printLog("variables initialized.");

		eventProcessor = new EventProcessor();
		printLog("event system initialized.");

		commandManager = new CommandManager();
		printLog("command system initialized.");

		moduleManager = new ModuleManager();
		printLog("module system initialized.");

		settingManager = new SettingManager();
		printLog("setting system initialized.");
		
		//saveLoad = new SaveLoad();
		//printLog("config initialized.");
	}

}