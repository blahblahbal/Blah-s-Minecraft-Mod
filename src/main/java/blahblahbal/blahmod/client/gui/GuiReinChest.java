package blahblahbal.blahmod.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import blahblahbal.blahmod.guicontainer.ContainerCatalyzer;
import blahblahbal.blahmod.guicontainer.ContainerReinforcedChest;

public class GuiReinChest extends GuiContainer
{
	private IInventory playerInv;
	private IInventory chestInv;
	private EntityPlayer play;
	
    public GuiReinChest(IInventory playerInv, IInventory chestInv, EntityPlayer player)
    {
        super(new ContainerReinforcedChest(playerInv, chestInv, player));
        this.playerInv = playerInv;
        this.chestInv = chestInv;
        this.play = player;
        
        xSize = 248;
        ySize = 222;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/gui/generic_78.png"));
        drawTexturedModalRect(guiLeft - 36, guiTop, 0, 0, xSize, ySize);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = "Reinforced Chest";
        fontRendererObj.drawString(s, 88 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //#404040
        fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      //#404040
    }
}