package dev.matthe815.MMOPartiesTANCompat;

import deathtags.core.MMOParties;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mmopartiestancompat")
public class MMOPartiesTANCompat
{
    public MMOPartiesTANCompat() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        MMOParties.RegisterCompatibility(new BuilderThirst(), new BuilderThirst.Renderer());
    }

}
