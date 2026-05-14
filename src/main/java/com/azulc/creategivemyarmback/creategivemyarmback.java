package com.azulc.creategivemyarmback;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;

import com.azulc.creategivemyarmback.client.*;

@Mod(creategivemyarmback.MODID)
public class creategivemyarmback 
{
    public static final String MODID = "creategivemyarmback";
    public static final Logger LOGGER = LogUtils.getLogger();

    public creategivemyarmback() 
    {
        System.out.println("Create: Give My Arm Back Loaded");
        NeoForge.EVENT_BUS.addListener(CreateRenderFix::onRenderArm);
        if (ModList.get().isLoaded("create_sa"))
        {
            if(FMLEnvironment.dist == Dist.CLIENT)
            NeoForge.EVENT_BUS.addListener(CreateSARenderFix::onRenderArm);
        }
    }
}
