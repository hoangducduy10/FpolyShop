package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.NSX;
import com.example.PH32140_AssignmentFinal.repository.NSXRepository;
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

@WebServlet(name = "NSXServlet", value = {
        "/nsx/hien-thi",
        "/nsx/detail",
        "/nsx/remove",
        "/nsx/view-update",
        "/nsx/add",
        "/nsx/update"
})
public class NSXServlet extends HttpServlet {
    private List<NSX> lists = new ArrayList<>();
    private NSXRepository repo = new NSXRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAllNSX(request,response);
        }else if(uri.contains("detail")){
            this.detailNSX(request,response);
        }else if(uri.contains("remove")){
            this.removeNSX(request,response);
        }else{
            this.viewUpdateNSX(request,response);
        }
    }

    private void viewUpdateNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NSX NSX = repo.getOne(id);
        request.setAttribute("NSX",NSX);
        request.getRequestDispatcher("/views/nsx-update.jsp").forward(request,response);
    }

    private void removeNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NSX NSX = repo.getOne(id);
        repo.removeNSX(NSX);
        viewAllNSX(request,response);
    }

    private void detailNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NSX NSX = repo.getOne(id);
        request.setAttribute("NSX",NSX);
        viewAllNSX(request,response);
    }

    private void viewAllNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("NSXList",lists);
        request.getRequestDispatcher("/views/nsx.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addNSX(request,response);
        }else{
            this.updateNSX(request,response);
        }
    }

    private void updateNSX(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        NSX NSX = new NSX();
        BeanUtils.populate(NSX,request.getParameterMap());
        repo.updateNSX(NSX);
        viewAllNSX(request,response);
    }

    private void addNSX(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        NSX NSX = new NSX();
        BeanUtils.populate(NSX,request.getParameterMap());
        repo.addNSX(NSX);
        viewAllNSX(request,response);
    }
}
