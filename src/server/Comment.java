/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.actors.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Comment implements Serializable {
    
    private String text;
    
    private User author;
    private final ImageIcon icon;
    private List<Comment> comments;
    
    public Comment(String text, User author){
        this.text = text;
        this.author = author;
        
        icon = null;
        comments = new ArrayList<>();
    }
    
    public Comment(String text, User author, String iconPath){
        this.text = text;
        this.author = author;
        
        icon = new ImageIcon(iconPath);
        comments = new ArrayList<>();
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
    
    public void setAuthor(User newAuthor){
        author = newAuthor;
    }
    
    public ImageIcon getIcon(){
        return icon;
    }
    
    public void addComment(Comment newComment){
        comments.add(newComment);
    }
    
    public List<Comment> getComments(){
        return comments;
    }
}
