package com.example.PH32140_AssignmentFinal.repository;

import com.example.PH32140_AssignmentFinal.config.HibernateConfig;
import com.example.PH32140_AssignmentFinal.entity.ChucVu;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ChucVuRepository {
    public List<ChucVu> getAll(){
        Session s = HibernateConfig.getFACTORY().openSession();
        List<ChucVu> list = s.createQuery("FROM ChucVu").list();
        s.close();
        return list;
    }

    public ChucVu getOne(int id){
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM ChucVu cv WHERE cv.id =: id");
        q.setParameter("id",id);
        ChucVu cv = (ChucVu) q.getSingleResult();
        return cv;
    }

    public void addCV(ChucVu cv){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(cv);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeCV(ChucVu cv){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.delete(cv);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCV(ChucVu cv){
        Transaction trans = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()){
            trans = s.beginTransaction();
            s.saveOrUpdate(cv);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
