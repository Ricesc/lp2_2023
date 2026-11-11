/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escobarfinal_lp2;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author rices
 */
public class usuario {
    int id;
    String usuario;
    String email;
    String password;
    String estado;
    String rol;
    String fechaDeRegistro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }
    
    public void MostrarUsuario(JTable paramtabla){
        conexion  objetoConexion = new conexion(); 
        DefaultTableModel model = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(model);
        paramtabla.setRowSorter(OrdenarTabla);
        String sql="";
        model.addColumn("Id");
        model.addColumn("Usuario");
        model.addColumn("Email");
        model.addColumn("Password");
        model.addColumn("Estado");
        model.addColumn("Rol");
        model.addColumn("Fecha de registro");

        paramtabla.setModel(model);
        sql="select * from usuario";
        String []  datos = new String[7];
        Statement st;
         try{
             st=objetoConexion.establecerConexion().createStatement();
             ResultSet rs =st.executeQuery(sql);
             while(rs.next()){
             datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);
             datos[2]=rs.getString(3);
             datos[3]=rs.getString(4); 
             datos[4]=rs.getString(5);
             datos[5]=rs.getString(6);
             datos[6]=rs.getString(7);
             model.addRow(datos);
         }
             paramtabla.setModel(model);
            
        } catch(Exception e ){
            JOptionPane.showMessageDialog(null,"Error al mostrar los registros"+e.toString());
        }
        
    }
}
