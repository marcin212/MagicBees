package magicbees.bees.allele.flowerProvider;

import java.util.EnumSet;

import magicbees.main.utils.LocalizationManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import forestry.api.genetics.IFlowerProvider;
import forestry.api.genetics.IIndividual;
import forestry.api.genetics.IPollinatable;

public class FlowerProviderBookshelf implements IFlowerProvider {

	public boolean isAcceptedFlower(World world, IIndividual genome, int x, int i, int j) {
		boolean flag = false;
		if (world.getBlock(x, i, j) == Blocks.bookshelf) {
			flag = true;
		}
		return flag;
	}

	public boolean growFlower(World world, IIndividual genome, int x, int i, int j) {
		// Always return true so the system thinks we grew a flower.
		// Bees can't grow bookshelves! Are you crazy?!
		return true;
	}

	public ItemStack[] affectProducts(World world, IIndividual genome, int x, int i, int j, ItemStack products[]) {
		return products;
	}

	public ItemStack[] getItemStacks() {
		return new ItemStack[] { new ItemStack(Blocks.bookshelf) };
	}

	@Override
	public boolean isAcceptedPollinatable(World world, IPollinatable pollinatable) {
		EnumSet<EnumPlantType> types = pollinatable.getPlantType();
		return types.size() > 0 && !types.contains(EnumPlantType.Nether) && !types.contains(EnumPlantType.Water);
	}

	public String getDescription() {
		return LocalizationManager.getLocalizedString("flowerProvider.book");
	}
}
