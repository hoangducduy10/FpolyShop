package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.MauSac;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MauSacRepository {
    public List<MauSac> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<MauSac> list = s.createQuery("FROM MauSac").list();
        s.close();
        return list;
    }

    public MauSac getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM MauSac ms WHERE ms.id =: id");
        q.setParameter("id",id);
        MauSac ms = (MauSac) q.getSingleResult();
        return ms;
    }

    public void addMS(MauSac ms){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(ms);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeMS(MauSac ms){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(ms);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateMS(MauSac ms){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(ms);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
