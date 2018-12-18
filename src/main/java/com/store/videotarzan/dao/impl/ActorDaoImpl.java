package com.store.videotarzan.dao.impl;

import com.store.videotarzan.dao.ActorDao;
import com.store.videotarzan.model.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ActorDaoImpl implements ActorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addActor(Actor actor) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(actor);
        session.flush();
    }

    public Actor getActorById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Actor actor = session.get(Actor.class, id);
        session.flush();
        return actor;
    }

    public List<Actor> getActorList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Actor");
        List<Actor> actors = query.list();
        session.flush();
        return actors;
    }

    public void editActor(Actor actor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(actor);
        session.flush();
    }

    public void deleteActor(Actor actor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(actor);
        session.flush();
    }

}
