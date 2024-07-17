package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.NSX;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NSXRepository {
    public List<NSX> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<NSX> list = s.createQuery("FROM NSX").list();
        s.close();
        return list;
    }

    public NSX getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM NSX NSX WHERE NSX.id =: id");
        q.setParameter("id",id);
        NSX NSX = (NSX) q.getSingleResult();
        return NSX;
    }

    public void addNSX(NSX NSX){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(NSX);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeNSX(NSX NSX){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(NSX);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateNSX(NSX NSX){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(NSX);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
