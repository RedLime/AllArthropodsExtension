package com.redlimerl.mcsr.allarthropods.mixin;

import com.redlimerl.mcsr.allarthropods.AllArthropods;
import com.redlimerl.speedrunigt.timer.InGameTimer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    public PlayerEntityMixin(World world) {
        super(world);
    }

    @Override
    public void method_6098(LivingEntity other) {
        super.method_6098(other);

        InGameTimer timer = InGameTimer.getInstance();

        if (timer.getCategory() != AllArthropods.ALL_ARTHROPODS_CATEGORY || !timer.isPlaying()) return;

        if (EntityType.getIdByEntity(other) == 52) {
            timer.updateMoreData(0, 1);
        }
        if (EntityType.getIdByEntity(other) == 59) {
            timer.updateMoreData(1, 1);
        }
        if (EntityType.getIdByEntity(other) == 60) {
            timer.updateMoreData(2, 1);
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (timer.getMoreData(i) != 0) result++;
        }
        if (result == 3) {
            InGameTimer.complete();
        }
    }
}
