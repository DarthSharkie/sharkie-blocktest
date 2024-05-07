package me.sharkie.minecraft.sharkieblocktest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SharkieBlockTest implements ModInitializer {

    public static final Block BAUXITE_BLOCK = new Block(FabricBlockSettings.create().strength(4.0f, 4.0f).requiresTool().mapColor(MapColor.DULL_RED));
    public static final Item BAUXITE_ITEM = new BlockItem(BAUXITE_BLOCK, new Item.Settings());
    public static final String MODID = "sharkie-blocktest";
    public static final Identifier BAUXITE_ORE_IDENTIFIER = new Identifier(MODID, "bauxite_ore");

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, BAUXITE_ORE_IDENTIFIER, BAUXITE_BLOCK);
        Registry.register(Registries.ITEM, BAUXITE_ORE_IDENTIFIER, BAUXITE_ITEM);
    }
}
