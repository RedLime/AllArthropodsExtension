package com.redlimerl.mcsr.allarthropods;

import com.redlimerl.speedrunigt.timer.category.RunCategory;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AllArthropods implements ClientModInitializer {

    public static final RunCategory ALL_ARTHROPODS_CATEGORY = new RunCategory("all_arthropods", "mc_juice/full_game#All_Arthropods", "All Arthropods");

    @Override
    public void onInitializeClient() {

    }
}
