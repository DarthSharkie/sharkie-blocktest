package me.sharkie.minecraft.sharkieblocktest.toolmaterial;

import me.sharkie.minecraft.sharkieblocktest.SharkieBlockTest;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AluminumToolMaterial implements ToolMaterial {
    public static final AluminumToolMaterial INSTANCE = new AluminumToolMaterial();

    @Override
    public int getDurability() {
        return 457;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // Aluminum is lighter than iron, so you can swing it faster!
        return 8.0F;
    }

    @Override
    public float getAttackDamage() {
        return 2.0F;
    }

    @Override
    public int getMiningLevel() {
        // Diamond is 3, and required for Obsidian.  Aluminum should not mine Obsidian.
        return 2;
    }

    @Override
    public int getEnchantability() {
        // Gold is 22, Diamond is 10.  Higher == better enchantments
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // Aluminum ingots required to repair (this will be interesting from a dependency perspective...)
        return Ingredient.ofItems(SharkieBlockTest.ALUMINUM_INGOT);
    }
}
