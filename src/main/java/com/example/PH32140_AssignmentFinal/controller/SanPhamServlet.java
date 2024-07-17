package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.SanPham;
import com.example.PH32140_AssignmentFinal.repository.SanPhamRepository;
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

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/view-update",
        "/san-pham/add",
        "/san-pham/update"
})
public class SanPhamServlet extends HttpServlet {

    private List<SanPham> lists = new ArrayList<>();
    private SanPhamRepository repo = new SanPhamRepository();

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
        SanPham sp = repo.getOne(id);
        request.setAttribute("sp",sp);
        request.getRequestDispatcher("/views/san-pham-update.jsp").forward(request,response);
    }

    private void removeSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sp = repo.getOne(id);
        repo.removeSP(sp);
        viewAll(request,response);

    }

    private void detailSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sp = repo.getOne(id);
        request.setAttribute("sp",sp);
        viewAll(request,response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("spList",lists);
        request.getRequestDispatcher("/views/sanpham.jsp").forward(request,response);
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
        SanPham sp = new SanPham();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.updateSP(sp);
        viewAll(request,response);
    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        SanPham sp = new SanPham();
        BeanUtils.populate(sp,request.getParameterMap());
        repo.addSP(sp);
        viewAll(request,response);
    }
}
