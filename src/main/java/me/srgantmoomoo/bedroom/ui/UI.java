package me.srgantmoomoo.bedroom.ui;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.api.event.events.EventDrawOverlay;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

public class UI {
	private MinecraftClient mc = MinecraftClient.getInstance();

	public UI() {
		Main.EVENTBUS.subscribe(listener);
	}
	
	@EventHandler
	private final Listener<EventDrawOverlay> listener = new Listener<>(e -> {
		TextRenderer fr = mc.textRenderer;
		fr.drawWithShadow(e.matrix, Main.name, 1, 1, 0xffffffff);
	});

}