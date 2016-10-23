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
import vista.InventarioFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorInventario implements ActionListener, MouseListener{
    
    InventarioFrame vista= new InventarioFrame();
    Modelo modelo= new Modelo();

    public enum AccionMVC{
    }
    
    public ControladorInventario(InventarioFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableInventario.setModel(this.modelo.getTablaProductos());
            
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
