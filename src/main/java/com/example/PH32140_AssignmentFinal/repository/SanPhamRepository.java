package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.SanPham;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SanPhamRepository {
    public List<SanPham> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<SanPham> list = s.createQuery("FROM SanPham").list();
        s.close();
        return list;
    }

    public SanPham getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM SanPham sp WHERE sp.id =: id");
        q.setParameter("id",id);
        SanPham sp = (SanPham) q.getSingleResult();
        return sp;
    }

    public void addSP(SanPham sp){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(sp);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeSP(SanPham sp){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(sp);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSP(SanPham sp){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(sp);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
