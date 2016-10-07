/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.util;

import com.hxwr.lds.HibernateConfig;
import com.hxwr.lds.entities.Actor;
import com.hxwr.lds.entities.Category;
import com.hxwr.lds.entities.Film;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 35194
 */
public class HibernateHelper {

    private Session session = null;

    public HibernateHelper() {
        //this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        this.session = HibernateConfig.openSession();
        
        
        
    }

    public List<Film> getFilmTitles(int startID, int endID) {
        List<Film> filmList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Film as film where film.filmId between '" + startID + "' and '" + endID + "'");
            filmList = (List<Film>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }

    public List<Actor> getActorsByID(int filmId) {
        List<Actor> actorList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + filmId + "')");
            actorList =  q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return actorList;
    }

    public Category getCategoryByID(int filmId) {
        List<Category> categoryList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Category as category where category.categoryId in (select filmCat.category.categoryId from FilmCategory as filmCat where filmCat.film.filmId='" + filmId + "')");
            categoryList = (List<Category>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryList.get(0);
    }

}
