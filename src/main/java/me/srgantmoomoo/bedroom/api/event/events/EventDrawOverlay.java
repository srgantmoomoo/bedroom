package me.srgantmoomoo.bedroom.api.event.events;

import me.srgantmoomoo.bedroom.api.event.Event;
import net.minecraft.client.util.math.MatrixStack;

// posted in MixinInGameHud
public class EventDrawOverlay extends Event<EventDrawOverlay> {

	public MatrixStack matrix;

	public EventDrawOverlay(MatrixStack matrix) {
		this.matrix = matrix;
	}
}