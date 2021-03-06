package me.srgantmoomoo.bedroom.api.event.events;

import me.srgantmoomoo.bedroom.api.event.Event;
import net.minecraft.client.util.math.MatrixStack;

public class EventDrawOverlay extends Event {

	public MatrixStack matrix;

	public EventDrawOverlay(MatrixStack matrix) {
		this.matrix = matrix;
	}
}