package me.srgantmoomoo.bedroom.module.modules.render;

import org.lwjgl.glfw.GLFW;

import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.settings.BooleanSetting;
import me.srgantmoomoo.bedroom.module.setting.settings.ModeSetting;
import me.srgantmoomoo.bedroom.module.setting.settings.NumberSetting;

public class ExampleRenderModule extends Module {
	public BooleanSetting exampleBoolean = new BooleanSetting("exampleBoolean", this, false);
	public ModeSetting exampleMode = new ModeSetting("exampleMode", this, "mode1", "mode1", "mode2", "mode3"); 
	public NumberSetting exampleNumber = new NumberSetting("exampleNumber", this, 2, 1, 5, 1);
	
	public ExampleRenderModule() {
		super("example render module", "this is an example render module.", GLFW.GLFW_KEY_G, Category.RENDER);
		this.addSettings(exampleBoolean, exampleMode, exampleNumber);
	}
	
}
