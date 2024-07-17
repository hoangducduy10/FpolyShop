package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.NhanVien;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NhanVienRepository {
    public List<NhanVien> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<NhanVien> list = s.createQuery("FROM NhanVien").list();
        s.close();
        return list;
    }

    public NhanVien getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM NhanVien nv WHERE nv.id =: id");
        q.setParameter("id",id);
        NhanVien nv = (NhanVien) q.getSingleResult();
        return nv;
    }

    public void addNV(NhanVien nv){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(nv);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeNV(NhanVien nv){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(nv);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateNV(NhanVien nv){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(nv);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
