package me.srgantmoomoo.bedroom.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.setting.Setting;
import me.srgantmoomoo.bedroom.setting.settings.KeybindSetting;
import net.minecraft.client.MinecraftClient;

public class Module {
	
	protected static final MinecraftClient mc = MinecraftClient.getInstance();
	public static ArrayList<Module> modules;
	
	public String name, description;
	public KeybindSetting keyCode = new KeybindSetting(0);
	public Category category;
	public boolean enabled;
	public int index;
	public List<Setting> settings = new ArrayList<Setting>();
	
	public Module(String name, String description, int key, Category category) {
		super();
		this.name = name;
		this.description = description;
		keyCode.code = key;
		this.addSettings(keyCode);
		this.category = category;
		this.enabled = false;
	}
	
	public void addSettings(Setting... settings) {
		this.settings.addAll(Arrays.asList(settings));
		this.settings.sort(Comparator.comparingInt(s -> s == keyCode ? 1 : 0));
	}
	
	public enum Category {
		PLAYER("player"), RENDER("render");
		
		public String name;
		public int moduleIndex;
		
		Category(String name) {
			this.name = name;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getKey() {
		return keyCode.code;
	}
	
	public void setKey(int key) {
		this.keyCode.code = key;
		
		 if(Main.saveLoad != null) {
				Main.saveLoad.save();
		 }
	} 
	
	public void toggle() {
		if(isEnabled()) {
			disable();
		}
		else if(!isEnabled()) {
			enable();
		}
		
		if(Main.saveLoad != null) {
			Main.saveLoad.save();
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		
		if(Main.saveLoad != null) {
			Main.saveLoad.save();
		}
	}
	
	public void enable() {
		setEnabled(true);
		onEnable();
	}

	public void disable() {
		setEnabled(false);
		onDisable();
	}
	
	public void onEnable() {

	}
	
	public void onDisable() {

	}

}
