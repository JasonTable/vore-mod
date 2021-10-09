
package net.jasontable.vore_mod.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.jasontable.vore_mod.VoreModMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BOGUIGuiWindow extends ContainerScreen<BOGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = BOGUIGui.guistate;
	TextFieldWidget bellyname;
	TextFieldWidget exitCMD;
	public BOGUIGuiWindow(BOGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 246;
		this.ySize = 110;
	}
	private static final ResourceLocation texture = new ResourceLocation("vore_mod:textures/bogui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		bellyname.render(ms, mouseX, mouseY, partialTicks);
		exitCMD.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (bellyname.isFocused())
			return bellyname.keyPressed(key, b, c);
		if (exitCMD.isFocused())
			return exitCMD.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		bellyname.tick();
		exitCMD.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Belly Data", 5, 6, -16777216);
		this.font.drawString(ms, "Belly name: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "bellyname")) + "", 5, 17, -16777216);
		this.font.drawString(ms, "Belly exit command: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "exitCMD")) + "", 5, 50, -16777216);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		bellyname = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 28, 234, 20, new StringTextComponent("Belly name")) {
			{
				setSuggestion("Belly name");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Belly name");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Belly name");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:bellyname", bellyname);
		bellyname.setMaxStringLength(32767);
		this.children.add(this.bellyname);
		exitCMD = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 61, 234, 20, new StringTextComponent("Exit Command")) {
			{
				setSuggestion("Exit Command");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Exit Command");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Exit Command");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:exitCMD", exitCMD);
		exitCMD.setMaxStringLength(32767);
		this.children.add(this.exitCMD);
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 83, 81, 20, new StringTextComponent("Change values"), e -> {
			if (true) {
				VoreModMod.PACKET_HANDLER.sendToServer(new BOGUIGui.ButtonPressedMessage(0, x, y, z));
				BOGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
