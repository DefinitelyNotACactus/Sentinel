/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author David
 */
public class User extends AbstractActor {

    private String password;
    private int gender;
    private final String dob;

    public User(String name, String email, String password, int gender, String dob){
        super(name, email);
        this.password = password;
        this.gender = gender;
        this.dob = dob;
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
        
    @Override
    public String toString(){
        return getName();
    }
}
