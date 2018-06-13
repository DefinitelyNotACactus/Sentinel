/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import javax.swing.ImageIcon;
import server.actors.User;

/**
 *
 * @author aluno
 */
public class Photo implements Serializable {   
    
    private final ImageIcon icon;
    private String comment;
    private final User author;
    
    public Photo(User author, String iconPath, String comment){
        this.author = author;
        this.icon = new ImageIcon(iconPath);
        if(comment == null || comment.trim().equals("")){
            this.comment = "Sem descrição";
        }
        this.comment = comment;
    }
    
    public void setComment(String newComment){
        comment = newComment;
    }

    public String getComment(){
        return comment;
    }
    
    public ImageIcon getIcon(){
        return icon;
    }
    
    public User getAuthor(){
        return author;
    }
    
}
