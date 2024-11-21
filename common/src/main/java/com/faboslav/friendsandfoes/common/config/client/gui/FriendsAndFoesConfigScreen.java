package com.faboslav.friendsandfoes.common.config.client.gui;

import com.faboslav.friendsandfoes.common.FriendsAndFoes;
import com.faboslav.friendsandfoes.common.config.FriendsAndFoesConfig;
import com.faboslav.friendsandfoes.common.config.client.gui.widget.DynamicGridWidget;
import com.faboslav.friendsandfoes.common.config.client.gui.widget.ImageButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;

public class FriendsAndFoesConfigScreen extends Screen
{
	private final Screen parent;
	private Screen mainConfigScreen = FriendsAndFoesConfig.HANDLER.generateGui().generateScreen(null);
	@Nullable
	private Screen structureSetsScreen = null;

	public FriendsAndFoesConfigScreen(@Nullable Screen parent) {
		super(Text.translatable("friendsandfoes"));
		this.parent = parent;
	}

	@Override
	public void close() {
		assert this.client != null;
		this.client.setScreen(this.parent);
	}

	@Override
	public void render(DrawContext context, int mouseX, int mouseY, float delta) {
		/*? if <1.20.2 {*/
		/*super.renderBackground(context);
		*//*?} else {*/
		super.renderBackground(context, mouseX, mouseY, delta);
		 /*?}*/
		super.render(context, mouseX, mouseY, delta);

		assert this.client != null;
		context.drawCenteredTextWithShadow(this.textRenderer, Text.translatable("yacl3.config.friendsandfoes:friendsandfoes"), this.width / 2, 10, 0xFFFFFF);
	}

	@Override
	protected void init() {
		super.init();

		int fontHeight = this.textRenderer.fontHeight;
		DynamicGridWidget grid = new DynamicGridWidget(10, 10 + fontHeight + 10, width - 13, height - 20 - fontHeight - 10 - 20);

		grid.setPadding(3);

		grid.addChild(new ImageButtonWidget(0, 0, 0, 0, Text.translatable("yacl3.config.friendsandfoes:friendsandfoes.category.mobs"), FriendsAndFoes.makeID("textures/gui/config/images/buttons/mobs.webp"), btn -> {
			this.client.setScreen(this.mainConfigScreen);
		}), 2, 1);

		grid.addChild(new ImageButtonWidget(0, 0, 0, 0, Text.translatable("yacl3.config.friendsandfoes:friendsandfoes.category.general"), FriendsAndFoes.makeID("textures/gui/config/images/buttons/general.webp"), btn -> {
			this.client.setScreen(this.mainConfigScreen);
		}), 2, 1);

		grid.calculateLayout();
		grid.forEachChild(this::addDrawableChild);

		int discordAndKoFiButtonsWidth = 100 + 100 + 30; // button widths + left margin of Ko-Fi button + right margin of Discord button
		int doneButtonWidth = this.width - discordAndKoFiButtonsWidth;
		var buttonWidget = ButtonWidget.builder(ScreenTexts.DONE, (btn) -> this.client.setScreen(this.parent)).dimensions(this.width / 2 - doneButtonWidth / 2, this.height - 30, doneButtonWidth, 20).build();
		var donateButton = ButtonWidget.builder(Text.literal("Donate").formatted(Formatting.GOLD).formatted(Formatting.BOLD), (btn) -> Util.getOperatingSystem().open("https://ko-fi.com/faboslav")).dimensions(10, this.height - 30, 100, 20).build();
		var discordButton = ButtonWidget.builder(Text.literal("Discord").formatted(Formatting.AQUA).formatted(Formatting.BOLD), (btn) -> Util.getOperatingSystem().open("https://discord.gg/QGwFvvMQCn")).dimensions(this.width - 110, this.height - 30, 100, 20).build();

		this.addDrawableChild(buttonWidget);
		this.addDrawableChild(donateButton);
		this.addDrawableChild(discordButton);
	}
}