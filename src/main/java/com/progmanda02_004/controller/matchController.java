package com.progmanda02_004.controller;

import com.progmanda02_004.models.MatchModel;
import com.progmanda02_004.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class matchController {

    @Autowired
    MatchRepository matchRepositoryInstance;

    @GetMapping("/matches")
    public Iterable<MatchModel> getMatches() {
        return matchRepositoryInstance.findAll();
    }

    @GetMapping("/matches/{id}")
    public MatchModel getMatch(@PathVariable Long id){return matchRepositoryInstance.findById(id).get();}

    @PostMapping("/matches")
    public MatchModel addMatch(@RequestBody MatchModel newMatch){
        newMatch.setId(null);
        return matchRepositoryInstance.save(newMatch);
    }
    @PutMapping("/matches/{id}")
    public String updateMatchById(@PathVariable Long id, @RequestBody MatchModel matchToUpdateWith) {
        if (matchRepositoryInstance.existsById(id)) {
            matchToUpdateWith.setId(id);
            matchRepositoryInstance.save(matchToUpdateWith);
            return "match updated";
        } else {
            return "match not found";
        }
    }

    @PatchMapping("/matches/{id}")
    public String patchMatchById(@PathVariable Long id, @RequestBody MatchModel matchToUpdateWith) {
        return matchRepositoryInstance.findById(id).map(foundMatch -> {
            if (matchToUpdateWith.getName() != null) foundMatch.setName(matchToUpdateWith.getName());
            if (matchToUpdateWith.getDate() != null) foundMatch.setDate(matchToUpdateWith.getDate());
            if (matchToUpdateWith.getDuration() != null) foundMatch.setDuration(matchToUpdateWith.getDuration());

            matchRepositoryInstance.save(foundMatch);
            return "match updated";
        }).orElse("match not found");
    }

    @DeleteMapping("/matches/{id}")
    public void deleteArtistById(@PathVariable Long id) {
        matchRepositoryInstance.deleteById(id);
    }
}
