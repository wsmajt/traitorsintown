package me.smajt.traitorsintown;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameEnums {

    public enum Roles{
        INNOCENT,
        SHERIFF,
        TRAITOR,
        POISONER
    }

    public enum InnocentRoles{
        INNOCENT,
        SHERIFF
    }

    public enum TraitorRoles{
        TRAITOR,
        POISONER
    }

    private static final SecureRandom random = new SecureRandom();

    public static Roles RandomInnocentRole(){
        InnocentRoles role = InnocentRoles.values()[random.nextInt(InnocentRoles.values().length)];
        return  InnocentRolesToRoles(role);
    }

    public static Roles RandomTraitorRole(){
        TraitorRoles role = TraitorRoles.values()[random.nextInt(TraitorRoles.values().length)];
        return  TraitorRolesToRoles(role);
    }

    private static Roles InnocentRolesToRoles(InnocentRoles role){
        return switch (role) {
            case INNOCENT -> Roles.INNOCENT;
            case SHERIFF -> Roles.SHERIFF;
        };
    }

    private static Roles TraitorRolesToRoles(TraitorRoles role){
        return switch (role) {
            case TRAITOR -> Roles.TRAITOR;
            case POISONER -> Roles.POISONER;
        };
    }

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
