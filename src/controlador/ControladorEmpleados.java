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
    
    EmpleadosFrame vista= new EmpleadosFrame();
    Modelo modelo= new Modelo();

    public enum AccionMVC{
    }
    
    public ControladorEmpleados(EmpleadosFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
            
        } catch (Exception e) {
        }
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {}

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
