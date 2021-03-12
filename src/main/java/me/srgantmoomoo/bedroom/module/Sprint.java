package me.srgantmoomoo.bedroom.module;

import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {
	
	public Sprint() {
		super("sprint", "this is sprint.", GLFW.GLFW_KEY_J, Category.PLAYER);
	}

}
