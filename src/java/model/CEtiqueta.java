/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author CESAR
 */
public class CEtiqueta {
    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<CArticulo> lArticulos;
    
    public CEtiqueta(){
        lArticulos = new ArrayList<CArticulo>();
    }
    
    public void setId(int id){ this.id = id; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setDescripcion(String descripcion){ this.descripcion = descripcion; }
    
    public void setLArticulos(ArrayList<CArticulo> lArticulos){ this.lArticulos = lArticulos; }
    
    public int getId(){ return this.id; }
    public String getNombre(){ return this.nombre; }
    public String getDescripcion(){ return this.descripcion; }
    
    public ArrayList<CArticulo> getLArticulos(){ return this.lArticulos; } 
    
}
