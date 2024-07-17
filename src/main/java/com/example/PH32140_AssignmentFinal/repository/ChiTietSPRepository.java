package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.ChiTietSP;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ChiTietSPRepository {
    public List<ChiTietSP> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<ChiTietSP> list = s.createQuery("FROM ChiTietSP").list();
        s.close();
        return list;
    }

    public ChiTietSP getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM ChiTietSP sp WHERE sp.id =: id");
        q.setParameter("id",id);
        ChiTietSP sp = (ChiTietSP) q.getSingleResult();
        return sp;
    }

    public void addSP(ChiTietSP sp){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(sp);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeSP(ChiTietSP sp){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(sp);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSP(ChiTietSP sp){
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
