package md.faiks.korobka.osnova;

import md.faiks.korobka.Korobka;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;


import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

@Environment(EnvType.CLIENT)
public class korobka implements ClientTickEvents.StartTick {

    public float getSoundPitch() {
        return (new Random().nextFloat() - new Random().nextFloat()) * 0.2F + 1.5F;
    }
    public <T> void checkPlayer(T player, ClientPlayerEntity clientPlayer) {
        if (player instanceof OtherClientPlayerEntity otherClientPlayer) {

            if (Objects.equals(otherClientPlayer.getName().getString(), Korobka.getConfig().NICKNAME)) {
                MutableText result = Text.literal(String.valueOf(otherClientPlayer.getName().getString()))
                        .formatted(Formatting.RED, Formatting.BOLD, Formatting.UNDERLINE)
                        .append(Text.translatable("korobka.pizdec"));
                clientPlayer.sendMessage(result, true);
                if(Korobka.getConfig().enableSound && new Random().nextBoolean()){
                    clientPlayer.playSoundToPlayer(Korobka.soundaaaaaaa,SoundCategory.PLAYERS,0.2f,getSoundPitch());

                }
            }
        }
    }

    @Override
    public void onStartTick(MinecraftClient client) {
        if (Korobka.getConfig().enable) {
            if (client.player != null) {
                ClientPlayerEntity clientPlayer = client.player;
                if (client.world != null) {
                    ClientWorld world = client.world;
                    Iterator<Entity> listEntity = world.getEntities().iterator();
                    listEntity.forEachRemaining((player) -> checkPlayer(player, clientPlayer));
                }
            }
        }
    }
}