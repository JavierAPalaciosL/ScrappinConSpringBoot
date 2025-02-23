package com.musica.letras.controller;

import com.musica.letras.util.Minecraft;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class Lyrics {

    @PostMapping("/lyrics")
    public ResponseEntity<HashMap<Object, Object>> lyrics(@RequestParam String artist, @RequestParam String title) {
        Minecraft mc = new Minecraft();
        mc.setArtist(artist);
        mc.setTitle(title);
        return ResponseEntity.ok(new HashMap<>() {{ put("letter ", mc.getLetter());}});
    }


    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/conflicto")
    public String conflicto(){
        return "conflicto";
    }


}
