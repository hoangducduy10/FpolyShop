package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.KhachHang;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KhachHangRepository {
    public List<KhachHang> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<KhachHang> list = s.createQuery("FROM KhachHang").list();
        s.close();
        return list;
    }

    public KhachHang getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM KhachHang KH WHERE KH.id =: id");
        q.setParameter("id",id);
        KhachHang KH = (KhachHang) q.getSingleResult();
        return KH;
    }

    public void addKH(KhachHang KH){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(KH);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeKH(KhachHang KH){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(KH);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateKH(KhachHang KH){
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
