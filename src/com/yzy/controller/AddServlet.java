package com.yzy.controller;

import com.yzy.dao.StudentDao;
import com.yzy.entity.Student;
import com.yzy.service.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/6/21 23:15
 */
@WebServlet(value = "/addServlet")
@MultipartConfig
public class AddServlet extends HttpServlet {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        String username = req.getParameter("username");

        String gender = req.getParameter("gender");

        Part part = req.getPart("img");

        //默认密码
        String password = "123";

        String imgUrl = "";
        String suffix = "";
        String img;

        //上传图片
        if (part != null) {
            String full = part.getSubmittedFileName();
            suffix = full.substring(full.lastIndexOf("."));
            imgUrl = "E:\\projects\\webdemo2\\web\\photos\\" + username + suffix;
            part.write(imgUrl);
        }

        img = "photos/" + username + suffix;
        Student student = new Student();
        student.setId(id);
        student.setPassword(password);
        student.setUsername(username);
        student.setImg(img);
        student.setGender(gender);
        studentDao.insert(student);


        req.getRequestDispatcher("/TurnToMain").forward(req, resp);

    }
}
