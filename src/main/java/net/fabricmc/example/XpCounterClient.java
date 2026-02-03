package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class XpCounterClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null) {
                TextRenderer renderer = client.textRenderer;
                String xpText = "XP: " + client.player.experienceLevel;
                renderer.draw(matrixStack, xpText, 10, 10, 0xFFFFFF);
            }
        });
    }
}
