package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.DongSP;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DongSPRepository {
    public List<DongSP> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<DongSP> list = s.createQuery("FROM DongSP").list();
        s.close();
        return list;
    }

    public DongSP getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM DongSP DongSP WHERE DongSP.id =: id");
        q.setParameter("id",id);
        DongSP DongSP = (DongSP) q.getSingleResult();
        return DongSP;
    }

    public void addDongSP(DongSP DongSP){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(DongSP);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeDongSP(DongSP DongSP){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(DongSP);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateDongSP(DongSP DongSP){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(DongSP);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
