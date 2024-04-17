package com.task1;

import com.task1.consts.City;
import com.task1.utils.DataFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/washington")
public class NewYorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter = resp.getWriter();
        respWriter.write("<h1 style = text-align:center;>Washington time " + DataFormatter.getDataTime(City.CITY_NEW_YORK) + "</h1>");
        respWriter.close();
        resp.setContentType("text/html");
    }
}
