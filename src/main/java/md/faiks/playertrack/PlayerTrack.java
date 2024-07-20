package md.faiks.playertrack;

import md.faiks.playertrack.CONFIG.config;
import md.faiks.playertrack.osnova.playerTrack;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PlayerTrack implements ClientModInitializer {

    public static final String MODID = "playertrack";
    public static Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static config getConfig() {
        return AutoConfig.getConfigHolder(config.class).getConfig();
    }

    public static SoundEvent soundaaaaaaa = Registry.register(Registries.SOUND_EVENT,Identifier.of(MODID, "soundplayertrack"),
                SoundEvent.of(Identifier.of(MODID, "soundplayertrack")));


    @Override
    public void onInitializeClient() {
        AutoConfig.register(config.class, Toml4jConfigSerializer::new);

        ClientTickEvents.START_CLIENT_TICK.register(new playerTrack());

    }
}
