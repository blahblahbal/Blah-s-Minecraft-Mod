package blahblahbal.blahmod.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import blahblahbal.blahmod.guicontainer.ContainerCatalyzer;

public class GuiCatalyzer extends GuiContainer
{
	private IInventory playerInv;
	private World world;
	private BlockPos bp;
	
    public GuiCatalyzer(IInventory playerInv, World w, BlockPos p)
    {
        super(new ContainerCatalyzer((InventoryPlayer)playerInv, w, p));
        this.playerInv = playerInv;
        this.world = w;
        this.bp = p;
        
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/gui/inventoryCatalyst.png"));
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = "Catalyzer";
        fontRendererObj.drawString(s, 88 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //#404040
        fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      //#404040
    }
}