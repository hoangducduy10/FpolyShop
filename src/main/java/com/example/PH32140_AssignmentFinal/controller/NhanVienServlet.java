package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.NhanVien;
import com.example.PH32140_AssignmentFinal.repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/detail",
        "/nhan-vien/remove",
        "/nhan-vien/view-update",
        "/nhan-vien/add",
        "/nhan-vien/update"
})
public class NhanVienServlet extends HttpServlet {
    private List<NhanVien> lists = new ArrayList<>();
    private NhanVienRepository repo = new NhanVienRepository();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAllNhanVien(request,response);
        }else if(uri.contains("detail")){
            this.detailNhanVien(request,response);
        }else if(uri.contains("remove")){
            this.removeNhanVien(request,response);
        }else{
            this.viewUpdateNhanVien(request,response);
        }
    }

    private void viewUpdateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien = repo.getOne(id);
        request.setAttribute("nv",NhanVien);
        request.getRequestDispatcher("/views/nhan-vien-update.jsp").forward(request,response);
    }

    private void removeNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien = repo.getOne(id);
        repo.removeNV(NhanVien);
        viewAllNhanVien(request,response);
    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien = repo.getOne(id);
        request.setAttribute("nv",NhanVien);
        viewAllNhanVien(request,response);
    }

    private void viewAllNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("nvList",lists);
        request.getRequestDispatcher("/views/nhanvien.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addNhanVien(request,response);
        }else{
            this.updateNhanVien(request,response);
        }
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        NhanVien NhanVien = new NhanVien();
        try {
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            NhanVien.setNgaySinh(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NhanVien.setMa(request.getParameter("ma"));
        NhanVien.setMa(request.getParameter("id"));
        NhanVien.setTen(request.getParameter("ten"));
        NhanVien.setTenDem(request.getParameter("tenDem"));
        NhanVien.setHo(request.getParameter("ho"));
        NhanVien.setGioiTinh(request.getParameter("gioiTinh"));
        NhanVien.setDiaChi(request.getParameter("diaChi"));
        NhanVien.setSdt(request.getParameter("sdt"));
        NhanVien.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));
        repo.updateNV(NhanVien);
        viewAllNhanVien(request,response);
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        NhanVien NhanVien = new NhanVien();
        try {
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            NhanVien.setNgaySinh(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NhanVien.setMa(request.getParameter("ma"));
        NhanVien.setTen(request.getParameter("ten"));
        NhanVien.setTenDem(request.getParameter("tenDem"));
        NhanVien.setHo(request.getParameter("ho"));
        NhanVien.setGioiTinh(request.getParameter("gioiTinh"));
        NhanVien.setDiaChi(request.getParameter("diaChi"));
        NhanVien.setSdt(request.getParameter("sdt"));
        NhanVien.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));
        repo.addNV(NhanVien);
        viewAllNhanVien(request,response);
    }
}
