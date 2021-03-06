package me.srgantmoomoo.bedroom.module;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.google.common.eventbus.Subscribe;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.api.event.events.EventDrawOverlay;
import me.srgantmoomoo.bedroom.api.event.events.EventKeyPress;
import me.srgantmoomoo.bedroom.module.Module.Category;
import me.srgantmoomoo.bedroom.module.modules.movement.*;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.InputUtil;

public class ModuleManager {
	
	public static ArrayList<Module> modules;
	
	public ModuleManager() {
		Main.EVENTBUS.subscribe(listener);
		modules = new ArrayList<>();
		ModuleManager.modules.add(new Sprint());
	}
	
	public static boolean isModuleEnabled(String name){
		Module m = modules.stream().filter(mm->mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
		return m.isEnabled();
	}
	
	public Module getModule (String name) {
		for (Module m : ModuleManager.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public static ArrayList<Module> getModules() {
		return modules;
	}
	
	public static List<Module> getModulesByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : ModuleManager.modules) {
			if(!m.getName().equals("Esp2dHelper")) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		}
		return modules;
	}
	
	public static Module getModuleByName(String name){
		Module m = modules.stream().filter(mm->mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
		return m;
	}
	
	@EventHandler
	private final Listener<EventKeyPress> listener = new Listener<>(e -> {
		if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_F3))
			return;

		modules.stream().filter(m -> m.getKey() == e.getKey()).forEach(Module::toggle);
	});
	
}
