/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.swing.ImageIcon;

/**
 *
 * @author aluno
 */
public class Photo {   
    
    private final ImageIcon icon;
    private String comment;
    
    public Photo(String iconPath, String comment){
        this.icon = new ImageIcon(iconPath);
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
}
