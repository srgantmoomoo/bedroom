package me.srgantmoomoo.bedroom.api.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import me.srgantmoomoo.bedroom.command.CommandManager;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;

@Mixin(ClientConnection.class)
public class MixinClientConnection {
	@Shadow
	private Channel channel;

	@Shadow
	private void sendImmediately(Packet<?> packet_1, GenericFutureListener<? extends Future<? super Void>> genericFutureListener_1) {
	}

	@Inject(method = "send(Lnet/minecraft/network/Packet;Lio/netty/util/concurrent/GenericFutureListener;)V", at = @At("HEAD"), cancellable = true)
	public void send(Packet<?> packet_1, GenericFutureListener<? extends Future<? super Void>> genericFutureListener_1, CallbackInfo callback) {
		if (packet_1 instanceof ChatMessageC2SPacket) {
			ChatMessageC2SPacket pack = (ChatMessageC2SPacket) packet_1;
			if (pack.getChatMessage().startsWith(CommandManager.prefix)) {
				CommandManager.callCommandReturn(pack.getChatMessage());
				callback.cancel();
			}
		}
	}
}