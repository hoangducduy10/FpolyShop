package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.MauSac;
import com.example.PH32140_AssignmentFinal.repository.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/detail",
        "/mau-sac/remove",
        "/mau-sac/view-update",
        "/mau-sac/add",
        "/mau-sac/update"
})
public class MauSacServlet extends HttpServlet {
    private List<MauSac> lists = new ArrayList<>();
    private MauSacRepository repo = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAllMS(request,response);
        }else if(uri.contains("detail")){
            this.detailMS(request,response);
        }else if(uri.contains("remove")){
            this.removeMS(request,response);
        }else{
            this.viewUpdateMS(request,response);
        }
    }

    private void viewUpdateMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MauSac ms = repo.getOne(id);
        request.setAttribute("ms",ms);
        request.getRequestDispatcher("/views/mau-sac-update.jsp").forward(request,response);
    }

    private void removeMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MauSac ms = repo.getOne(id);
        repo.removeMS(ms);
        viewAllMS(request,response);
    }

    private void detailMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MauSac MS = repo.getOne(id);
        request.setAttribute("ms",MS);
        viewAllMS(request,response);
    }

    private void viewAllMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("msList",lists);
        request.getRequestDispatcher("/views/mausac.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addMS(request,response);
        }else{
            this.updateMS(request,response);
        }
    }

    private void updateMS(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        MauSac MS = new MauSac();
        BeanUtils.populate(MS,request.getParameterMap());
        repo.updateMS(MS);
        viewAllMS(request,response);
    }

    private void addMS(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        MauSac MS = new MauSac();
        BeanUtils.populate(MS,request.getParameterMap());
        repo.addMS(MS);
        viewAllMS(request,response);
    }
}
