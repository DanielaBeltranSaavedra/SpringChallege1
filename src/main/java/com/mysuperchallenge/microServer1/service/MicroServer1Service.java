package com.mysuperchallenge.microServer1.service;


import com.mysuperchallenge.dto.Anime;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Stream;

public interface MicroServer1Service {
     List<Anime> getAll();
    Stream<Integer> getId(@RequestParam(name="x",required = false)Integer x,@RequestParam(name="y",required = false)String y);
    Anime search(@RequestParam(name = "animeid") Integer animeid);
    Stream<Integer> top(@RequestParam(name = "id", defaultValue = "100") Integer id, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "type", required = false) String type, @RequestParam(name = "studios", required = false) String studios, @RequestParam(name = "source", required = false) String source, @RequestParam(name = "mainCast", required = false) String mainCast);
}
