package com.azulc.creategivemyarmback.client;

import java.lang.reflect.Field;

import net.mcreator.createstuffadditions.client.renderer.exoskeleton.AndesiteExoskeletonFirstPersonRenderer;
import net.mcreator.createstuffadditions.client.renderer.exoskeleton.BrassExoskeletonFirstPersonRenderer;
import net.mcreator.createstuffadditions.client.renderer.exoskeleton.CopperExoskeletonFirstPersonRenderer;
import net.mcreator.createstuffadditions.client.renderer.jetpack.NetheriteJetpackFirstPersonRenderer;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderArmEvent;

public class CreateSARenderFix {

    private static Field AndesiteExo_rendererActiveField;
    private static Field BrassExo_rendererActiveField;
    private static Field CopperExo_rendererActiveField;
    private static Field NetheriteJetpack_rendererActiveField;

    static {
        try {
            AndesiteExo_rendererActiveField =AndesiteExoskeletonFirstPersonRenderer.class.getDeclaredField("rendererActive");
            CopperExo_rendererActiveField =CopperExoskeletonFirstPersonRenderer.class.getDeclaredField("rendererActive");
            BrassExo_rendererActiveField =BrassExoskeletonFirstPersonRenderer.class.getDeclaredField("rendererActive");
            NetheriteJetpack_rendererActiveField =NetheriteJetpackFirstPersonRenderer.class.getDeclaredField("rendererActive");

            AndesiteExo_rendererActiveField.setAccessible(true);
            CopperExo_rendererActiveField.setAccessible(true);
            BrassExo_rendererActiveField.setAccessible(true);
            NetheriteJetpack_rendererActiveField.setAccessible(true);

            System.out.println("[Create: Give My Arm Back] Found field in Create Stuff & Additions renderers");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderArm(RenderArmEvent event) {

        try {

            AndesiteExo_rendererActiveField.setBoolean(null, false);
            CopperExo_rendererActiveField.setBoolean(null, false);
            BrassExo_rendererActiveField.setBoolean(null, false);
            NetheriteJetpack_rendererActiveField.setBoolean(null, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}