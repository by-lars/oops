package de.uulm.sp.pvs.exercises.E06.models;

import java.util.LinkedList;
import java.util.List;

public class Clique {
    private final List<Person> members = new LinkedList<>();
    
    public boolean addMember(Person p) {
        return members.add(p);
    }
    
    public void removeMember(int at) {
        members.remove(at);
    }
    
    @Override
    public String toString() {
        var retString = "";
        
        retString = "CLIQUE: ";
        retString += members.toString();
        
        return retString;
    }
}
