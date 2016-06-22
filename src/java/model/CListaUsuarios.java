/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import DAO.*;

/**
 *
 * @author CESAR
 */
public class CListaUsuarios {
    private List<CUsuario> lUsuarios;
    
    public CListaUsuarios(){
        DAOUsuario ousuarioDAO =  new DAOUsuario();
        lUsuarios = new ArrayList<CUsuario>();
        lUsuarios = ousuarioDAO.getList();
    }
    
    public String insertarUsuario(CUsuario ousuario){
        DAOUsuario ousuarioDAO =  new DAOUsuario();
        
        
        if(this.buscarUsuarioxCorreo(ousuario.getCorreo()) == null){
            ousuarioDAO.insertUsuario(ousuario);
            lUsuarios.add(ousuario);
            return "Se registro correctamente";
        }
        else return "El usuarios ya esta registrado";
    }
    
    public CUsuario buscarUsuarioxCorreo(String correo){
        if(lUsuarios != null){
            for(CUsuario ou : lUsuarios){
                if(ou.getCorreo().equals(correo)){
                    return ou;
                }
            }
        }
        return null;
    }
    
    public String eliminarUsuario(int id){
        int i=-1;
        for(CUsuario ou: lUsuarios)
        {
            i++;
            if(ou.getId() == id) break;
        }
        if(i>-1){ 
            lUsuarios.remove(i);
            return "Se Elimino correctamente";
        }
        return "El usuario no existe";
    }
    
    public String modificarUsuario(CUsuario ousuario){
        int ubicacion = 0;
        for(int i=0; i<this.cantUsuarios(); i++){
            if(lUsuarios.get(i).getId() == ousuario.getId()){
                ubicacion = i;
            }
        }
        lUsuarios.set(ubicacion, ousuario);
        return "Se modifico correrctamente";
    }
    
    public int cantUsuarios(){
        return lUsuarios.size();
    }
    
    public CUsuario getistaUsuarios(int index){
        return lUsuarios.get(index);
    }
}
