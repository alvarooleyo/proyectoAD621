/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Modelo;
import vista.EmpleadosFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorEmpleados implements ActionListener, MouseListener{
    
    int fila = -1;
    int fila1 = -1;
    int fila2 = -1;
    int fila3= -1;
    int fila4= -1;
    EmpleadosFrame vista= new EmpleadosFrame();
    Modelo modelo= new Modelo();

    public enum AccionMVC{        
        btnInsertarEmpleados,
        btnModificarEmpleados,
        btnEliminarEmpleados,
        btnInsertarEnlace,
        btnEliminarEnlace,
        btnLimpiarEmpleado,
        btnLimpiarEnlaceEmpleado
    }
    
    public ControladorEmpleados(EmpleadosFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
            this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoEmpleados());
            this.vista.jTableEnlaceEmpleados.setModel(this.modelo.getTablaEmpleados());
            this.vista.jTableEnlaceBar.setModel(this.modelo.getTablaBar());
            this.vista.jTableInfoEmpleados.setModel(this.modelo.getTablaInfoEmpleados());
            this.vista.txtLicenciaEnlace.setEnabled(false);
            this.vista.txtEmpleadoEnlace.setEnabled(false);
            
        } catch (Exception e) {
        }
        
        this.vista.btnInsertarEmpleados.setActionCommand("btnInsertarEmpleados");
        this.vista.btnInsertarEmpleados.addActionListener(this);
        this.vista.btnModificarEmpleados.setActionCommand("btnModificarEmpleados");
        this.vista.btnModificarEmpleados.addActionListener(this);
        this.vista.btnEliminarEmpleados.setActionCommand("btnEliminarEmpleados");
        this.vista.btnEliminarEmpleados.addActionListener(this);
        this.vista.btnInsertarEnlace.setActionCommand("btnInsertarEnlace");
        this.vista.btnInsertarEnlace.addActionListener(this);
        this.vista.btnEliminarEnlace.setActionCommand("btnEliminarEnlace");
        this.vista.btnEliminarEnlace.addActionListener(this);
        
        this.vista.btnLimpiarEmpleado.setActionCommand("btnLimpiarEmpleado");
        this.vista.btnLimpiarEmpleado.addActionListener(this);
        
        this.vista.btnLimpiarEnlaceEmpleado.setActionCommand("btnLimpiarEnlaceEmpleado");
        this.vista.btnLimpiarEnlaceEmpleado.addActionListener(this);
        
        
        //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
        });
        
        this.vista.jTableEnlaceBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceBarMouseClicked(evt);
            }
        });
        
        this.vista.jTableEnlaceEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceEmpleadosMouseClicked(evt);
            }
        });
        
        this.vista.jTableInfoEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInfoEmpleadosMouseClicked(evt);
            }
        });
        
        this.vista.jTableEnlaceInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceInfoMouseClicked(evt);
            }
        });      
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (ControladorEmpleados.AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarEmpleados:
                try {                
                    String dniEmpleado= this.vista.txtDNIEmpleados.getText();
                    String nombreEmpleado= this.vista.txtNombreEmpleados.getText();
                    String domicilioEmpleado= this.vista.txtDomicilioEmpleados.getText();
                    this.modelo.insertarEmpleado(dniEmpleado, nombreEmpleado, domicilioEmpleado);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
                    LimpiarEmpleados();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }               
                break;
                
            case btnModificarEmpleados:
                try {
                    String dniEmpleado= this.vista.txtDNIEmpleados.getText();
                    String nombreEmpleado= this.vista.txtNombreEmpleados.getText();
                    String domicilioEmpleado= this.vista.txtDomicilioEmpleados.getText();
                    this.modelo.modificarEmpleado(nombreEmpleado, domicilioEmpleado, dniEmpleado);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
                    LimpiarEmpleados();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnEliminarEmpleados:
                try {     
                    String dniEmpleado= this.vista.txtDNIEmpleados.getText();
                    this.modelo.eliminarEmpleado(dniEmpleado);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
                    LimpiarEmpleados();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            
            case btnInsertarEnlace:
                try {
                    String dniPersona= this.vista.txtEmpleadoEnlace.getText();
                    String funcion= this.vista.txtOcupacionEnlace.getText();
                    String bar= this.vista.txtLicenciaEnlace.getText();
                    this.modelo.insertarTieneEmpleados(dniPersona, bar, funcion);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoEmpleados());
                    LimpiarEnlace();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnEliminarEnlace:
                try {
                    String dniPersona= this.vista.txtEmpleadoEnlace.getText();
                    String bar= this.vista.txtLicenciaEnlace.getText();
                    this.modelo.eliminarTieneEmpleados(dniPersona, bar);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoEmpleados());
                    LimpiarEnlace();
                } catch (Exception ex) {
                }
                break;
                
            case btnLimpiarEmpleado:
                
                LimpiarEmpleados();
                
                break;
                
            case btnLimpiarEnlaceEmpleado:
                
                LimpiarEnlace();
                
                break;
        }
    }

    public void LimpiarEmpleados(){
        this.vista.txtDNIEmpleados.setText("");
        this.vista.txtNombreEmpleados.setText("");
        this.vista.txtDomicilioEmpleados.setText("");        
        this.vista.txtDNIEmpleados.setEnabled(true);
    }
    
    public void LimpiarEnlace(){
        this.vista.txtEmpleadoEnlace.setText("");
        this.vista.txtOcupacionEnlace.setText("");
        this.vista.txtLicenciaEnlace.setText("");
        this.vista.txtInfoDNI.setEnabled(true);
        
    }
    
    //----------------------Permite la selección de elementos dentro de tablas---------------------------
    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableEmpleados.getSelectedRow();
        String dniEmpleado = (String) this.vista.jTableEmpleados.getValueAt(fila, 0);
        String[] Relleno = this.modelo.rellenarEmpleados(dniEmpleado);
        this.vista.txtDNIEmpleados.setText(dniEmpleado);
        this.vista.txtNombreEmpleados.setText(Relleno[0]);
        this.vista.txtDomicilioEmpleados.setText(Relleno[1]);
        this.vista.txtDNIEmpleados.setEnabled(false);
    }
    
    private void jTableInfoEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {

        fila2 = this.vista.jTableInfoEmpleados.getSelectedRow();
        String dniEmpleado = (String) this.vista.jTableInfoEmpleados.getValueAt(fila2, 0);
        String Establecimiento = (String) this.vista.jTableInfoEmpleados.getValueAt(fila2, 1);
        String Ocupacion = (String) this.vista.jTableInfoEmpleados.getValueAt(fila2, 2);
        this.vista.txtInfoDNI.setText(dniEmpleado);
        this.vista.txtInfoEstablecimiento.setText(Establecimiento);
        this.vista.txtInfoOcupacion.setText(Ocupacion);
        this.vista.txtInfoDNI.setEnabled(false);
    }
    
    private void jTableEnlaceBarMouseClicked(java.awt.event.MouseEvent evt) {

        fila3 = this.vista.jTableEnlaceBar.getSelectedRow();
        String licenciaFiscal = (String) this.vista.jTableEnlaceBar.getValueAt(fila3, 0);
        this.vista.txtLicenciaEnlace.setText(licenciaFiscal);
        
    }
    
    private void jTableEnlaceEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {

        fila4 = this.vista.jTableEnlaceEmpleados.getSelectedRow();
        String dniPersona = (String) this.vista.jTableEnlaceEmpleados.getValueAt(fila4, 0);
        this.vista.txtEmpleadoEnlace.setText(dniPersona);    
    }
    
    private void jTableEnlaceInfoMouseClicked(java.awt.event.MouseEvent evt) {

        fila4 = this.vista.jTableEnlaceInfo.getSelectedRow();
        String dniPersona = (String) this.vista.jTableEnlaceInfo.getValueAt(fila4, 0);
        String Licencia = (String) this.vista.jTableEnlaceInfo.getValueAt(fila4, 1);
        String Ocupacion = (String) this.vista.jTableEnlaceInfo.getValueAt(fila4, 2);
        this.vista.txtEmpleadoEnlace.setText(dniPersona);    
        this.vista.txtOcupacionEnlace.setText(Ocupacion);
        this.vista.txtLicenciaEnlace.setText(Licencia);
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
