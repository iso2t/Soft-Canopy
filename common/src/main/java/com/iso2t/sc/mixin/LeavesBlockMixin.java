package com.iso2t.sc.mixin;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin {

    @ModifyArg(
        method = "<init>",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;<init>(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V"),
        index = 0
    )
    private static BlockBehaviour.Properties softcanopy$softenLeaves(BlockBehaviour.Properties properties) {
        return properties.noCollision().isValidSpawn((_, _, _, _) -> false);
    }
}
