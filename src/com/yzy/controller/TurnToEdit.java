package com.yzy.controller;

import com.yzy.dao.StudentDao;
import com.yzy.entity.Student;
import com.yzy.service.StudentDaoImpl;
import jdk.nashorn.internal.runtime.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author com.yzy
 * @version 1.0
 * @description TODO
 * @date 2023/6/21 16:32
 */
@WebServlet(value = "/TurnToEdit")
@Logger
public class TurnToEdit extends HttpServlet {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello");
        Integer id = Integer.valueOf(req.getParameter("id"));
        Student student = studentDao.select(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);

    }

}
