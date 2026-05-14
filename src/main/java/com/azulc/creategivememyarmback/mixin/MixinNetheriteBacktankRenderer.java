package com.azulc.creategivememyarmback.mixin;

import com.simibubi.create.content.equipment.armor.NetheriteBacktankFirstPersonRenderer;
import net.neoforged.neoforge.client.event.RenderArmEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = NetheriteBacktankFirstPersonRenderer.class, remap = false)
public class MixinNetheriteBacktankRenderer {
    /**
     * @author AzulC
     * @reason Disabling the custom first-person arm render for Netherite Backtanks.
     */
    @Inject(method = "onRenderPlayerHand", at = @At("HEAD"), cancellable = true)
    private static void disableBacktankArmRender(RenderArmEvent event, CallbackInfo ci) {
        // By cancelling this Mixin injection at the HEAD, 
        // Create's original code never runs.
        ci.cancel();
    }
}