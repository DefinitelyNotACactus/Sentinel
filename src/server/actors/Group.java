/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.actors;

import server.actors.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Group extends AbstractActor {
    
    private List<User> admins;
    
    public Group(String name, String id, User founder) {
        super(name, id);
        
        admins = new ArrayList<>();
        admins.add(founder);
    }
    
}
