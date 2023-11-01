package com.fgr.pokemon.controller;

import com.fgr.pokemon.request.RenameRequest;
import com.fgr.pokemon.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "*")
public class AppController {

    private AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("catch")
    public ResponseEntity<String> catchPokemon() {
        boolean success = appService.catchWith50PercentProbability();
        if (success) {
            return ResponseEntity.ok("You caught the Pokemon!");
        } else {
            return ResponseEntity.badRequest().body("Oops! The Pokemon got away.");
        }
    }

    @PostMapping("release")
    public ResponseEntity<Integer> releasePokemon() {
        int result = appService.releasePokemon();
        if (result != -1) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PostMapping("rename")
    public ResponseEntity<String> renamePokemon(@RequestBody RenameRequest req) {
        return ResponseEntity.ok(appService.renamePokemon(req));
    }
}
