package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.CuaHang;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CuaHangRepository {
    public List<CuaHang> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<CuaHang> list = s.createQuery("FROM CuaHang").list();
        s.close();
        return list;
    }

    public CuaHang getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM CuaHang KH WHERE KH.id =: id");
        q.setParameter("id",id);
        CuaHang KH = (CuaHang) q.getSingleResult();
        return KH;
    }

    public void addKH(CuaHang KH){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(KH);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeKH(CuaHang KH){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(KH);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateKH(CuaHang KH){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(KH);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
