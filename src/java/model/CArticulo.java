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
public class CArticulo extends CEntrada{
    private String subtitulo;
    private String fotografia;
    private String fecha;
    private ArrayList<CEtiqueta> lEtiquetas;
    
    public CArticulo(){       
        lEtiquetas = new ArrayList<CEtiqueta>();
    }
    
    public void setSubtitulo(String subtitulo){ this.subtitulo = subtitulo; }
    public void setFotografia(String fotografia){ this.fotografia = fotografia; }
    public void setFecha(String fecha){ this.fecha = fecha; }
    
    public void setLEtiquetas(ArrayList<CEtiqueta> lEtiquetas){ this.lEtiquetas = lEtiquetas; }
    
    public String getSubtitulo(){ return this.subtitulo; }
    public String getFotografia(){ return this.fotografia; }
    public String getFecha(){ return this.fecha; }
    
    public ArrayList<CEtiqueta> getLEtiquetas(){ return this.lEtiquetas; }
    
}
