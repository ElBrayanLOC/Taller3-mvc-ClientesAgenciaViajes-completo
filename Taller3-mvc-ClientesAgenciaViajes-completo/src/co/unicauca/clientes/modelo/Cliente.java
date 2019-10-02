/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.clientes.modelo;

/**
 *
 * @author Libardo Pantoja, Ricardo Zambrano
 * Representa la información básica de un cliente de la agencia de viajes
 */
public class Cliente {

    private String nombres;
    private String profesion;
    private String sexo;

    public Cliente(String nombres, String profesion, String sexo) {
        this.nombres = nombres;
        this.profesion = profesion;
        this.sexo = sexo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
