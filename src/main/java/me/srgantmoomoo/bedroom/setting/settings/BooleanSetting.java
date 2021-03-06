package me.srgantmoomoo.bedroom.setting.settings;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.setting.Setting;

public class BooleanSetting extends Setting {
	public boolean enabled;
	  
	public BooleanSetting(String name, Module parent, boolean enabled) {
	    this.name = name;
	    this.parent = parent;
	    this.enabled = enabled;
	}
	  
	public boolean isEnabled() {
	    return this.enabled;
	}
	  
	public void setEnabled(boolean enabled) {
	    this.enabled = enabled;
	    
	    if(Main.saveLoad != null) {
			Main.saveLoad.save();
	    }
	}
	
	public void toggle() {
	    this.enabled = !this.enabled;
	    
	    if(Main.saveLoad != null) {
			Main.saveLoad.save();
	    }
	}
}
