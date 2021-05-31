package com.example.mod.module;

import org.lwjgl.glfw.GLFW;

import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.settings.BooleanSetting;
import me.srgantmoomoo.bedroom.module.setting.settings.ModeSetting;
import me.srgantmoomoo.bedroom.module.setting.settings.NumberSetting;

public class ExampleModule extends Module {
	public BooleanSetting exampleBoolean = new BooleanSetting("exampleBoolean", this, false);
	public ModeSetting exampleMode = new ModeSetting("exampleMode", this, "mode1", "mode1", "mode2", "mode3"); 
	public NumberSetting exampleNumber = new NumberSetting("exampleNumber", this, 2, 1, 5, 1);

	public ExampleModule() {
		super("Example Module", "description", GLFW.GLFW_KEY_G, Category.MISCELLANEOUS);
		this.addSettings(exampleBoolean, exampleMode, exampleNumber);
	}
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onUpdate() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
}