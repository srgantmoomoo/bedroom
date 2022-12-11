package me.srgantmoomoo.bedroom.api.event.events;

import me.srgantmoomoo.bedroom.api.event.Event;

public class EventWorldRender extends Event {

	public final float partialTicks;

	public EventWorldRender(float partialTicks) {
		this.partialTicks = partialTicks;
	}
}