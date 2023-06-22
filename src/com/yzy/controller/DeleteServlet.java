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
@WebServlet(value = "/delete")
@Logger
public class DeleteServlet extends HttpServlet {

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello");
        String id = req.getParameter("id");
        studentDao.delete(Integer.parseInt(id));

        req.getRequestDispatcher("/TurnToMain").forward(req, resp);
        System.out.println(id);

        //TODO 校验
    }
}
