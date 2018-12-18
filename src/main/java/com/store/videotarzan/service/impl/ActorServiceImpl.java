package com.store.videotarzan.service.impl;

import com.store.videotarzan.dao.ActorDao;
import com.store.videotarzan.model.Actor;
import com.store.videotarzan.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorDao actorDao;

    @Override
    public List<Actor> getActorList() {
        return actorDao.getActorList();
    }

    @Override
    public Actor getActorById(Long actorId) {
        return actorDao.getActorById(actorId);
    }

    @Override
    public void addActor(Actor actor) {
        actorDao.addActor(actor);
    }

    @Override
    public void editActor(Actor actor) {
        actorDao.editActor(actor);
    }

    @Override
    public void deleteActor(Actor actor) {
        actorDao.deleteActor(actor);
    }
}
