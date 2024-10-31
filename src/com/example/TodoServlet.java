package com.example;

import Task_2.Todo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@WebServlet("/todos")
public class TodoServlet extends HttpServlet {
    private final List<Todo> todos = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        out.print(gson.toJson(todos));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        request.getReader().lines().forEach(sb::append);
        Gson gson = new Gson();
        Todo newTodo = gson.fromJson(sb.toString(), Todo.class);
        todos.add(newTodo);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
