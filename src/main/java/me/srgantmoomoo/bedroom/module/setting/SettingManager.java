package me.srgantmoomoo.bedroom.module.setting;

import java.util.ArrayList;

import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.ModuleManager;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class SettingManager {
	
	private ArrayList<Setting> settings;
	
	public SettingManager(){
		this.settings = new ArrayList<Setting>();
	}
	
	public void rSetting(Setting in){
		this.settings.add(in);
	}
	
	public ArrayList<Setting> getSettings() {
		return this.settings;
	}
	
	public ArrayList<Setting> getSettingsByMod(Module mod) {
		ArrayList<Setting> out = new ArrayList<Setting>();
		for(Setting s : getSettings()) {
			if(s.parent.equals(mod)) {
				out.add(s);
			}
		}
		if(out.isEmpty()) {
			return null;
		}
		return out;
	}
	
	public Setting getSettingByName(Module mod, String name) {
		for (Module m : ModuleManager.modules) {
		for (Setting set : m.settings) {
			if (set.name.equalsIgnoreCase(name) && set.parent == mod) {
				return set;
			}
			}
		}
		System.err.println("[postman] Error Setting NOT found: '" + name +"'!");
		return null;
	}
}