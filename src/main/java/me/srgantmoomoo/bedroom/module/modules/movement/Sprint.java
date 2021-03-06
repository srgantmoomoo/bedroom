package me.srgantmoomoo.bedroom.module.modules.movement;

import org.lwjgl.glfw.GLFW;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.api.event.events.EventDrawOverlay;
import me.srgantmoomoo.bedroom.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.font.TextRenderer;

public class Sprint extends Module {
	
	public Sprint() {
		super("sprint", "sprinnnt.", GLFW.GLFW_KEY_G, Category.RENDER);
		enabled = true;
	}

	public void onEnable() {
		Main.EVENTBUS.subscribe(listener);
		mc.player.setSprinting(true);
	}
	
	@EventHandler
	private final Listener<EventDrawOverlay> listener = new Listener<>(e -> {
		TextRenderer fr = mc.textRenderer;
		fr.drawWithShadow(e.matrix, "penis gui", 1, 11, 0xffffffff);
	});
	
}
