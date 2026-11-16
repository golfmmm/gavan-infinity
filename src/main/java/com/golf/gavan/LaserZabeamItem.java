package com.golf.gavan;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LaserZabeamItem extends Item {
    public LaserZabeamItem(Properties props) { super(props); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            Arrow arrow = new Arrow(level, player);
            arrow.setBaseDamage(6.0);
            arrow.setNoGravity(true);
            arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
            arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, 4.0f, 0f);
            level.addFreshEntity(arrow);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
        }
        level.playSound(null, player.blockPosition(), SoundEvents.FIREWORK_ROCKET_BLAST,
                SoundSource.PLAYERS, 1.0f, 1.5f);
        player.getCooldowns().addCooldown(this, 10);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
