package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.DongSP;
import com.example.PH32140_AssignmentFinal.repository.DongSPRepository;
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

@WebServlet(name = "DongSPServlet", value = {
        "/dong-sp/hien-thi",
        "/dong-sp/detail",
        "/dong-sp/remove",
        "/dong-sp/view-update",
        "/dong-sp/add",
        "/dong-sp/update"
})
public class DongSPServlet extends HttpServlet {
    private List<DongSP> lists = new ArrayList<>();
    private DongSPRepository repo = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAllsp(request,response);
        }else if(uri.contains("detail")){
            this.detailsp(request,response);
        }else if(uri.contains("remove")){
            this.removesp(request,response);
        }else{
            this.viewUpdatesp(request,response);
        }
    }

    private void viewUpdatesp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DongSP sp = repo.getOne(id);
        request.setAttribute("sp",sp);
        request.getRequestDispatcher("/views/dong-sp-update.jsp").forward(request,response);
    }

    private void removesp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DongSP sp = repo.getOne(id);
        repo.removeDongSP(sp);
        viewAllsp(request,response);
    }

    private void detailsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DongSP sp = repo.getOne(id);
        request.setAttribute("sp",sp);
        viewAllsp(request,response);
    }

    private void viewAllsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("spList",lists);
        request.getRequestDispatcher("/views/dongsp.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addsp(request,response);
        }else{
            this.updatesp(request,response);
        }
    }

    private void updatesp(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        DongSP sp = new DongSP();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.updateDongSP(sp);
        viewAllsp(request,response);
    }

    private void addsp(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        DongSP sp = new DongSP();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.addDongSP(sp);
        viewAllsp(request,response);
    }
}
