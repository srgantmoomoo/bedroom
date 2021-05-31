package me.srgantmoomoo.bedroom.api.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import me.srgantmoomoo.bedroom.Bedroom;
import me.srgantmoomoo.bedroom.command.CommandManager;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.ModuleManager;
import me.srgantmoomoo.bedroom.module.setting.Setting;
import me.srgantmoomoo.bedroom.module.setting.settings.BooleanSetting;
import me.srgantmoomoo.bedroom.module.setting.settings.ModeSetting;
import me.srgantmoomoo.bedroom.module.setting.settings.NumberSetting;
import net.minecraft.client.MinecraftClient;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class SaveLoad {
	private File dir;
	private File dataFile;
	
	@SuppressWarnings("resource")
	public SaveLoad() {
		dir = new File(MinecraftClient.getInstance().runDirectory, Bedroom.variables.modname);
		if(!dir.exists()) {
			dir.mkdir();
		}
		dataFile = new File(dir, "config.txt");
		if(!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}
		
		this.load();
	}
	
	public void save() {
		ArrayList<String> toSave = new ArrayList<String>();
		
		for(Module mod : ModuleManager.modules) {
			toSave.add("MOD:" + mod.getName() + ":" + mod.isEnabled() + ":" + mod.getKey());
		}
		
		for(Module mod : ModuleManager.modules) {
			for(Setting setting : mod.settings) {
				
				if(setting instanceof BooleanSetting) {
					BooleanSetting bool = (BooleanSetting) setting;
					toSave.add("SET:" + mod.getName() + ":" + setting.name + ":" + bool.isEnabled());
				}
				
				if(setting instanceof NumberSetting) {
					NumberSetting numb = (NumberSetting) setting;
					toSave.add("SET:" + mod.getName() + ":" + setting.name + ":" + numb.getValue());
				}
				
				if(setting instanceof ModeSetting) {
					ModeSetting mode = (ModeSetting) setting;
					toSave.add("SET:" + mod.getName() + ":" + setting.name + ":" + mode.getMode());
				}
			}
		}
		
		toSave.add("COMMANDPREFIX:" + CommandManager.prefix);
		
		try {
			PrintWriter pw = new PrintWriter(this.dataFile);
			for(String str : toSave) {
				pw.println(str);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.dataFile));
			String line = reader.readLine();
			while(line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		for(String s : lines) {
			String[] args = s.split(":");
			if(s.toLowerCase().startsWith("mod:")) {
				Module m = Bedroom.classes.moduleManager.getModule(args[1]);
				if(m != null) {
					m.setEnabled(Boolean.parseBoolean(args[2]));
					m.setKey(Integer.parseInt(args[3]));
				}
			}else if(s.toLowerCase().startsWith("set:")) {
				Module m = Bedroom.classes.moduleManager.getModule(args[1]);
				if(m != null) {
					Setting setting = Bedroom.classes.settingManager.getSettingByName(m, args[2]);
					if(setting != null) {
						if(setting instanceof BooleanSetting) {
							((BooleanSetting)setting).setEnabled(Boolean.parseBoolean(args[3]));
						}
						if(setting instanceof NumberSetting) {
							((NumberSetting)setting).setValue(Double.parseDouble(args[3]));
						}
						if(setting instanceof ModeSetting) {
							((ModeSetting)setting).setMode(args[3]);
						}
					}
				}
			}else if(s.toLowerCase().startsWith("commandprefix:")) {
				CommandManager.setCommandPrefix(args[1]);
			}
		}
	}
}
