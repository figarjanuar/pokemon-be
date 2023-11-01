package com.fgr.pokemon.service;

import com.fgr.pokemon.request.RenameRequest;

public interface AppService {
    Boolean catchWith50PercentProbability();

    Integer releasePokemon();

    String renamePokemon(RenameRequest req);
}
