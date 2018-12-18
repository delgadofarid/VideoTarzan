package com.store.videotarzan.service;

import com.store.videotarzan.model.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> getActorList();

    Actor getActorById(Long actorId);

    void addActor(Actor actor);

    void editActor(Actor actor);

    void deleteActor(Actor actor);

}
