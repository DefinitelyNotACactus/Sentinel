/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.actors.actions;

import java.io.Serializable;
import server.actors.User;

/**
 *
 * @author David
 */
public class Answer implements Serializable{
    
    private String answer;
    private User author;
    
    public Answer(String answer, User author){
        this.answer = answer;
        this.author = author;
    }
    
    public String getAnswer(){
        return answer;
    }
    
    public void setAnswer(String newAnswer){
        answer = newAnswer;
    }
    
    public User getAuthor(){
        return author;
    }
    
    public void setAuthor(User newAuthor){
        author = newAuthor;
    }
}
