package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.ChucVu;
import com.example.PH32140_AssignmentFinal.entity.SanPham;
import com.example.PH32140_AssignmentFinal.repository.ChucVuRepository;
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

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/detail",
        "/chuc-vu/remove",
        "/chuc-vu/view-update",
        "/chuc-vu/add",
        "/chuc-vu/update"
})
public class ChucVuServlet extends HttpServlet {

    private List<ChucVu> lists = new ArrayList<>();
    private ChucVuRepository repo = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAllCV(request,response);
        }else if(uri.contains("detail")){
            this.detailCV(request,response);
        }else if(uri.contains("remove")){
            this.removeCV(request,response);
        }else{
            this.viewUpdateCV(request,response);
        }
    }

    private void viewUpdateCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChucVu cv = repo.getOne(id);
        request.setAttribute("cv",cv);
        request.getRequestDispatcher("/views/chuc-vu-update.jsp").forward(request,response);
    }

    private void removeCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChucVu cv = repo.getOne(id);
        repo.removeCV(cv);
        viewAllCV(request,response);
    }

    private void detailCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChucVu cv = repo.getOne(id);
        request.setAttribute("cv",cv);
        viewAllCV(request,response);
    }

    private void viewAllCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("cvList",lists);
        request.getRequestDispatcher("/views/chucvu.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addCV(request,response);
        }else{
            this.updateCV(request,response);
        }
    }

    private void updateCV(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        ChucVu cv = new ChucVu();
        BeanUtils.populate(cv,request.getParameterMap());
        repo.updateCV(cv);
        viewAllCV(request,response);
    }

    private void addCV(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        ChucVu cv = new ChucVu();
        BeanUtils.populate(cv,request.getParameterMap());
        repo.addCV(cv);
        viewAllCV(request,response);
    }
}
