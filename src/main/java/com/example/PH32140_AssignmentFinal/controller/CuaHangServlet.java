package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.CuaHang;
import com.example.PH32140_AssignmentFinal.repository.CuaHangRepository;
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

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/detail",
        "/cua-hang/remove",
        "/cua-hang/view-update",
        "/cua-hang/add",
        "/cua-hang/update"
})
public class CuaHangServlet extends HttpServlet {
    private List<CuaHang> lists = new ArrayList<>();
    private CuaHangRepository repo = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAll(request,response);
        }else if(uri.contains("detail")){
            this.detailSP(request,response);
        }else if(uri.contains("remove")){
            this.removeSP(request,response);
        }else{
            this.viewUpdate(request,response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CuaHang sp = repo.getOne(id);
        request.setAttribute("ch",sp);
        request.getRequestDispatcher("/views/cua-hang-update.jsp").forward(request,response);
    }

    private void removeSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CuaHang sp = repo.getOne(id);
        repo.removeKH(sp);
        viewAll(request,response);

    }

    private void detailSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CuaHang sp = repo.getOne(id);
        request.setAttribute("ch",sp);
        viewAll(request,response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("chList",lists);
        request.getRequestDispatcher("/views/cuahang.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addSP(request,response);
        }else{
            this.updateSP(request,response);
        }
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        CuaHang sp = new CuaHang();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.updateKH(sp);
        viewAll(request,response);
    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        CuaHang sp = new CuaHang();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.addKH(sp);
        viewAll(request,response);
    }
}
