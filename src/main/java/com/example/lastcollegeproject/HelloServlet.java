package com.example.lastcollegeproject;

import java.io.*;

import Model.Student;
import Service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/user")
public class HelloServlet extends HttpServlet {
    private String message;

//    public void init() {
//        message = "Hello World!";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html");
        ProcessRequest(request, response);
            doPost(request, response);


    }

    private void ProcessRequest(HttpServletRequest request, HttpServletResponse response) {     // remove later
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();


        String page = request.getParameter("login");
        if (page.equalsIgnoreCase("login") ){

            Student student = new Student();

            student.setUserName(request.getParameter("username"));
            student.setFullName(request.getParameter("fullName"));
            student.setPassword(request.getParameter("password"));

            new UserService().insertUser(student);

            System.out.printf("Data Inserted");

            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else if (page.equalsIgnoreCase("newUsers")) {
            RequestDispatcher rd  = request.getRequestDispatcher("pages?index.jsp");
        }

    }

    public void destroy() {
    }
}