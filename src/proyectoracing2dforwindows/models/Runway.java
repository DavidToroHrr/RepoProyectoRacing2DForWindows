/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Runway {
    private String name;
    private String description;
    private ArrayList<ArrayList<String>> circuit;

    public Runway(String name, String description, ArrayList<ArrayList<String>> circuit) {
        this.name = name;
        this.description = description;
        this.circuit = circuit;
    }
    
    public void mostrar(){ //Prueba
        System.out.println(name);
        System.out.println(description);
        for(ArrayList<String> row : circuit){
            for(String item : row){
                System.out.print("["+item+"]");
            }
            System.out.println("");
        }
    }
    
}
