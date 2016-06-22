/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.*;
import java.util.List;

/**
 *
 * @author CESAR
 */
public class DAOUsuario {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/blog_bd";
    static final String USER = "root";
    static final String PASS = "root";
    
    public DAOUsuario(){}
    
    public List<CUsuario> getList(){
        EntityManagerFactory factory = null;
        EntityManager em  = null;
        
        try{
            factory = Persistence.createEntityManagerFactory("blogJPA");
            em = factory.createEntityManager();
            
            return em.createQuery("select u from CUsuario u").getResultList();
            
            
        }catch(Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public  void insertUsuario(CUsuario ousuario){
        EntityManagerFactory factory = null;
        EntityManager em  = null;
        
        try{
            factory = Persistence.createEntityManagerFactory("blogJPA");
            em = factory.createEntityManager();
            
            CUsuario xusuario = em.find(CUsuario.class,ousuario.getId());
            System.out.println("ID : " + ousuario.getId());
            em.getTransaction().begin();
            
            if(xusuario == null){
                System.out.println("Resiatra al nuevo usuario");
                em.persist(ousuario);
            }else{
                System.out.println("Modifica al usuario ya existente");
                xusuario.setNombre(ousuario.getNombre());
                xusuario.setApellidos(ousuario.getApellidos());
                xusuario.setCorreo(ousuario.getCorreo());
                xusuario.setContrasenia(ousuario.getContrasenia());
                xusuario.setSexo(ousuario.getSexo());
                xusuario.setFotografia(ousuario.getFotografia());
                xusuario.setBanner(ousuario.getBanner());
                
            }
            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
