/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_5;

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
public class productos {
    int id;
    String codigo;
    String nombre;
    String descripcion;
    String categoria;
    String vencimiento;
    String cantidad;
    String cantidad_minima;
    String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(String cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

public void MostrarProductos(JTable paramtabla){
        conexion  objetoConexion = new conexion(); 
        DefaultTableModel model = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(model);
        paramtabla.setRowSorter(OrdenarTabla);
        String sql="";
        model.addColumn("Id");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
        model.addColumn("Categoria");
        model.addColumn("Vencimiento");
        model.addColumn("Cantidad");
        model.addColumn("Cantidad minima");
        model.addColumn("Estado");
        paramtabla.setModel(model);
        sql="select * from productos";
        String []  datos = new String[9];
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
             datos[7]=rs.getString(8);
             datos[8]=rs.getString(9);
             model.addRow(datos);
         }
             paramtabla.setModel(model);
            
        } catch(Exception e ){
            JOptionPane.showMessageDialog(null,"Error al mostrar los registros"+e.toString());
        }
        
    }

}