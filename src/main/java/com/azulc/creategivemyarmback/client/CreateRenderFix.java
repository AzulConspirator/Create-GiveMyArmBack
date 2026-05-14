package com.azulc.creategivemyarmback.client;

import java.lang.reflect.Field;

import com.simibubi.create.content.equipment.armor.NetheriteBacktankFirstPersonRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderArmEvent;

@EventBusSubscriber(
    modid = "creategivemyarmback",
    value = Dist.CLIENT
)
public class CreateRenderFix {

    private static Field rendererActiveField;

    static {
        try {

            rendererActiveField =
                NetheriteBacktankFirstPersonRenderer.class
                    .getDeclaredField("rendererActive");

            rendererActiveField.setAccessible(true);

            System.out.println("[Create: Give My Arm Back] Found field in NetheriteBacktankFirstPersonRenderer");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderArm(RenderArmEvent event) {

        try {

            rendererActiveField.setBoolean(null, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}