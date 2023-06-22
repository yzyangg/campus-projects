package com.yzy.controller;

import com.yzy.dao.StudentDao;
import com.yzy.entity.Student;
import com.yzy.service.StudentDaoImpl;
import jdk.nashorn.internal.runtime.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author com.yzy
 * @version 1.0
 * @description TODO
 * @date 2023/6/21 16:32
 */
@WebServlet(value = "/editServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));

        Student oldStudent = studentDao.select(id);

        String password = oldStudent.getPassword();

        String username = req.getParameter("username");

        String gender = req.getParameter("gender");
        System.out.println(gender);

        Part part = req.getPart("img");
        String imgUrl = "";
        String suffix = "";
        if (part != null) {
            String full = part.getSubmittedFileName();
            suffix = part.getSubmittedFileName().substring(full.lastIndexOf("."));
        } else {
            //TODO 默认头像
        }
        imgUrl = "E:\\projects\\webdemo2\\web\\photos\\" + username + suffix;
        if (part != null) {
            part.write(imgUrl);
        }

        Student student = new Student();
        student.setGender(gender);
        student.setUsername(username);
        student.setId(id);
        String img = "photos/" + username + suffix;
        student.setImg(img);
        student.setPassword(password);

        studentDao.update(student);

        req.getRequestDispatcher("/TurnToMain").forward(req, resp);
    }
}
