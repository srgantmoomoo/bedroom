package me.srgantmoomoo.bedroom.api.event;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.MinecraftClient;

public class EventProcessor implements Listenable {
	
	public static EventProcessor instance;
	MinecraftClient mc = MinecraftClient.getInstance();

	public EventProcessor() {
		instance = this;
	}

}
