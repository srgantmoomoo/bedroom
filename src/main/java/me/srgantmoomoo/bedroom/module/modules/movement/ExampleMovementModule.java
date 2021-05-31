package me.srgantmoomoo.bedroom.module.modules.movement;

import org.lwjgl.glfw.GLFW;

import me.srgantmoomoo.bedroom.module.Module;

public class ExampleMovementModule extends Module {
	
	public ExampleMovementModule() {
		super("example movement module", "this is an example movement module.", GLFW.GLFW_KEY_L, Category.MOVEMENT);
	}
	
}