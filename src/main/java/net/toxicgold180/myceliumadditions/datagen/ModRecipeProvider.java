package net.toxicgold180.myceliumadditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.toxicgold180.myceliumadditions.block.ModBlocks;
import net.toxicgold180.myceliumadditions.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(
            ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE,
            ModBlocks.DEEPSLATE_RUBY_ORE,
            ModBlocks.NETHER_RUBY_ORE,
            ModBlocks.END_STONE_RUBY_ORE
            );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerSmelting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "ruby");

        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK, 1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('C', ModItems.RUBY)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.SOUND_BLOCK)));
    }
}
