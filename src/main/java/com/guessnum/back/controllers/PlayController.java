package com.guessnum.back.controllers;

import com.guessnum.back.entities.Play;
import com.guessnum.back.repositories.PlayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/plays")
public class PlayController {
  @Autowired
  public PlayRepository playRepository;

  @PutMapping(path = "/increase")
  public @ResponseBody Play increaseCounter(@RequestParam(name = "playId") Integer playId) {
    return playRepository.findById(playId)
          .map(play -> {
            play.setPlaysCounter( play.getPlaysCounter()+1 );
            return playRepository.save(play);
          }).get();
  }

  @GetMapping(path = "/{playId}")
  public Play getOnePlay(@PathVariable Integer playId) {
    return playRepository.findById(playId).orElseThrow();
  }
}
