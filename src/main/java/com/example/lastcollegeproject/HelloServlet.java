package com.example.lastcollegeproject;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();


        String action = request.getParameter("page");
        if (action.equalsIgnoreCase("login") ){

            String username = request.getParameter("username");
            String password = (request.getParameter("password"));
            System.out.println(username + " " + password + " ");

            Student student = new UserService().getUser(username, password);
//            System.out.println(user.getUsername()+" "+user.getPassword());
            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("uid", student.getId());
                session.setAttribute("full", student.getFullName());
                session.setAttribute("user", username);
                //                    System.out.println(session.getAttribute("user"));
                request.setAttribute("msg", "Login Successful!");
                System.out.println(request.getAttribute("msg"));

                RequestDispatcher rd = request.getRequestDispatcher("Pages/dashboard.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }

        }

        //To redirect in Register Page
        if (action.equalsIgnoreCase("newUsers"))

        {
            RequestDispatcher rd = request.getRequestDispatcher("Pages/register.jsp");
            rd.forward(request, response);
        }

//        To register a new acount
        if (action.equalsIgnoreCase("register"))

        {
            Student student = new Student();

            student.setUserName(request.getParameter("username"));
            student.setFullName(request.getParameter("fullName"));
            student.setPassword(request.getParameter("password"));

            new UserService().insertUser(student);

            System.out.printf("Data Inserted");

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }

        // send to index page
        if (action.equalsIgnoreCase("index"))

        {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("listuser") ){

            Student student = new Student();
            List<Student> studentList = new UserService().getUserList();

            request.setAttribute("student", student);
            request.setAttribute("studenlist", studentList);
            RequestDispatcher rd = request.getRequestDispatcher("Pages/listuser.jsp");
            rd.forward(request, response);


            }
        }




    public void destroy() {
    }
}