/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_6_Tuttoring;

import Unidad_7_Tuttoring.*;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class Person {
    String name;
    int age;
    String country;

    public Person(String name, int age, String country) {            
        if(age<0 || age>=100){
            throw new IllegalArgumentException("La edad debe estar entre 1 y 100");
        }
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        
        return age;
    }

    public void setAge(int age) {
        if(age<0 || age>=100){
            throw new IllegalArgumentException("from setter:La edad debe estar entre 1 y 100");
        }
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
