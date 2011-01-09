/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import bean.Mypics;
import bean.picBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dinesh
 */
@WebServlet(name="xpicServlet", urlPatterns={"/xpicServlet"})
public class xpicServlet extends HttpServlet {

    @EJB picBean picBean;

    @PersistenceUnit
    EntityManagerFactory emf;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet xpicServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet xpicServlet at " + request.getContextPath () + "</h1>");
            ArrayList<String> list = picBean.getflickrImages("nothing");
            out.println("<img src="+list.get(0)+" alt=\"some text\"/>");
            ArrayList<String> anotherList = picBean.getTweetedImages();
            out.println("<h2>"+ anotherList.get(0)+"</h2>");
            ArrayList<String> oneMore = picBean.getflickrImagesForCoordinates(null, null);
            out.println("<h2>"+ oneMore.get(0)+"</h2>");
            Mypics pic = (Mypics)emf.createEntityManager().createNamedQuery("Mypics.findAll").getResultList().get(0);
            out.println("<h2>"+pic.getPiccomment()+"</h2>");
            String insert = picBean.tweetImage("name1","link2", "comment3");
            out.println("<h2>"+ insert +"</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
