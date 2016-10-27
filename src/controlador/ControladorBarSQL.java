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
import java.sql.Date;
import modelo.ModeloSQL;
import vista.TitularFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorBarSQL implements ActionListener, MouseListener{

    int fila = -1;
    int fila1 = -1;
    int fila2 = -1;
    int fila3= -1;
    int fila4= -1;
    TitularFrame vista= new TitularFrame();
    ModeloSQL modelo= new ModeloSQL();


    public enum AccionMVC{
        btnInsertarBar,
        btnInsertarTitular,
        btnModificarBar,
        btnModificarTitular,
        btnEliminarBar,
        btnEliminarTitular,
        btnInsertarEnlace,
        btnEliminarEnlace
    }
    
    public ControladorBarSQL(TitularFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableBar.setModel(this.modelo.getTablaBar());
            this.vista.jTableTitular.setModel(this.modelo.getTablaPersona());
            this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoBar());
            this.vista.jTableEnlaceTitular.setModel(this.modelo.getTablaPersona());
            this.vista.jTableEnlaceBar.setModel(this.modelo.getTablaBar());
            this.vista.jTableInfoBar.setModel(this.modelo.getTablaInfoBar());
            
        } catch (Exception e) {
        }
            this.vista.btnInsertarBar.setActionCommand("btnInsertarBar");
            this.vista.btnInsertarBar.addActionListener(this);
            this.vista.btnInsertarTitular.setActionCommand("btnInsertarTitular");
            this.vista.btnInsertarTitular.addActionListener(this);
            this.vista.btnModificarBar.setActionCommand("btnModificarBar");
            this.vista.btnModificarBar.addActionListener(this);
            this.vista.btnModificarTitular.setActionCommand("btnModificarTitular");
            this.vista.btnModificarTitular.addActionListener(this);
            this.vista.btnEliminarBar.setActionCommand("btnEliminarBar");
            this.vista.btnEliminarBar.addActionListener(this);
            this.vista.btnEliminarTitular.setActionCommand("btnEliminarTitular");
            this.vista.btnEliminarTitular.addActionListener(this);
            this.vista.btnInsertarEnlace.setActionCommand("btnInsertarEnlace");
            this.vista.btnInsertarEnlace.addActionListener(this);
            this.vista.btnEliminarEnlace.setActionCommand("btnEliminarEnlace");
            this.vista.btnEliminarEnlace.addActionListener(this);
            
            //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBarMouseClicked(evt);
            }
        });
        
        this.vista.jTableTitular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTitularMouseClicked(evt);
            }
        });
        
        this.vista.jTableEnlaceBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceBarMouseClicked(evt);
            }
        });
        
        this.vista.jTableEnlaceTitular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceTitularMouseClicked(evt);
            }
        });
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarBar:
                try {
                    String licenciaF= this.vista.txtLicenciaBar.getText();
                    String nombreB= this.vista.txtNombreBar.getText();
                    String domicilioB= this.vista.txtDomicilioBar.getText();
                    Date fechaA= Date.valueOf(this.vista.txtFechaBar.getText());
                    String horarioA= this.vista.txtHorarioBar.getText(); 
                    String diasA= this.vista.txtDiasBar.getText();
                    this.modelo.insertarBar(licenciaF, nombreB, domicilioB, fechaA, horarioA, diasA);
                    this.vista.jTableBar.setModel(this.modelo.getTablaBar());
                    this.vista.jTableEnlaceBar.setModel(this.modelo.getTablaBar());
                    LimpiarBar();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                break;
                
            case btnInsertarTitular:
                try {
                    String dniP =this.vista.txtDNI1Titular.getText();
                    String nombreP= this.vista.txtNombre1Titular.getText();
                    String domicilioP = this.vista.txtDomicilio1Titular.getText();
                    this.modelo.insertarPersona(dniP, nombreP, domicilioP);
                    this.vista.jTableTitular.setModel(this.modelo.getTablaPersona());
                    this.vista.jTableEnlaceTitular.setModel(this.modelo.getTablaPersona());
                    LimpiarTitular();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnModificarBar:
                try {
                    String licenciaF= this.vista.txtLicenciaBar.getText();
                    String nombreB= this.vista.txtNombreBar.getText();
                    String domicilioB= this.vista.txtDomicilioBar.getText();
                    Date fechaA= Date.valueOf(this.vista.txtFechaBar.getText());
                    String horarioA= this.vista.txtHorarioBar.getText(); 
                    String diasA= this.vista.txtDiasBar.getText();
                    this.modelo.modificarBar(licenciaF, nombreB, domicilioB, fechaA, horarioA, diasA);
                    this.vista.jTableBar.setModel(this.modelo.getTablaBar());
                    this.vista.jTableEnlaceBar.setModel(this.modelo.getTablaBar());
                    LimpiarBar();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnModificarTitular:
                try {
                    String dniP =this.vista.txtDNI1Titular.getText();
                    String nombreP= this.vista.txtNombre1Titular.getText();
                    String domicilioP= this.vista.txtDomicilio1Titular.getText();   
                    this.modelo.modificarPersona(dniP, nombreP, domicilioP);
                    this.vista.jTableTitular.setModel(this.modelo.getTablaPersona());
                    this.vista.jTableEnlaceTitular.setModel(this.modelo.getTablaPersona());
                    LimpiarTitular();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnEliminarBar:
                try {
                    String licenciaF= this.vista.txtLicenciaBar.getText();
                    this.modelo.eliminarBar(licenciaF);
                    this.vista.jTableBar.setModel(this.modelo.getTablaBar());
                    this.vista.jTableEnlaceBar.setModel(this.modelo.getTablaBar());
                    LimpiarBar();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnEliminarTitular:
                try {
                    String dniP =this.vista.txtDNI1Titular.getText();                
                    this.modelo.eliminarPersona(dniP);
                    this.vista.jTableTitular.setModel(this.modelo.getTablaPersona());
                    this.vista.jTableEnlaceTitular.setModel(this.modelo.getTablaPersona());
                    LimpiarTitular();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;      
                
            case btnInsertarEnlace:
                try {
                    String dniPer= this.vista.txtTitularEnlace.getText();
                    String funcionTra= this.vista.txtOcupacionEnlace.getText();
                    String LicenciaFis= this.vista.txtLicenciaEnlace.getText();
                    boolean esTit= true;
                    this.modelo.insertarInfoBar(dniPer, LicenciaFis, esTit, funcionTra);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoBar());
                    LimpiarEnlace();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnEliminarEnlace:
                try {
                    String dniPer= this.vista.txtTitularEnlace.getText();
                    String licenciaFis= this.vista.txtLicenciaEnlace.getText();
                    this.modelo.eliminarInfoBar(dniPer, licenciaFis);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoBar());
                    LimpiarEnlace();
                } catch (Exception ex) {
                }
                break;
        }
    }
    
    public void LimpiarBar(){
        this.vista.txtLicenciaBar.setText("");
        this.vista.txtNombreBar.setText("");
        this.vista.txtDomicilioBar.setText("");
        this.vista.txtFechaBar.setText("");
        this.vista.txtHorarioBar.setText(""); 
        this.vista.txtDiasBar.getText();
    }
    
    public void LimpiarTitular(){
        this.vista.txtDNI1Titular.setText("");
        this.vista.txtNombre1Titular.setText("");
        this.vista.txtDomicilio1Titular.setText("");
    }
    
    public void LimpiarEnlace(){
        this.vista.txtTitularEnlace.setText("");
        this.vista.txtOcupacionEnlace.setText("");
        this.vista.txtLicenciaEnlace.setText("");
    }
    
    //----------------------Permite la selección de elementos dentro de tablas---------------------------
    private void jTableBarMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableBar.getSelectedRow();
        String LicenciaBar = (String) this.vista.jTableBar.getValueAt(fila, 0);
        //String[] Relleno = this.modelo.rellenarBar(LicenciaBar);

        /*this.vista.txtLicenciaBar.setText(LicenciaBar);
        this.vista.txtNombreBar.setText(Relleno[0]);
        this.vista.txtDomicilioBar.setText(Relleno[1]);
        this.vista.txtFechaBar.setText(Relleno[2]);
        this.vista.txtHorarioBar.setText(Relleno[3]); 
        this.vista.txtDiasBar.setText(Relleno[4]);*/
    }
    
    private void jTableTitularMouseClicked(java.awt.event.MouseEvent evt) {

        fila1 = this.vista.jTableTitular.getSelectedRow();
        String dniTitular = (String) this.vista.jTableTitular.getValueAt(fila1, 0);
        //String[] Relleno = this.modelo.rellenarTitular(dniTitular);
        this.vista.txtDNI1Titular.setText(dniTitular);
        /*this.vista.txtNombre1Titular.setText(Relleno[0]);
        this.vista.txtDomicilio1Titular.setText(Relleno[1]);*/
    }
    
    private void jTableInfoBarMouseClicked(java.awt.event.MouseEvent evt) {

        fila2 = this.vista.jTableTitular.getSelectedRow();
        String dniTitular = (String) this.vista.jTableTitular.getValueAt(fila2, 0);
        //String[] Relleno = this.modelo.rellenarTitular(dniTitular);
        this.vista.txtDNI1Titular.setText(dniTitular);
        /*this.vista.txtNombre1Titular.setText(Relleno[0]);
        this.vista.txtDomicilio1Titular.setText(Relleno[1]);*/
    }
    
    private void jTableEnlaceBarMouseClicked(java.awt.event.MouseEvent evt) {

        fila3 = this.vista.jTableEnlaceBar.getSelectedRow();
        String licenciaFiscal = (String) this.vista.jTableEnlaceBar.getValueAt(fila3, 0);
        this.vista.txtLicenciaEnlace.setText(licenciaFiscal);
    }
    
    private void jTableEnlaceTitularMouseClicked(java.awt.event.MouseEvent evt) {

        fila4 = this.vista.jTableEnlaceTitular.getSelectedRow();
        String dniPersona = (String) this.vista.jTableEnlaceTitular.getValueAt(fila4, 0);
        this.vista.txtTitularEnlace.setText(dniPersona);
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
