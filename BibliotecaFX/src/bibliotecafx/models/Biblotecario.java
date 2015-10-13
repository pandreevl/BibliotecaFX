/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.models;

/**
 *
 * @author Usuario
 */
public class Biblotecario {
    
    private int bibliotecarioID;
    private String nombre;
    private String apellido;
    private String contasena;

    public Biblotecario(int bibliotecarioID, String nombre, String apellido, String contasena) {
        this.bibliotecarioID = bibliotecarioID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contasena = contasena;
    }

    public Biblotecario(String nombre, String contasena) {
        this.nombre = nombre;
        this.contasena = contasena;
    }

    public int getBibliotecarioID() {
        return bibliotecarioID;
    }

    public void setBibliotecarioID(int bibliotecarioID) {
        this.bibliotecarioID = bibliotecarioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContasena() {
        return contasena;
    }

    public void setContasena(String contasena) {
        this.contasena = contasena;
    }
    
    
    
}
