package com.mysuperchallenge.microServer1.service.implementation;

import com.mysuperchallenge.dto.Anime;
import com.mysuperchallenge.microServer1.repository.MicroServer1Repository;
import com.mysuperchallenge.microServer1.service.MicroServer1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class MicroServer1ServiceImpl implements MicroServer1Service {
    @Autowired
    private MicroServer1Repository microServer1Repository;
    @Override
    public List<Anime> getAll(){
        return microServer1Repository.findAll();
    }
    @Override
    public Stream<Integer> getId(@RequestParam(name = "x", required = false) Integer x, @RequestParam(name = "y", required = false) String y) {
        Stream<Integer> listId = null;
        if (y != null && x != null) {

            listId = microServer1Repository.findAll()
                    .stream()
                    .filter(anime -> anime.getGenre().equals(y) || anime.getGenre().contains(y))
                    .map(anime -> anime.getAnime_id())
                    .limit(x)
            ;
        }
        if (y != null && x == null) {
            listId = microServer1Repository.findAll()
                    .stream()
                    .filter(anime -> anime.getGenre().equals(y) || anime.getGenre().contains(y))
                    .map(anime -> anime.getAnime_id())
            ;
        }
        if (x != null && y == null) {
            listId = microServer1Repository.findAll()
                    .stream()
                    .map(anime -> anime.getAnime_id())
                    .limit(x);
        }

        return listId;


    }

    @Override
    public Anime search(Integer animeid) {

        return microServer1Repository.findByanimeid(animeid);
    }

    @Override
    public Stream<Integer> top(@RequestParam(name = "id", defaultValue = "100") Integer id, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "type", required = false) String type, @RequestParam(name = "studios", required = false) String studios, @RequestParam(name = "source", required = false) String source, @RequestParam(name = "mainCast", required = false) String mainCast) {
       List<Anime> listTop = microServer1Repository.findAll();

        if (genre != null) {
            listTop.stream()
                    .filter(anime -> anime.getGenre().contains(genre));
        }
        if (type != null) {

            listTop.stream()
                    .filter(anime -> anime.getType().contains(type));
        }
        if (studios != null) {

            listTop.stream()
                    .filter(anime -> anime.getStudios().contains(studios));
        }
        if (source != null) {
            listTop.stream()
                    .filter(anime -> anime.getSource().contains(source));
        }
        if (mainCast != null) {
            listTop.stream()
                    .filter(anime -> anime.getMain_cast().contains(mainCast));
        }
      Stream<Integer>listopo=listTop.stream().sorted(Comparator.comparingDouble(Anime::getRating).reversed())
                .limit(id)
              .map(anime -> anime.getAnime_id());
        return listopo;
    }


}