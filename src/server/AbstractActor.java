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
public abstract class AbstractActor implements Serializable{
    private String name;
    private String id;

    private List<User> friends;//i'll leave friends for now, assuming that a member of a group is also a friend of that group.
    private List<User> request; 
    private List<User> blocked;
    
    private List<Post> posts;
    
    public AbstractActor(String name, String id){
        this.name = name;
        this.id = id;
        
        
        friends = new ArrayList<>();
        request = new ArrayList<>();
        blocked = new ArrayList<>();
        
        posts = new ArrayList<>();
    }
    
        public String getName(){
        return name;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String newId){
        id = newId;
    }
    
    public void addFriend(User newFriend){
        if(!isFriend(newFriend)){
            friends.add(newFriend);
            Object ob = this;
            if(ob instanceof User){
                newFriend.addFriend((User) ob);
            }
        }
        removeFriendRequest(newFriend);
    }
    
    public void removeFriend(User friendToRemove){
        Iterator<User> it = friends.iterator();
        while(it.hasNext()){
            if(friendToRemove.getId().equals(it.next().getId())){
                it.remove();
                Object ob = this;
                if(ob instanceof User){
                    friendToRemove.removeFriend((User) ob);
                }
                break;
            }
        }
    }
    
    public boolean isFriend(User friend){
        Iterator<User> it = friends.iterator();
        while(it.hasNext()){
            if(friend.getId().equals(it.next().getId())){
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
            request.add(requester);
        }
    }
    
    public List<User> getFriendRequests(){
        return request;
    }
    
    public void removeFriendRequest(User toRemove){
        Iterator<User> it = request.iterator();
        while(it.hasNext()){
            if(toRemove.getId().equals(it.next().getId())){
                it.remove();
                break;
            }
        }
    }
    
    public boolean isRequestSent(User requester){
        Iterator<User> it = request.iterator();
        while(it.hasNext()){
            if(requester.getId().equals(it.next().getId())){
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
            if(toSearch.getId().equals(it.next().getId())){
                return true;
            }
        }
        return false;
    }
    
    public void block(User victim){
        if(!isBlocked(victim)){
            getBlocked().add(victim);
            removeFriend(victim);
            Object ob = this;
            if(ob instanceof User){
                victim.removeFriend((User) ob);
            }
            removeFriendRequest(victim);
        }
    }
    
    public void unblock (User toUnblock){
        Iterator<User> it = blocked.iterator();
        while(it.hasNext()){
            if(toUnblock.getId().equals(it.next().getId())){
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
}
