package me.srgantmoomoo.bedroom.module.modules.miscellaneous;

import org.lwjgl.glfw.GLFW;

import me.srgantmoomoo.bedroom.module.Module;

public class ExampleMiscellaneousModule extends Module {
	
	public ExampleMiscellaneousModule() {
		super("example miscellaneous module", "this is an example miscellaneous module.", GLFW.GLFW_KEY_J, Category.MISCELLANEOUS);
	}
	
}

