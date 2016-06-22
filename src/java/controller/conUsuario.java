/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import model.*;

/**
 *
 * @author CESAR
 */
@WebServlet(name = "conUsuario", urlPatterns = {"/conUsuario"})
public class conUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet conUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet conUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    protected void regUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            CListaUsuarios lUsuarios = new CListaUsuarios();
            CUsuario oUsuario = new CUsuario();
            
            oUsuario.setNombre(request.getParameter("strnombre"));
            oUsuario.setApellidos(request.getParameter("strapellidos"));
            oUsuario.setCorreo(request.getParameter("strcorreo"));
            oUsuario.setContrasenia(request.getParameter("strcontrasenia"));
            oUsuario.setSexo(request.getParameter("strsexo"));
            String res = oUsuario.getCorreo() + "|" + lUsuarios.insertarUsuario(oUsuario);
            
            response.setContentType("text/html");
            response.getWriter().write(res);
            
            
        }catch(Exception ex){
            response.setContentType("text/html");
            response.getWriter().write(ex.toString());
        }
    }
    
    protected void loginUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            String correo = request.getParameter("strcorreo");
            String contrasenia =  request.getParameter("strcontrasenia");
            
            CListaUsuarios lUsuarios = new CListaUsuarios();
            CUsuario oUsuario;
            oUsuario = lUsuarios.buscarUsuarioxCorreo(correo);
            if(oUsuario != null){
                if(oUsuario.getContrasenia().equals(contrasenia)){
                    
                    response.setContentType("text/html");
                    response.getWriter().write(oUsuario.getCorreo());
                    
                }else{
                    response.setContentType("text/html");
                    response.getWriter().write("La contraseña esta no es valida");
                }
            }else{
                response.setContentType("text/html");
                response.getWriter().write("La correo no esta registrado esta registrado");
            }            
            
            
        }catch(Exception ex){
            response.setContentType("text/html");
            response.getWriter().write(ex.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String Action = request.getParameter("Action");
        if(Action.equals("regUsuario")){
            regUsuario(request, response);
        }
        if(Action.equals("logUser")){
            loginUsuario(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
