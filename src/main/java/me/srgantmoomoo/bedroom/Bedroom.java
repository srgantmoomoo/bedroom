package me.srgantmoomoo.bedroom;

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

public final class Bedroom {
	public static Bedroom INSTANCE;
	
	public Bedroom() {
		INSTANCE = this;
	}

	public ModuleManager moduleManager;
	public SettingManager settingManager;
	public SaveLoad saveLoad;
	public EventProcessor eventProcessor;
	public CommandManager commandManager;
	
	public final Logger LOGGER = LogManager.getLogger("bedroom");
	public EventBus EVENTBUS = new EventManager();

	public final Object syncronize = new Object();
	public void printLog(String text) {
		synchronized (syncronize) {
			this.LOGGER.info(text);
		}
	}

	public void addModule(Module module) {
		ModuleManager.modules.add(module);
	}
	
	public void addCommand(Command command) {
		CommandManager.commands.add(command);
	}

	public String modid;
	public String modname;
	public String modversion;

	public void setVariables(String id, String name, String version) {
		this.modid = id;
		this.modname = name;
		this.modversion = version;
	}

	public void init(String id, String name, String version) {
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

		this.eventProcessor = new EventProcessor();
		EVENTBUS.subscribe(eventProcessor);
		printLog("event system initialized.");

		this.commandManager = new CommandManager();
		EVENTBUS.subscribe(commandManager);
		printLog("command system initialized.");

		this.moduleManager = new ModuleManager();
		EVENTBUS.subscribe(moduleManager);
		printLog("module system initialized.");

		this.settingManager = new SettingManager();
		printLog("setting system initialized.");
		
		//this.saveLoad = new SaveLoad();
		//printLog("config initialized.");
	}

}