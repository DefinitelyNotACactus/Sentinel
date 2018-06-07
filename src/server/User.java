/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    
    private List<User> friends;
    private List<User> friend_request; 
    private List<User> blocked;
    
    private List<Post> posts;
    
    public User(String name, String email, String password, int gender, String dob){
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        
        friends = new ArrayList<>();
        friend_request = new ArrayList<>();
        blocked = new ArrayList<>();
        
        posts = new ArrayList<>();
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
        if(!isFriend(newFriend)){
            friends.add(newFriend);
            newFriend.addFriend(this);
        }
        removeFriendRequest(newFriend);
    }
    
    public void removeFriend(User friendToRemove){
        Iterator<User> it = friends.iterator();
        while(it.hasNext()){
            if(friendToRemove.getEmail().equals(it.next().getEmail())){
                it.remove();
                friendToRemove.removeFriend(this);
                break;
            }
        }
    }
    
    public boolean isFriend(User friend){
        Iterator<User> it = friends.iterator();
        while(it.hasNext()){
            if(friend.getEmail().equals(it.next().getEmail())){
                return true;
            }
        }
        return false;
    }
    
    public List<User> getFriends(){
        return friends;
    }
    
    public void newFriendRequest(User requester){
        if(!isRequestSent(requester)){
            friend_request.add(requester);
        }
    }
    
    public List<User> getFriendRequests(){
        return friend_request;
    }
    
    public void removeFriendRequest(User toRemove){
        Iterator<User> it = friend_request.iterator();
        while(it.hasNext()){
            if(toRemove.getEmail().equals(it.next().getEmail())){
                it.remove();
                break;
            }
        }
    }
    
    public boolean isRequestSent(User requester){
        Iterator<User> it = friend_request.iterator();
        while(it.hasNext()){
            if(requester.getEmail().equals(it.next().getEmail())){
                return true;
            }
        }
        return false;
    }
    
    public List<User> getBlocked(){
        return blocked;
    }
    
    public boolean isBlocked(User toSearch){
        Iterator<User> it = blocked.iterator();
        while(it.hasNext()){
            if(toSearch.getEmail().equals(it.next().getEmail())){
                return true;
            }
        }
        return false;
    }
    
    public void block(User victim){
        if(!isBlocked(victim)){
            blocked.add(victim);
            removeFriend(victim);
            victim.removeFriend(this);
            removeFriendRequest(victim);
        }
    }
    
    public void unblock (User toUnblock){
        Iterator<User> it = blocked.iterator();
        while(it.hasNext()){
            if(toUnblock.getEmail().equals(it.next().getEmail())){
                it.remove();
                break;
            }
        }
    }
    
    public void addPost(Post newPost){
        posts.add(newPost);
    }
    
    public void removePost(int index){
        posts.remove(index);
    }
    
    public List<Post> getPosts(){
        return posts;
    }
    
    public Post getPost(int index){
        return posts.get(index);
    }
    
    @Override
    public String toString(){
        return name;
    }
}
