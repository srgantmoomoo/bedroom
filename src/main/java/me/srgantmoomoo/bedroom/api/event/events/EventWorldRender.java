package me.srgantmoomoo.bedroom.api.event.events;

import me.srgantmoomoo.bedroom.api.event.Event;
import net.minecraft.client.util.math.MatrixStack;

public class EventWorldRender extends Event<EventWorldRender> {

    public final float partialTicks;
    public MatrixStack matrix;

    public EventWorldRender(float partialTicks, MatrixStack matrix) {
        this.partialTicks = partialTicks;
        this.matrix = matrix;
    }
}