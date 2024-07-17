package com.example.PH32140_AssignmentFinal.controller;

import com.example.PH32140_AssignmentFinal.entity.KhachHang;
import com.example.PH32140_AssignmentFinal.repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/detail",
        "/khach-hang/remove",
        "/khach-hang/view-update",
        "/khach-hang/add",
        "/khach-hang/update"
})
public class KhachHangServlet extends HttpServlet {
    private List<KhachHang> lists = new ArrayList<>();
    private KhachHangRepository repo = new KhachHangRepository();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.viewAllKhachHang(request,response);
        }else if(uri.contains("detail")){
            this.detailKhachHang(request,response);
        }else if(uri.contains("remove")){
            this.removeKhachHang(request,response);
        }else{
            this.viewUpdateKhachHang(request,response);
        }
    }

    private void viewUpdateKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = repo.getOne(id);
        request.setAttribute("kh",KhachHang);
        request.getRequestDispatcher("/views/khach-hang-update.jsp").forward(request,response);
    }

    private void removeKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = repo.getOne(id);
        repo.removeKH(KhachHang);
        viewAllKhachHang(request,response);
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = repo.getOne(id);
        request.setAttribute("kh",KhachHang);
        viewAllKhachHang(request,response);
    }

    private void viewAllKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = repo.getAll();
        request.setAttribute("khList",lists);
        request.getRequestDispatcher("/views/khachhang.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addKhachHang(request,response);
        }else{
            this.updateKhachHang(request,response);
        }
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        KhachHang KhachHang = new KhachHang();
        try {
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            KhachHang.setNgaySinh(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        KhachHang.setMa(request.getParameter("ma"));
        KhachHang.setId(Integer.parseInt(request.getParameter("id")));
        KhachHang.setTen(request.getParameter("ten"));
        KhachHang.setTenDem(request.getParameter("tenDem"));
        KhachHang.setHo(request.getParameter("ho"));
        KhachHang.setDiaChi(request.getParameter("diaChi"));
        KhachHang.setSdt(request.getParameter("sdt"));
        KhachHang.setThanhPho(request.getParameter("thanhPho"));
        KhachHang.setQuocGia(request.getParameter("quocGia"));
        KhachHang.setMatKhau(request.getParameter("matKhau"));
        repo.updateKH(KhachHang);
        viewAllKhachHang(request,response);
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        KhachHang KhachHang = new KhachHang();
        try {
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            KhachHang.setNgaySinh(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        KhachHang.setMa(request.getParameter("ma"));
        KhachHang.setTen(request.getParameter("ten"));
        KhachHang.setTenDem(request.getParameter("tenDem"));
        KhachHang.setHo(request.getParameter("ho"));
        KhachHang.setDiaChi(request.getParameter("diaChi"));
        KhachHang.setSdt(request.getParameter("sdt"));
        KhachHang.setThanhPho(request.getParameter("thanhPho"));
        KhachHang.setQuocGia(request.getParameter("quocGia"));
        KhachHang.setMatKhau(request.getParameter("matKhau"));
        repo.addKH(KhachHang);
        viewAllKhachHang(request,response);
    }
}
