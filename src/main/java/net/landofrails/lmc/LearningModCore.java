public class ImmersiveRailroading extends ModCore.Mod {
	public static final String MODID = "immersiverailroading";
	public static final String NAME = "ImmersiveRailroading";
	public static final String VERSION = "1.6.1";

	public static final int ENTITY_SYNC_DISTANCE = 512;
	private static ImmersiveRailroading instance;

	public static GuiRegistry GUI_REGISTRY = new GuiRegistry(ImmersiveRailroading.instance);

	public ImmersiveRailroading() {
		instance = this;
	}

	@Override
	public String modID() {
		return MODID;
	}

	@Override
	public void commonEvent(ModEvent event) {
		switch (event) {
			case CONSTRUCT:
				EntityRegistry.register(ImmersiveRailroading.instance, CarFreight::new, EntityRollingStock.settings, ImmersiveRailroading.ENTITY_SYNC_DISTANCE);
				EntityRegistry.register(ImmersiveRailroading.instance, CarPassenger::new, EntityRollingStock.settings, ImmersiveRailroading.ENTITY_SYNC_DISTANCE);
				EntityRegistry.register(ImmersiveRailroading.instance, CarTank::new, EntityRollingStock.settings, ImmersiveRailroading.ENTITY_SYNC_DISTANCE);
				EntityRegistry.register(ImmersiveRailroading.instance, HandCar::new, EntityRollingStock.settings, ImmersiveRailroading.ENTITY_SYNC_DISTANCE);
				EntityRegistry.register(ImmersiveRailroading.instance, LocomotiveDiesel::new, EntityRollingStock.settings, ImmersiveRailroading.ENTITY_SYNC_DISTANCE);
				EntityRegistry.register(ImmersiveRailroading.instance, LocomotiveSteam::new, EntityRollingStock.settings, ImmersiveRailroading.ENTITY_SYNC_DISTANCE);
				EntityRegistry.register(ImmersiveRailroading.instance, Tender::new, EntityRollingStock.settings, ImmersiveRailroading.ENTITY_SYNC_DISTANCE);

				MultiblockRegistry.register(SteamHammerMultiblock.NAME, new SteamHammerMultiblock());
				MultiblockRegistry.register(PlateRollerMultiblock.NAME, new PlateRollerMultiblock());
				MultiblockRegistry.register(RailRollerMultiblock.NAME, new RailRollerMultiblock());
				MultiblockRegistry.register(BoilerRollerMultiblock.NAME, new BoilerRollerMultiblock());
				MultiblockRegistry.register(CastingMultiblock.NAME, new CastingMultiblock());

				Packet.register(BuildableStockSyncPacket::new, PacketDirection.ServerToClient);
				Packet.register(ItemRailUpdatePacket::new, PacketDirection.ClientToServer);
				Packet.register(MRSSyncPacket::new, PacketDirection.ServerToClient);
				Packet.register(MultiblockSelectCraftPacket::new, PacketDirection.ClientToServer);
				Packet.register(PreviewRenderPacket::new, PacketDirection.ServerToClient);
				Packet.register(SoundPacket::new, PacketDirection.ServerToClient);
				Packet.register(KeyPressPacket::new, PacketDirection.ClientToServer);
				Packet.register(ItemTrackExchangerUpdatePacket::new, PacketDirection.ClientToServer);
				IRBlocks.register();
				IRItems.register();

				Command.register(new IRCommand());
				break;
			case INITIALIZE:
				Config.init();
				ConfigFile.sync(Config.class, getConfig("immersiverailroading.cfg"));
				ConfigFile.sync(ConfigGraphics.class, getConfig("immersiverailroading_graphics.cfg"));
				ConfigFile.sync(ConfigSound.class, getConfig("immersiverailroading_sound.cfg"));

				try {
					DefinitionManager.initDefinitions();
				} catch (IOException e) {
					throw new RuntimeException("Unable to load IR definitions", e);
				}

				CompatLoader.init();
				break;
			case FINALIZE:
				CompatLoader.setup();
				IRFuzzy.applyFallbacks();
				break;
		}
	}

	@Override
	public void clientEvent(ModEvent event) {
		switch (event) {
			case CONSTRUCT:
				BlockRender.register(IRBlocks.BLOCK_RAIL, RailBaseModel::getModel, TileRail.class);
				BlockRender.register(IRBlocks.BLOCK_RAIL_GAG, RailBaseModel::getModel, TileRailGag.class);
				BlockRender.register(IRBlocks.BLOCK_RAIL_PREVIEW, RailPreviewRender::render, TileRailPreview.class);
				BlockRender.register(IRBlocks.BLOCK_MULTIBLOCK, TileMultiblockRender::render, TileMultiblock.class);

				ItemRender.register(IRItems.ITEM_PLATE, new PlateItemModel());
				ItemRender.register(IRItems.ITEM_AUGMENT, new RailAugmentItemModel());
				ItemRender.register(IRItems.ITEM_RAIL, new RailItemRender());
				ItemRender.register(IRItems.ITEM_CAST_RAIL, new RailCastItemRender());
				ItemRender.register(IRItems.ITEM_TRACK_BLUEPRINT, new TrackBlueprintItemModel());
				ItemRender.register(IRItems.ITEM_ROLLING_STOCK_COMPONENT, new StockItemComponentModel());
				ItemRender.register(IRItems.ITEM_ROLLING_STOCK, new StockItemModel());
				ItemRender.register(IRItems.ITEM_LARGE_WRENCH, ObjItemRender.getModelFor(new Identifier(MODID, "models/item/wrench/wrench.obj"), new Vec3d(0.5, 0, 0.5), 2));
				ItemRender.register(IRItems.ITEM_CONDUCTOR_WHISTLE, ObjItemRender.getModelFor(new Identifier(MODID, "models/item/whistle.obj"), new Vec3d(0.5, 0.75, 0.5), 0.1f));
				ItemRender.register(IRItems.ITEM_GOLDEN_SPIKE, ObjItemRender.getModelFor(new Identifier(MODID, "models/item/goldenspike/goldenspike.obj"), new Vec3d(0.5, 0.5, 0.5), 0.1f));
				ItemRender.register(IRItems.ITEM_HOOK, ObjItemRender.getModelFor(new Identifier(MODID, "models/item/brake_stick.obj"), new Vec3d(0.5, 0, 0.5), 2));
				ItemRender.register(IRItems.ITEM_SWITCH_KEY, ObjItemRender.getModelFor(new Identifier(MODID, "models/item/switch_key/switch_key.obj"), new Vec3d(0.5, 0, 0.5), 1));
				ItemRender.register(IRItems.ITEM_PAINT_BRUSH, ObjItemRender.getModelFor(new Identifier(MODID, "models/item/paint_brush.obj"), new Vec3d(0.5, 0.25, 0.5), 3));
				ItemRender.register(IRItems.ITEM_RADIO_CONTROL_CARD, new Identifier(MODID, "items/radio_card"));
				ItemRender.register(IRItems.ITEM_MANUAL, new Identifier(MODID, "items/engineerslexicon"));
				ItemRender.register(IRItems.ITEM_TRACK_EXCHANGER, new TrackExchangerModel());

				IEntityRender<EntityRollingStock> stockRender = (entity, partialTicks) -> {
					GLBoolTracker light = new GLBoolTracker(GL11.GL_LIGHTING, true);
					GLBoolTracker cull = new GLBoolTracker(GL11.GL_CULL_FACE, false);

					String def = entity.getDefinitionID();

					StockRenderCache.getRender(def).draw(entity, partialTicks);

					cull.restore();
					light.restore();
				};
				EntityRenderer.register(LocomotiveSteam.class, stockRender);
				EntityRenderer.register(LocomotiveDiesel.class, stockRender);
				EntityRenderer.register(CarPassenger.class, stockRender);
				EntityRenderer.register(CarFreight.class, stockRender);
				EntityRenderer.register(CarTank.class, stockRender);
				EntityRenderer.register(Tender.class, stockRender);
				EntityRenderer.register(HandCar.class, stockRender);


				Function<KeyTypes, Runnable> onKeyPress = type -> () -> new KeyPressPacket(type).sendToServer();
				Keyboard.registerKey("ir_keys.increase_throttle", KeyCode.NUMPAD8, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.THROTTLE_UP));
				Keyboard.registerKey("ir_keys.zero_throttle", KeyCode.NUMPAD5, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.THROTTLE_ZERO));
				Keyboard.registerKey("ir_keys.decrease_throttle", KeyCode.NUMPAD2, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.THROTTLE_DOWN));
				Keyboard.registerKey("ir_keys.increase_brake", KeyCode.NUMPAD7, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.AIR_BRAKE_UP));
				Keyboard.registerKey("ir_keys.zero_brake", KeyCode.NUMPAD4, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.AIR_BRAKE_ZERO));
				Keyboard.registerKey("ir_keys.decrease_brake", KeyCode.NUMPAD1, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.AIR_BRAKE_DOWN));
				Keyboard.registerKey("ir_keys.horn", KeyCode.NUMPADENTER, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.HORN));
				Keyboard.registerKey("ir_keys.dead_mans_switch", KeyCode.NUMPADEQUALS, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.DEAD_MANS_SWITCH));
				Keyboard.registerKey("ir_keys.start_stop_engine", KeyCode.ADD, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.START_STOP_ENGINE));
				Keyboard.registerKey("ir_keys.bell", KeyCode.SUBTRACT, "key.categories." + ImmersiveRailroading.MODID, onKeyPress.apply(KeyTypes.BELL));
				break;
			case SETUP:
				if (ConfigSound.overrideSoundChannels) {
					Audio.setSoundChannels(300);
				}

				GlobalRender.registerItemMouseover(IRItems.ITEM_TRACK_BLUEPRINT, TrackBlueprintItemModel::renderMouseover);
				GlobalRender.registerItemMouseover(IRItems.ITEM_MANUAL, MBBlueprintRender::renderMouseover);

				GlobalRender.registerOverlay(pt -> {
					new SteamLocomotiveOverlay().draw();
					new DieselLocomotiveOverlay().draw();
					new HandCarOverlay().draw();
				});

				Particles.SMOKE = IParticle.register(SmokeParticle::new, SmokeParticle::renderAll);
				break;
			case RELOAD:
				try {
					DefinitionManager.initDefinitions();
				} catch (IOException e) {
					throw new RuntimeException("Unable to load IR definitions", e);
				}

				StockRenderCache.clearRenderCache();
				break;
		}
	}

	@Override
	public void serverEvent(ModEvent event) {
		switch (event) {
			case SETUP:
				for (EntityRollingStockDefinition def : DefinitionManager.getDefinitions()) {
					def.clearModel();
				}
				break;
		}
	}

	public static ISound newSound(Identifier oggLocation, boolean repeats, float attenuationDistance, Gauge gauge) {
		return Audio.newSound(oggLocation, repeats, (float) (attenuationDistance * gauge.scale() * ConfigSound.soundDistanceScale), (float)Math.sqrt(Math.sqrt(gauge.scale())));
	}
}