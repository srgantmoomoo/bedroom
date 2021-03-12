package me.srgantmoomoo.bedroom.module.modules.render;

import org.lwjgl.glfw.GLFW;

import me.srgantmoomoo.bedroom.module.Module;

public class ExampleRenderModule extends Module {
	
	public ExampleRenderModule() {
		super("example render module", "this is an example render module.", GLFW.GLFW_KEY_G, Category.RENDER);
	}
	
}
