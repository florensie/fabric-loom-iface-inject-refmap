package net.fabricmc.example.mixin;

import net.fabricmc.example.ExampleMod;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnimalEntity.class)
public class ExampleMixin {

	// Note that interactMob is an overriding/overridden method, base method is on MobEntity
	@Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/AnimalEntity;isBreedingItem(Lnet/minecraft/item/ItemStack;)Z"))
	private boolean test(AnimalEntity instance, ItemStack stack) {
		ExampleMod.LOGGER.info("This line is printed by an example mod mixin!");
		return true;
	}
}
