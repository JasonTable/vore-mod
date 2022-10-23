
package net.jasontable.vore_mod.client.gui;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.jasontable.vore_mod.world.inventory.BOGUIMenu;
import net.jasontable.vore_mod.network.BOGUIButtonMessage;
import net.jasontable.vore_mod.VoreModMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BOGUIScreen extends AbstractContainerScreen<BOGUIMenu> {
	private final static HashMap<String, Object> guistate = BOGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox bellyname;
	EditBox exitCMD;

	public BOGUIScreen(BOGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 246;
		this.imageHeight = 110;
	}

	private static final ResourceLocation texture = new ResourceLocation("vore_mod:textures/screens/bogui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		bellyname.render(ms, mouseX, mouseY, partialTicks);
		exitCMD.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (bellyname.isFocused())
			return bellyname.keyPressed(key, b, c);
		if (exitCMD.isFocused())
			return exitCMD.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		bellyname.tick();
		exitCMD.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Belly Data", 5, 6, -16777216);
		this.font.draw(poseStack, "Belly name: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "bellyname")) + "", 5, 17, -16777216);
		this.font.draw(poseStack, "Belly exit command: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "exitCMD")) + "", 5, 50, -16777216);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		bellyname = new EditBox(this.font, this.leftPos + 5, this.topPos + 28, 234, 20, new TextComponent("Belly name")) {
			{
				setSuggestion("Belly name");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Belly name");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Belly name");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:bellyname", bellyname);
		bellyname.setMaxLength(32767);
		this.addWidget(this.bellyname);
		exitCMD = new EditBox(this.font, this.leftPos + 5, this.topPos + 61, 234, 20, new TextComponent("Exit Command")) {
			{
				setSuggestion("Exit Command");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Exit Command");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Exit Command");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:exitCMD", exitCMD);
		exitCMD.setMaxLength(32767);
		this.addWidget(this.exitCMD);
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 83, 81, 20, new TextComponent("Change values"), e -> {
			if (true) {
				VoreModMod.PACKET_HANDLER.sendToServer(new BOGUIButtonMessage(0, x, y, z));
				BOGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
