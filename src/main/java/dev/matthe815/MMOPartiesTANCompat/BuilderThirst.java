package dev.matthe815.MMOPartiesTANCompat;

import deathtags.gui.PartyList;
import deathtags.gui.UISpec;
import deathtags.networking.BuilderData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import toughasnails.api.thirst.ThirstHelper;

public class BuilderThirst implements BuilderData {
    int thirst = 10;

    public static ResourceLocation TAN_ICONS = new ResourceLocation("toughasnails", "textures/gui/icons.png");

    @Override
    public void OnWrite(PacketBuffer packetBuffer, PlayerEntity playerEntity) {
        packetBuffer.writeInt(ThirstHelper.getThirst(playerEntity).getThirst());
    }

    @Override
    public void OnRead(PacketBuffer packetBuffer) {
        thirst = packetBuffer.readInt();
    }

    @Override
    public boolean IsDifferent(PlayerEntity playerEntity) {
        return ThirstHelper.getThirst(playerEntity).getThirst() != thirst;
    }

    public static class Renderer implements PartyList.NuggetBar {

        @Override
        public int Render(BuilderData builderData, int offsetX, int offsetY, boolean render) {
            BuilderThirst data = (BuilderThirst) builderData;
            return PartyList.DrawNuggetBar(data.thirst, 20, new UISpec(TAN_ICONS, offsetX, offsetY, 36, 0, 9, 9), 0, 9);
        }
    }
}
