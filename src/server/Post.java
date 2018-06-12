/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.actors.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David
 */
public class Post implements Serializable {
    
    private String title;
    private String text;
    private final User author;
    
    private Map<String, Boolean> likes;
    //private List<Comment> comments;

    public Post(String title, String text, User author){
        this.title = title;
        this.text = text;
        this.author = author;
        
        likes = new HashMap<>();
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    
    public String getText(){
        return text;
    }
    
    public void setText(String newText){
        this.text = newText;
    }
    
    public User getAuthor(){
        return author;
    }
    
    public void like(User liked){
        likes.putIfAbsent(liked.getId(), true);
    }
    
    public void unlike(User unliked){
        if(likes.containsKey(unliked.getId())){
            likes.remove(unliked.getId());
        }
    }
    
    public int getLikes(){
        return likes.size();
    }
    
    @Override
    public String toString(){
        return title;
    }
}
