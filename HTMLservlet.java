package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/code")
public class java extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body style='font-family:Arial;'>");
        out.println("<h2>Enter Your Name</h2>");
        out.println("<form method='post'>");
        out.println("<input type='text' name='username' required>");
        out.println("<button type='submit'>Submit</button>");
        out.println("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        out.println("<html><body style='font-family:Arial;'>");
        out.println("<h2>Hello, "
                + escapeHtml(name == null ? "" : name.trim())
                + "!</h2>");
        out.println("<a href='name'>Go Back</a>");
        out.println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
