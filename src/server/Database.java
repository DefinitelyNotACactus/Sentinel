/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author David
 */
public class Database implements Serializable{
    private static final long serialVersionUID = 147788L;

    private HashMap<String, User> users;
    
    private Database(){
        users = new HashMap<>();
    }
    
    public static Database load(){
        try (FileInputStream fileIn = new FileInputStream("database.ser"); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (Database) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            return new Database();
        }     
    }
    
    public void save(){
        try (FileOutputStream fileOut = new FileOutputStream("database.ser"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        } catch (IOException i) {
        }
    }
    
    public void addUserToDb(User newUser){
        users.put(newUser.getEmail(), newUser);
    }
    
    public boolean emailInUse(String email){
        return users.containsKey(email);
    }
    
    public User getFromMail(String email){
        if(users.containsKey(email)){
            return users.get(email);
        } else {
            return null;
        }
    }
    
    public String getPassword(String email){
        return users.get(email).getPassword();
    }
}
