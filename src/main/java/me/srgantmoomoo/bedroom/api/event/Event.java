package me.srgantmoomoo.bedroom.api.event;

import me.zero.alpine.event.type.Cancellable;
import net.minecraft.client.MinecraftClient;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class Event extends Cancellable {
	
	public static Era era = Era.PRE;

    public static Float partialTicks = MinecraftClient.getInstance().getTickDelta();

    public enum Era {
        PRE, POST
    }

}