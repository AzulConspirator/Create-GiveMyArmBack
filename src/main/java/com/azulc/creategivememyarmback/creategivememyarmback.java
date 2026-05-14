package com.azulc.creategivememyarmback;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(creategivememyarmback.MODID)
public class creategivememyarmback {

    public static final String MODID = "creategivememyarmback";
    public static final Logger LOGGER = LogUtils.getLogger();

    public creategivememyarmback(IEventBus modEventBus, ModContainer modContainer) 
    {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) 
    {}
}
