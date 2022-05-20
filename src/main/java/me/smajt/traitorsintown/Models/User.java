package me.smajt.traitorsintown.Models;

import me.smajt.traitorsintown.GameEnums;

import java.util.UUID;

public class User {
    private UUID uuid;
    private String playerName;
    private GameEnums.Roles playerClass;
    private boolean isTraitor;

    public User(UUID uuid, String playerName, GameEnums.Roles playerClass, boolean isTraitor) {
        this.uuid = uuid;
        this.playerName = playerName;
        this.playerClass = playerClass;
        this.isTraitor = isTraitor;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameEnums.Roles getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(GameEnums.Roles playerClass) {
        this.playerClass = playerClass;
    }

    public boolean isTraitor() {
        return isTraitor;
    }

    public void setTraitor(boolean traitor) {
        isTraitor = traitor;
    }
}
