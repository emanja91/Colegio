/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author manja
 */
public class Materia {
    // declaración de variable 
    private int id_materia;
    private String nombre;
    private int creditos;
    private int id_programa;
    private int id_docente;
    
    // reemplazamos int id_programa; // Reemplazado
    private Programa programa;
    //private int id_docente; Reemplazado
    private Docente docente;
    // creamos los constructores uno vacio y otro con todos los atributos de la clase materia

    public Materia() {
    }

    public Materia(int id_materia, String nombre, int creditos, int id_programa, int id_docente, Programa programa, Docente docente) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.creditos = creditos;
        this.id_programa = id_programa;
        this.id_docente = id_docente;
        this.programa = programa;
        this.docente = docente;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    
    
}
