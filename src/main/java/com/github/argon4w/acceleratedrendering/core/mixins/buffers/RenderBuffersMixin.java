package com.github.argon4w.acceleratedrendering.core.mixins.buffers;

import com.github.argon4w.acceleratedrendering.core.CoreBuffersProvider;
import com.github.argon4w.acceleratedrendering.core.CoreFeature;
import net.minecraft.client.renderer.RenderBuffers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderBuffers.class)
public class RenderBuffersMixin {

	@Inject(
			method	= "<init>",
			at		= @At("TAIL")
	)
	private void onConstructed(CallbackInfo ci) {
		if (!CoreFeature.isLoaded()) {
			return;
		}

		CoreBuffersProvider.bindAcceleratedBufferSources((RenderBuffers) (Object) this);
	}
}