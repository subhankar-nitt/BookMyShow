package org.example.Service;

import org.example.Entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    public static Map<Long, User> userMap = new HashMap<>();

    public static void createUser(String userName,String password,String phNo,String email,String addr){
        User user = new User(userName,password,phNo,email,addr);
        long key = user.getId();
        userMap.put(key,user);
    }
    public static User searchUserById(Long uId){
        User user=null ;
        if(userMap.containsKey(uId)){
            user = userMap.get(uId);
        }
        return  user;
    }
}
