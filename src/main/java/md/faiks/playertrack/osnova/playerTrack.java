package md.faiks.playertrack.osnova;

import md.faiks.playertrack.PlayerTrack;
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
public class playerTrack implements ClientTickEvents.StartTick {

    public float getSoundPitch() {
        return (new Random().nextFloat() - new Random().nextFloat()) * 0.2F + 1.5F;
    }
    public <T> void checkPlayer(T player, ClientPlayerEntity clientPlayer) {
        if (player instanceof OtherClientPlayerEntity otherClientPlayer) {

            if (Objects.equals(otherClientPlayer.getName().getString(), PlayerTrack.getConfig().NICKNAME)) {
                MutableText result = Text.literal(String.valueOf(otherClientPlayer.getName().getString()))
                        .formatted(Formatting.RED, Formatting.BOLD, Formatting.UNDERLINE)
                        .append(Text.translatable("playertrack.osnova"));
                clientPlayer.sendMessage(result, true);
                if(PlayerTrack.getConfig().enableSound && new Random().nextBoolean()){
                    clientPlayer.playSoundToPlayer(PlayerTrack.soundaaaaaaa,SoundCategory.PLAYERS,0.2f,getSoundPitch());

                }
            }
        }
    }

    @Override
    public void onStartTick(MinecraftClient client) {
        if (PlayerTrack.getConfig().enable) {
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