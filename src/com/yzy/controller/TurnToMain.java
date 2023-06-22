package com.yzy.controller;

import com.yzy.dao.StudentDao;
import com.yzy.service.StudentDaoImpl;

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
@WebServlet(value = "/TurnToMain")
public class TurnToMain extends HttpServlet {

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("students", studentDao.selectAll());
        req.getRequestDispatcher("/main.jsp").forward(req, resp);

        //TODO 校验
    }   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("students", studentDao.selectAll());
        req.getRequestDispatcher("/main.jsp").forward(req, resp);

        //TODO 校验
    }
}
