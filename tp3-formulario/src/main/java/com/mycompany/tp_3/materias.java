/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_3;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author rices
 */
public class materias {
    int id;
    String codigo;
    String materia;
    String docente;
    String inicio;
    String fin;

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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
    public void insertarMateria(JTextField paramcodigo, JTextField parammateria, JTextField paramdocente, JTextField paraminicio, JTextField paramfin){
        setCodigo(paramcodigo.getText());
        setMateria(parammateria.getText());
        setDocente(paramdocente.getText());
        setInicio(paraminicio.getText());
        setFin(paramfin.getText());
        conexion objetoConexion = new conexion();
        String Consulta = "INSERT INTO materias(codigo,materia,docente,inicio,fin) VALUES(?,?,?,?,?);";
        try{
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(Consulta);
            cs.setString(1,getCodigo());
            cs.setString(2,getMateria());
            cs.setString(3,getDocente());
            cs.setString(4,getInicio());
            cs.setString(5,getFin());
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se creo correctamente!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hubo un error al intentar guardar en la base de datos!, error"+e.toString());
        }
    }
    
    public void MostrarTabla(JTable paramtabla){
        conexion ObjetoConexion = new conexion();
        DefaultTableModel model = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(model);
        paramtabla.setRowSorter(OrdenarTabla);
        String sql="";
        model.addColumn("Id");
        model.addColumn("Codigo");
        model.addColumn("Materia");
        model.addColumn("Docente");
        model.addColumn("Inicio");
        model.addColumn("Fin");
        
        sql="select * from materias";
        String [] datos = new String[6];
        Statement st;
         try{
             st = ObjetoConexion.establecerConexion().createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
             datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);
             datos[2]=rs.getString(3);
             datos[3]=rs.getString(4);
             datos[4]=rs.getString(5);
             datos[5]=rs.getString(6);
             model.addRow(datos);
             }
             paramtabla.setModel(model);
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error al mostrar los registros"+e.toString());
         }
    }
}
