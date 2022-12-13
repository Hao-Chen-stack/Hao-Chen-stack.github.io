package com.cykj.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    //req：请求的对象 resp：响应请求
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("server.........");
        //接受前端传过来的参数
        String acc = req.getParameter("acc");
        String pwd = req.getParameter("pwd");
        System.out.println("账号"+acc);
        System.out.println("密码"+pwd);

        //响应数据给客户端（浏览器）
        PrintWriter writer = resp.getWriter();
        writer.print("success");
    }
}
