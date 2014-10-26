/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infsci2560.simpleServlet.servlets;

import infsci2560.simpleServlet.persistence.SsMessage;
import infsci2560.simpleServlet.persistence.SsMessageFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kolowitzbj
 */
public class MessageServlet extends HttpServlet {
    
    @EJB
    private SsMessageFacadeLocal ssMessageFacade;

    
    protected void getAllMessages(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try
        {
            List<SsMessage> messages = ssMessageFacade.findAll();
            request.setAttribute("messages", messages);
            RequestDispatcher view = request.getRequestDispatcher("listMessages.jsp");
            view.forward(request, response);
        }
        catch ( EJBException ex ) {
            String message = ex.getMessage();
            System.out.println("Exception: " + message);
            throw ex;
        }
        
    }
    protected void getMessage(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {    
        try
        {
            SsMessage message = ssMessageFacade.find(id);
            request.setAttribute("message", message);
            RequestDispatcher view = request.getRequestDispatcher("reviewMessage.jsp");
            view.forward(request, response);
        }
        catch ( EJBException ex ) {
            String message = ex.getMessage();
            System.out.println("Exception: " + message);
            throw ex;
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
        
        String id = request.getParameter("id");
        if ( id == null ) {
            getAllMessages(request, response);
        } else {
            getMessage(request, response, Integer.parseInt(id));
        }
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
        
        Date start=null, connection = null, process =null, cclose =null;
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Boolean valid = false;
        String clean_author, clean_title, clean_message;
        Matcher matcher;
         
        //clean the inputs using regular expressions
        // Compile regular expression
        Pattern pattern = Pattern.compile("[;:,#&'\".!?]");
        // Replace all occurrences of pattern in input
        matcher = pattern.matcher(request.getParameter ("sender"));
        clean_author = matcher.replaceAll("|");
        matcher = pattern.matcher(request.getParameter ("title"));
        clean_title = matcher.replaceAll("|");
        matcher = pattern.matcher(request.getParameter ("message"));
        clean_message = matcher.replaceAll("|");
        
        //open the DBMS and insert the record
        SsMessage message = new SsMessage();
        message.setAuthor(clean_author);
        message.setTitle(clean_title);
        message.setPtime(start);
        message.setMessage(clean_message);
        RequestDispatcher view;
        try {
            ssMessageFacade.create(message);
            request.setAttribute("clean_author", clean_author);
            request.setAttribute("clean_title", clean_title);
            request.setAttribute("clean_message", clean_message);
            
            int connectionTime = 1000; // connection.getTime()-start.getTime()
            int insertTime = 750; // process.getTime()-connection.getTime()
            int closeTime = 250; // cclose.getTime()-process.getTime()
            request.setAttribute("connection_time", connectionTime);
            request.setAttribute("insert_time", insertTime);
            request.setAttribute("close_time", closeTime);
            view = request.getRequestDispatcher("messageSuccess.jsp");
        } catch (Exception ex ) {
            request.setAttribute("sender", request.getParameter("sender"));
            request.setAttribute("message", request.getParameter("message"));
            view = request.getRequestDispatcher("messageError.jsp");            
        }
        view.forward(request, response);
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
