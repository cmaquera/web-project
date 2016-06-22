/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author CESAR
 */

@Entity
@Table(name="usuario")
public class CUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idusuario")
    private int id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Apellidos")
    private String apellidos;
    @Column(name="Correo")
    private String correo;
    @Column(name="Contrasenia")
    private String contrasenia;
    @Column(name="Sexo")
    private String sexo;
    @Column(name="Frase")
    private String frase;
    @Column(name="Fotografia")
    private String fotografia;
    @Column(name="Banner")
    private String banner;
    
    @Transient
    private ArrayList<CArticulo> lArticulos;
    @Transient
    private ArrayList<CComentario> lComentarios;
    
    public CUsuario(){
        lArticulos =  new ArrayList<CArticulo>();
        lComentarios = new ArrayList<CComentario>();
    }
    
    //metodos de ingreso de datos al objeto
    public void setId(int id){ this.id = id; }
    public void setNombre(String nombre){ this.nombre =  nombre; }
    public void setApellidos(String apellidos){ this.apellidos = apellidos; }
    public void setCorreo(String correo){ this.correo = correo; }
    public void setContrasenia(String contrasenia){ this.contrasenia = contrasenia; }
    public void setSexo(String sexo){ this.sexo = sexo; }
    public void setFrase(String frase){ this.frase = frase; }
    public void setFotografia(String fotografia){ this.fotografia = fotografia; }
    public void setBanner(String banner){ this.banner = banner; }
    
    public void setLArticulos(ArrayList<CArticulo> lArticulos){ this.lArticulos = lArticulos; }
    public void setLComentarios(ArrayList<CComentario> lComentarios){ this.lComentarios = lComentarios; }
    
    //metodos de obtenciones de datos al objeto
    public int getId(){ return this.id; }
    public String getNombre(){ return this.nombre; }
    public String getApellidos(){ return this.apellidos; }
    public String getCorreo(){ return this.correo; }
    public String getContrasenia(){ return this.contrasenia; }
    public String getSexo(){ return this.sexo; }
    public String getFrase(){ return this.frase; }
    public String getFotografia(){ return this.fotografia; }
    public String getBanner(){ return this.banner; }
    
    public ArrayList<CArticulo> getLArticulos(){ return this.lArticulos; }
    public ArrayList<CComentario> getLComentarios(){ return this.lComentarios; }
    
}
