package com.store.videotarzan.dao;

import com.store.videotarzan.model.Actor;

import java.util.List;

public interface ActorDao {

    List<Actor> getActorList();

    Actor getActorById(Long actorId);

    void addActor(Actor actor);

    void editActor(Actor actor);

    void deleteActor(Actor actor);

}
