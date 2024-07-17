package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.ChiTietSP;
import com.example.PH32140_AssignmentFinal.repository.ChiTietSPRepository;
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

@WebServlet(name = "ChiTietSPServlet", value = {
        "/san-pham-chi-tiet/hien-thi",
        "/san-pham-chi-tiet/detail",
        "/san-pham-chi-tiet/remove",
        "/san-pham-chi-tiet/view-update",
        "/san-pham-chi-tiet/add",
        "/san-pham-chi-tiet/update"
})
public class ChiTietSPServlet extends HttpServlet {

    private List<ChiTietSP> lists = new ArrayList<>();
    private ChiTietSPRepository repo = new ChiTietSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAllSPCT(request,response);
        }else if(uri.contains("detail")){
            this.detailSPCT(request,response);
        }else if(uri.contains("remove")){
            this.removeSPCT(request,response);
        }else{
            this.viewUpdateSPCT(request,response);
        }
    }

    private void viewUpdateSPCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSP sp = repo.getOne(id);
        request.setAttribute("spct",sp);
        request.getRequestDispatcher("/views/san-pham-chi-tiet-update.jsp").forward(request,response);
    }

    private void removeSPCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSP sp = repo.getOne(id);
        repo.removeSP(sp);
        viewAllSPCT(request,response);

    }

    private void detailSPCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSP sp = repo.getOne(id);
        request.setAttribute("spct",sp);
        viewAllSPCT(request,response);
    }

    private void viewAllSPCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("spctList",lists);
        request.getRequestDispatcher("/views/san-pham-chi-tiet.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addSPCT(request,response);
        }else{
            this.updateSPCT(request,response);
        }
    }

    private void updateSPCT(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        ChiTietSP sp = new ChiTietSP();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.updateSP(sp);
        viewAllSPCT(request,response);
    }

    private void addSPCT(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        ChiTietSP sp = new ChiTietSP();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.addSP(sp);
        viewAllSPCT(request,response);
    }
}
