package com.netcracker.solver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");

        PrintWriter out = resp.getWriter();
        out.print("<html>\n" +
                        "<head><title>" + "Hello" + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + login + "</h1>\n" +
                        "</body>" +
                "</html>");
    }
}
