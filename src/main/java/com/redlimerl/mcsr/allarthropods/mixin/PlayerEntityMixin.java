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

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onKilledOther(LivingEntity other) {
        super.onKilledOther(other);

        InGameTimer timer = InGameTimer.getInstance();

        if (timer.getCategory() != AllArthropods.ALL_ARTHROPODS_CATEGORY || !timer.isPlaying()) return;

        if (other.getType() == EntityType.SPIDER) {
            timer.updateMoreData(0, 1);
        }
        if (other.getType() == EntityType.CAVE_SPIDER) {
            timer.updateMoreData(1, 1);
        }
        if (other.getType() == EntityType.SILVERFISH) {
            timer.updateMoreData(2, 1);
        }
        if (other.getType() == EntityType.ENDERMITE) {
            timer.updateMoreData(3, 1);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (timer.getMoreData(i) != 0) result++;
        }
        if (result == 4) {
            InGameTimer.complete();
        }
    }
}
