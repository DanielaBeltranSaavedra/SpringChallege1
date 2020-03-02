package com.mysuperchallenge.microServer1.controller;


import com.mysuperchallenge.dto.Anime;
import com.mysuperchallenge.microServer1.service.MicroServer1Service;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/anime")
public class MicroServer1Controller {
    @Autowired
    private MicroServer1Service microServer1Service;
    @GetMapping("/all")
    public List<Anime> getAll(){

        return microServer1Service.getAll();

    }
    @GetMapping("/idd")
    public Stream<Integer> getId(@RequestParam(name="x",required = false)Integer x,@RequestParam(name="y",required = false)String y) {
        return microServer1Service.getId(x,y);

    }
    @GetMapping("/search")
    public Anime search(@RequestParam(name="animeid")Integer animeid){

        return microServer1Service.search(animeid);
    }
    @GetMapping("/top")
    public Stream <Integer>top(@RequestParam(name = "id", defaultValue = "100") Integer id, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "type", required = false) String type, @RequestParam(name = "studios", required = false) String studios, @RequestParam(name = "source", required = false) String source, @RequestParam(name = "mainCast", required = false) String mainCast){
        return  microServer1Service.top(id,genre,type,studios,source,mainCast);


    }
}