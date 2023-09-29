package io.github.The_Brickler.smores;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Smores implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("SMOres");

	public static final Item EXAMPLE_ITEM = new Item(new QuiltItemSettings());
	public static final Item ILLUMINUM_INGOT = new Item(new QuiltItemSettings());

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

		registerItems(mod);
		defineItemGroups();

	}

	private void registerItems(ModContainer mod)
	{
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "example_item"), EXAMPLE_ITEM);

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "illuminum_ingot"), ILLUMINUM_INGOT);
	}

	private void defineItemGroups()
	{
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries-> {
			entries.addItem(EXAMPLE_ITEM);
			entries.addItem(ILLUMINUM_INGOT);
		});
	}
}
