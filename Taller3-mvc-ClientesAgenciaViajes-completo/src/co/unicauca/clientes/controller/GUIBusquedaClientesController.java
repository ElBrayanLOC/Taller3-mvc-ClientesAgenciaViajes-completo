package co.unicauca.clientes.controller;

import co.unicauca.clientes.modelo.ClientesDB;
import co.unicauca.clientes.vista.GUIBusquedaClientes;
import java.awt.event.ActionEvent;

/**
 *
 * @author Libardo Pantoja, Ricardo Zambrano Controlador de la
 * GUIBusquedaClientes. Es la unica que tiene un controlador porque cambia el
 * estado del modelo. Las otras GUIs tienen el controlador dentro de la misma
 * vista.
 */
public class GUIBusquedaClientesController implements java.awt.event.ActionListener {

    private ClientesDB modelo;
    private GUIBusquedaClientes vista;

    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.buscarClientesPorProfesion(vista.getProfesion());
    }

    public void addModel(ClientesDB m) {
        this.modelo = m;
    }

    public void addView(GUIBusquedaClientes v) {
        this.vista = v;
    }

}
