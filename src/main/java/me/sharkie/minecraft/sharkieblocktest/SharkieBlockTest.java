package me.sharkie.minecraft.sharkieblocktest;

import me.sharkie.minecraft.sharkieblocktest.toolmaterial.AluminumToolMaterial;
import net.fabricmc.api.ModInitializer;
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
import net.minecraft.util.Identifier;

public class SharkieBlockTest implements ModInitializer {

    public static final Block BAUXITE_BLOCK = new Block(FabricBlockSettings.create().strength(4.0f, 4.0f).requiresTool().mapColor(MapColor.DULL_RED));
    public static final Item BAUXITE_ITEM = new BlockItem(BAUXITE_BLOCK, new Item.Settings());
    public static final String MODID = "sharkie-blocktest";
    public static final Identifier BAUXITE_ORE_IDENTIFIER = new Identifier(MODID, "bauxite_ore");

    public static final Item ALUMINUM_INGOT = new Item(new Item.Settings());
    public static final Identifier ALUMINUM_INGOT_IDENTIFIER = new Identifier(MODID, "aluminum_ingot");

    public static final Item ALUMINUM_PICKAXE = new PickaxeItem(AluminumToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
    public static final Identifier ALUMINUM_PICKAXE_IDENTIFIER = new Identifier(MODID, "aluminum_pickaxe");

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, BAUXITE_ORE_IDENTIFIER, BAUXITE_BLOCK);
        Registry.register(Registries.ITEM, BAUXITE_ORE_IDENTIFIER, BAUXITE_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> content.addAfter(Items.DEEPSLATE_COPPER_ORE, BAUXITE_ITEM));

        Registry.register(Registries.ITEM, ALUMINUM_INGOT_IDENTIFIER, ALUMINUM_INGOT);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Items.COPPER_INGOT, ALUMINUM_INGOT));

        Registry.register(Registries.ITEM, ALUMINUM_PICKAXE_IDENTIFIER, ALUMINUM_PICKAXE);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> content.addAfter(Items.IRON_PICKAXE, ALUMINUM_PICKAXE));
    }
}
