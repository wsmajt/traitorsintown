package me.smajt.traitorsintown.Storages;

import me.smajt.traitorsintown.GameEnums;
import me.smajt.traitorsintown.Models.User;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class UserStorage {
    private static final ArrayList<User> Users = new ArrayList<>();

    public static User createUser(Player p, GameEnums.Roles playerClass, boolean isTraitor){
        User user = new User(p.getUniqueId(), p.displayName().toString(), playerClass, isTraitor);
        Users.add(user);

        return user;
    }

    public static User findUser(UUID uuid){
        for (User user : Users){
            if (user.getUuid().equals(uuid)) {
                return user;
            }
        }
        return null;
    }

    public static void deleteUser(UUID uuid){
        for (User user : Users){
            if (user.getUuid().equals(uuid)) {
                Users.remove(user);
                break;
            }
        }
    }

    public static void clearUsers(){
        Users.clear();
    }
}
