/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.docente;

/**
 *
 * @author rices
 */
public class Docente {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;


    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }
    
    public String getNombre(){
        return nombre;
    }    
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getApellido(){
        return apellido;
    }    
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    public int getEdad(){
        return edad;
    }    
    
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    public String getDireccion(){
        return direccion;
    }    
    
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
}
