package me.srgantmoomoo.bedroom.api.event;

import me.srgantmoomoo.bedroom.Bedroom;
import me.srgantmoomoo.bedroom.api.event.events.EventTick;
import me.srgantmoomoo.bedroom.module.ModuleManager;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.MinecraftClient;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class EventProcessor implements Listenable {
	
	public static EventProcessor instance;

	public EventProcessor() {
		instance = this;
	}
	
	@EventHandler
	private final Listener<EventTick> listener = new Listener<>(e -> {
		if (MinecraftClient.getInstance().player != null) {
			ModuleManager.onUpdate();
		}
	});

}