/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author David
 */
public class User implements Serializable{
    //Creation Fields
    private String name;
    private String email;
    private String password;
    private int gender;
    private final String dob;
    
    private HashMap<String, User> friends;
    private HashMap<String, User> friend_request;
    
    private HashMap<String, User> blocked;
    
    public User(String name, String email, String password, int gender, String dob){
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        
        friends = new HashMap<>();
        friend_request = new HashMap<>();
        blocked = new HashMap<>();
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String newEmail){
        email = newEmail;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String newPassword){
        password = newPassword;
    }
    
    public int getGender(){
        return gender;
    }
    
    public void setGender(int newGender){
        gender = newGender;
    }
    
    public void addFriend(User newFriend){
        friends.putIfAbsent(newFriend.getEmail(), newFriend);
    }
    
    public void removeFriend(User friendToRemove){
        if(isFriend(friendToRemove)){
            friends.remove(friendToRemove.getEmail());
        }
    }
    
    public boolean isFriend(User friend){
        return friends.containsKey(friend.getEmail());
    } 
}
