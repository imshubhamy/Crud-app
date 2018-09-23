/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Admin
 */

public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        
        Emp e = new Emp();
        
        e.setName(name);
        e.setEmail(email);
        e.setPassword(password);
        e.setCountry(country);
        
        int status = EmpDao.save(e);
        if (status > 0) {
            out.println("<p>Employee is Entered.</p>");
            request.getRequestDispatcher("index.html").include(request,response);
        }else {
            out.println("Records are not saved. Please try again.");
        }
    }

}
