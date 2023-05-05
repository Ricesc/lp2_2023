/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.docente;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author rices
 */
public class Main {
    
    
    public static void main(String[] args){
        
        ArrayList<Docente> docentes = new ArrayList<Docente>();
        boolean Activo = true;
        Scanner lector = new Scanner(System.in);
        
        do{
            System.out.println("Que operacion desea realizar?");
            System.out.println("0-Salir");
            System.out.println("1-Insertar");
            System.out.println("2-Eliminar");
            System.out.println("3-Modificar");
            System.out.println("4-Consultar");
            
            int opcion=lector.nextInt();

            if (opcion==1){
                System.out.println("Ingrese un id");
                String id=lector.next();
                System.out.println("Ingrese un nombre");
                String nombre=lector.next();
                System.out.println("Ingrese un apellido");
                String apellido=lector.next();
                System.out.println("Ingrese una edad");
                int edad=lector.nextInt();
                System.out.println("Ingrese una direccion");
                String direccion=lector.next();
                Docente d = new Docente();
                d.setId(id);
                d.setNombre(nombre);
                d.setApellido(apellido);
                d.setEdad(edad);
                d.setDireccion(direccion);
                docentes.add(d);
            }else if(opcion==2){
                System.out.println("Id para eliminar");
                String id = lector.next();
                Iterator<Docente> it = docentes.iterator();
                
                while (it.hasNext()){
                    Docente p = it.next();
                    if(p.getId().equals(id)){
                        it.remove();
                    }
                }
            }else if(opcion==3){
                System.out.println("Ingrese un id");
                String id=lector.next();
                System.out.println("Ingrese un nombre");
                String nombre=lector.next();
                System.out.println("Ingrese un apellido");
                String apellido=lector.next();
                System.out.println("Ingrese una edad");
                int edad=lector.nextInt();
                System.out.println("Ingrese una direccion");
                String direccion=lector.next();
                
                Iterator<Docente> it = docentes.iterator();
                while(it.hasNext()){
                    Docente p=it.next();
                    if(p.getId().equals(id)){
                        p.setNombre(nombre);
                        p.setApellido(apellido);
                        p.setEdad(edad);
                        p.setDireccion(direccion);
                    }
                }
                
            }else if(opcion==4){
                for(Docente d:docentes){
                    System.out.println("Id: "+d.getId()+"\nNombre: "+d.getNombre()+"\nApellido: "+d.getApellido()+"\nEdad: "+d.getEdad()+"\nDireccion: "+d.getDireccion());
                }
            }if(opcion==0){
                break;
            }
        }while(Activo);
    }    
}
