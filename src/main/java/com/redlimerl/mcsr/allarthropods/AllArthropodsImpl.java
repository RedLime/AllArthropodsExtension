package com.redlimerl.mcsr.allarthropods;

import com.redlimerl.speedrunigt.api.SpeedRunIGTApi;
import com.redlimerl.speedrunigt.timer.running.RunCategory;

public class AllArthropodsImpl implements SpeedRunIGTApi {

    @Override
    public RunCategory registerCategory() {
        return AllArthropods.ALL_ARTHROPODS_CATEGORY;
    }
}
