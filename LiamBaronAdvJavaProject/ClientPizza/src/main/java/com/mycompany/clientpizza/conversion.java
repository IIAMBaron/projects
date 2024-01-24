/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientpizza;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Baron
 */
public class conversion {
    private Object[] names;

    public conversion() {
    }
    
    // This converts an Object into an array
    public void setConversion(Object name) {
        String newName = name.toString();
        // Right now this is a string "[1,2,3]" so what we doing here is removing those brackets
        String newnewName = newName.substring(1, newName.length()-1);
        // And splitting it by the comma into the actualName array of type Object[]
        Object[] actualName = (Object[])newnewName.split(",");
        names = actualName;
        
    }

    public Object[] getNames() {
        return names;
    }
    public Map<String, Object> convertUsingReflection(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        String ans = object.toString();
        String halfMap = ans.substring(1, ans.length()-1);
        System.out.println(halfMap);
        halfMap = halfMap.replace(';', ' ');
        System.out.println("replace " +halfMap);
        String[] stringMap = halfMap.split(",");
        for (int i = 0; i < stringMap.length; i++) {
            map.put(stringMap[i], stringMap[i++]);
        }
        System.out.println("keySet " +map.keySet());
        return map;

    }
}
