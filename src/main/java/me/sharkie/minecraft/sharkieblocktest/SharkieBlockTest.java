package me.sharkie.minecraft.sharkieblocktest;

import me.sharkie.minecraft.sharkieblocktest.toolmaterial.AluminumToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class SharkieBlockTest implements ModInitializer {
    public static final String MODID = "sharkie-blocktest";

    public static final Block BAUXITE_BLOCK = new Block(FabricBlockSettings.create().strength(4.0f, 4.0f).requiresTool().mapColor(MapColor.DULL_RED));
    public static final Item BAUXITE_ITEM = new BlockItem(BAUXITE_BLOCK, new Item.Settings());
    public static final Identifier BAUXITE_ORE_IDENTIFIER = new Identifier(MODID, "bauxite_ore");

    public static final Item ALUMINUM_INGOT = new Item(new Item.Settings());
    public static final Identifier ALUMINUM_INGOT_IDENTIFIER = new Identifier(MODID, "aluminum_ingot");

    public static final Block ALUMINUM_BLOCK = new Block(FabricBlockSettings.create()
                                                                            .strength(5.0f, 6.0f)
                                                                            .requiresTool()
                                                                            .mapColor(MapColor.LIGHT_GRAY)
                                                                            .sounds(BlockSoundGroup.METAL));
    public static final Item ALUMINUM_BLOCK_ITEM = new BlockItem(ALUMINUM_BLOCK, new Item.Settings());
    public static final Identifier ALUMINUM_BLOCK_IDENTIFIER = new Identifier(MODID, "aluminum_block");

    public static final Item ALUMINUM_PICKAXE = new PickaxeItem(AluminumToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
    public static final Identifier ALUMINUM_PICKAXE_IDENTIFIER = new Identifier(MODID, "aluminum_pickaxe");

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, BAUXITE_ORE_IDENTIFIER, BAUXITE_BLOCK);
        Registry.register(Registries.ITEM, BAUXITE_ORE_IDENTIFIER, BAUXITE_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> content.addAfter(Items.DEEPSLATE_COPPER_ORE, BAUXITE_ITEM));

        Registry.register(Registries.ITEM, ALUMINUM_INGOT_IDENTIFIER, ALUMINUM_INGOT);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Items.COPPER_INGOT, ALUMINUM_INGOT));

        Registry.register(Registries.BLOCK, ALUMINUM_BLOCK_IDENTIFIER, ALUMINUM_BLOCK);
        Registry.register(Registries.ITEM, ALUMINUM_BLOCK_IDENTIFIER, ALUMINUM_BLOCK_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> content.addAfter(Items.COPPER_BLOCK, ALUMINUM_BLOCK_ITEM));

        Registry.register(Registries.ITEM, ALUMINUM_PICKAXE_IDENTIFIER, ALUMINUM_PICKAXE);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> content.addAfter(Items.IRON_PICKAXE, ALUMINUM_PICKAXE));

        RegistryKey<PlacedFeature> bauxite_ore_placed_key = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MODID, "ore_bauxite"));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, bauxite_ore_placed_key);
    }
}
