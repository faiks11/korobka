package md.faiks.korobka;

import md.faiks.korobka.CONFIG.config;
import md.faiks.korobka.osnova.korobka;
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


public class Korobka implements ClientModInitializer {

    public static final String MODID = "korobka";
    public static Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static config getConfig() {
        return AutoConfig.getConfigHolder(config.class).getConfig();
    }

    public static SoundEvent soundaaaaaaa = Registry.register(Registries.SOUND_EVENT,Identifier.of(MODID, "soundaaaaaaa"),
                SoundEvent.of(Identifier.of(MODID, "soundaaaaaaa")));


    @Override
    public void onInitializeClient() {
        AutoConfig.register(config.class, Toml4jConfigSerializer::new);

        ClientTickEvents.START_CLIENT_TICK.register(new korobka());

    }
}
