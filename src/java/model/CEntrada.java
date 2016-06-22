/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CESAR
 */
public class CEntrada {
    private int id;
    private String titulo;
    private String contenido;
    private CUsuario usuario;
    
    public CEntrada(){
        //usuario = new CUsuario();
    }   
    
    public void setId(int id){ this.id = id; }
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public void setContenido(String contenido){ this.contenido = contenido; }
    public void setUsuario(CUsuario usuario){ this.usuario = usuario; }
            
    
    public int getId(){ return this.id; }
    public String getTitulo(){ return this.titulo; }
    public String getContenido(){ return this.contenido; }
    public CUsuario getUsuario(){ return this.usuario; }
}
