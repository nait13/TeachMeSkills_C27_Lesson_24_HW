package com.task2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkAge")
public class AgeCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plan");
        BufferedReader reader = req.getReader();
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            body.append(line);
        }

        String requestBody = body.toString();

        if (requestBody == null || requestBody.isEmpty()) {
            resp.getWriter().write("Error");
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(requestBody, JsonObject.class);
        int age = jsonObject.get("age").getAsInt();
        resp.getWriter().write(age >= 18 ? "User Adult" : "Not an Adult");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String param = req.getParameter("age");
        PrintWriter pw = resp.getWriter();

        if (param == null || param.isEmpty()) {
            return;
        }

        int age;
        try {
            age = Integer.parseInt(param);
        } catch (NumberFormatException e) {
            return;
        }

        pw.write(age >= 18 ? "Adult" : "Not an adult");

    }
}
