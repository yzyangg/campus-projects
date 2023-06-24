package com.yzy.controller;

import com.yzy.dao.StudentDao;
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
@WebServlet(value = "/loginServlet")
@Logger
public class LoginServlet extends HttpServlet {

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("123456")) {
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
            return;
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }


        //TODO 校验
    }
}
