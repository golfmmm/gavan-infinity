package com.golf.gavan;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** ใส่เกราะ Gavan ครบชุด = แปลงร่าง (เอฟเฟกต์ + โบนัส) */
@Mod.EventBusSubscriber(modid = GavanMod.MODID)
public class ArmorSetHandler {

    public static boolean hasFullSet(Player p) {
        for (ItemStack s : p.getArmorSlots()) {
            if (!(s.getItem() instanceof ArmorItem a) || a.getMaterial() != ModArmorMaterials.GAVAN) return false;
        }
        return true;
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent e) {
        Player p = e.player;
        if (e.phase != TickEvent.Phase.END || p.level().isClientSide || p.tickCount % 20 != 0) return;
        if (!hasFullSet(p)) return;
        p.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, true, false));
        p.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, true, false));
        p.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, true, false));
        p.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 1, true, false));
        p.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0, true, false));
        p.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, true, false));
    }

    @SubscribeEvent
    public static void onEquip(LivingEquipmentChangeEvent e) {
        if (!(e.getEntity() instanceof Player p) || p.level().isClientSide) return;
        if (e.getSlot().getType() != EquipmentSlot.Type.ARMOR || !hasFullSet(p)) return;
        ServerLevel level = (ServerLevel) p.level();
        level.sendParticles(ParticleTypes.END_ROD, p.getX(), p.getY() + 1.0, p.getZ(), 60, 0.4, 0.9, 0.4, 0.1);
        level.sendParticles(ParticleTypes.FLASH, p.getX(), p.getY() + 1.0, p.getZ(), 1, 0, 0, 0, 0);
        level.playSound(null, p.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 1.0f, 1.4f);
        p.displayClientMessage(Component.translatable("message.gavaninfinity.transform"), true);
    }
}
