/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
//Prueba
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Modelo;
import vista.ContabilidadFrame;
import vista.EmpleadosFrame;
import vista.Inicio;
import vista.Interface;
import vista.InventarioFrame;
import vista.TitularFrame;

/**
 *
 * @author Alejandro
 */
public class Controlador implements ActionListener, MouseListener {
    
    Inicio vistaInicio;
    
    Interface vista;
    Modelo modelo= new Modelo();
    boolean incluidoTitular= false, incluidoEmpleqados= false, incluidoInventario=false, incluidoContabilidad=false;
    EmpleadosFrame vistaEmpleados= new EmpleadosFrame();
    TitularFrame vistaTitular= new TitularFrame();
    InventarioFrame vistaInventario= new InventarioFrame();
    ContabilidadFrame vistaContabilidad= new ContabilidadFrame();
    
    
    ControladorInicio controladorInicio;
    ControladorBar controladorBar;
    ControladorContabilidad controladorContabilidad;
    ControladorEmpleados controladorEmpleados;
    ControladorInventario controladorInventario;
    
    

    public enum AccionMVC {
        btnTitularInicio,
        btnEmpleadosInicio,
        btnInventarioInicio,
        btnContabilidadInicio,
        btnHome
    }
    
    public Controlador(Interface vista) {
        this.vista = vista;

    }
    
    public void iniciar() {
        
       
        
        try {
            controladorInicio = new ControladorInicio(vistaInicio);
            controladorBar = new ControladorBar(vistaTitular);
            controladorBar.iniciar();
            controladorEmpleados = new ControladorEmpleados(vistaEmpleados);
            controladorEmpleados.iniciar();
            controladorInventario = new ControladorInventario(vistaInventario);
            controladorInventario.iniciar();
            controladorContabilidad = new ControladorContabilidad(vistaContabilidad);
            controladorContabilidad.iniciar();
            } catch (Exception e) {
        }
            this.vista.setVisible(true);
            this.vista.btnTitularInicio.setActionCommand("btnTitularInicio");
            this.vista.btnTitularInicio.addActionListener(this);
            this.vista.btnEmpleadosInicio.setActionCommand("btnEmpleadosInicio");
            this.vista.btnEmpleadosInicio.addActionListener(this);
            this.vista.btnInventarioInicio.setActionCommand("btnInventarioInicio");
            this.vista.btnInventarioInicio.addActionListener(this);
            this.vista.btnContabilidadInicio.setActionCommand("btnContabilidadInicio");
            this.vista.btnContabilidadInicio.addActionListener(this);
            
            this.vista.btnHome.setActionCommand("btnHome");
            this.vista.btnHome.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())) {        
            case btnTitularInicio:                
                    if (incluidoTitular== false){
                        this.vista.jLayeredPane.add(vistaTitular);                    
                        this.vistaTitular.setVisible(true);
                        incluidoTitular= true;
                    }else{
                        this.vistaTitular.setVisible(true);
                        this.vistaEmpleados.setVisible(false);
                        this.vistaInventario.setVisible(false);
                        this.vistaContabilidad.setVisible(false);
                    }                             
                break;
                
            case btnEmpleadosInicio:
                if(incluidoEmpleqados== false){
                    this.vista.jLayeredPane.add(vistaEmpleados);
                    this.vistaEmpleados.setVisible(true);
                    incluidoEmpleqados= true;
                }else{
                    this.vistaTitular.setVisible(false);
                    this.vistaEmpleados.setVisible(true);
                    this.vistaInventario.setVisible(false);
                    this.vistaContabilidad.setVisible(false);
                }
                break;
                
            case btnInventarioInicio:
                if(incluidoInventario== false){
                    this.vista.jLayeredPane.add(vistaInventario);
                    this.vistaInventario.setVisible(true);
                    incluidoInventario= true;
                }else{
                    this.vistaTitular.setVisible(false);
                    this.vistaEmpleados.setVisible(false);
                    this.vistaInventario.setVisible(true);
                    this.vistaContabilidad.setVisible(false);
                }             
                break;
                
            case btnContabilidadInicio:
                if(incluidoContabilidad== false){
                    this.vista.jLayeredPane.add(vistaContabilidad);
                    this.vistaContabilidad.setVisible(true);
                    incluidoContabilidad= true;
                }else{
                    this.vistaTitular.setVisible(false);
                    this.vistaEmpleados.setVisible(false);
                    this.vistaInventario.setVisible(false);
                    this.vistaContabilidad.setVisible(true);
                }
                break;
                
            case btnHome:
                
                System.exit(0);                
                
                break;
        }
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
