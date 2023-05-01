package com.example.fxgl;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;


public class PlatformsGame extends GameApplication {

    private Entity platformPlayer;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setTitle("Simple Platformer Game");
        gameSettings.setWidth(800);
        gameSettings.setHeight(600);
    }

    @Override
    protected void initGame() {
        PlatformsFactory.createGround();
        platformPlayer = PlatformPlayer.createPlayer();
        FXGL.getGameWorld().addEntity(platformPlayer);
        PlatformsFactory.initPlatformWithPerlinNoiseFun();

        // Agrega los componentes de entrada y lógica del jugador

        platformPlayer.addComponent(new PlayerInput(platformPlayer));
        platformPlayer.addComponent(new PlayerPhysics());
    }

    public static void main(String[] args) {
        launch(args);
    }
}