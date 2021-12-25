package me.srgantmoomoo.bedroom.module;

import me.srgantmoomoo.bedroom.api.event.Event;
import me.srgantmoomoo.bedroom.api.event.events.EventKeyPress;
import me.srgantmoomoo.bedroom.module.Module.Category;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class ModuleManager {

	public static ArrayList<Module> modules;
	
	public ModuleManager() {
		modules = new ArrayList<>();
	}

	public static void onEvent(Event e) {
		modules.stream().filter(Module::isEnabled).forEach(module -> module.onEvent(e));
	}

	public boolean isModuleEnabled(String name) {
		return getModule(name).isEnabled();
	}

	public Module getModule(String name) {
		return modules.stream().filter(module -> module.name.equalsIgnoreCase(name)).findAny().orElse(null);
	}

	public Module getModuleByID(String moduleID) {
		return modules.stream().filter(module -> module.getID().equalsIgnoreCase(moduleID)).findAny().orElse(null);
	}

	public ArrayList<Module> getModules() {
		return modules;
	}

	public List<Module> getModulesByCategory(Category c) {
		return modules.stream().filter(module -> module.getCategory() == c).collect(Collectors.toList());
	}

	// for key binds (called in MixinKeyboard).
	public void keyPress(int key, int scancode) {
		EventKeyPress e = new EventKeyPress(key, scancode);
		if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_F3))
			return;

		modules.stream().filter(m -> m.getKey() == e.getKey()).forEach(Module::toggle);
	}

}
