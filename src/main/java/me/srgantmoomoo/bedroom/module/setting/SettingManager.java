package me.srgantmoomoo.bedroom.module.setting;

import me.srgantmoomoo.bedroom.module.Module;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class SettingManager {
	
	private ArrayList<Setting> settings;
	
	public SettingManager() {
		this.settings = new ArrayList<Setting>();
	}
	
	public void rSetting(Setting in){
		this.settings.add(in);
	}
	
	public ArrayList<Setting> getSettings() {
		return this.settings;
	}
	
	public List<Setting> getSettingsByMod(Module mod) {
		return mod.settings;
	}
	
	public Setting getSettingByName(Module mod, String name) {
		return mod.settings.stream().filter(setting -> setting.name.equalsIgnoreCase(name)).findAny().orElse(null);
	}
}