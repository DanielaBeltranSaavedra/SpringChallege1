package com.mysuperchallenge.dto;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CTF")
public class Anime {
    private String _id;
    private int anime_id;
    private String name;
    private String genre;
    private String type;
    private int episodes;
    private double rating;
    private String img;
    private String studios;
    private String source;
    private String main_cast;
    private int c1;
    private int c2;
    private int members;
public Anime(){

}
    public Anime(String _id, int anime_id, String name, String genre, String type, int episodes, double rating, String img, String studios, String source, String main_cast, int c1, int c2, int members) {
        this._id = _id;
        this.anime_id = anime_id;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.episodes = episodes;
        this.rating = rating;
        this.img = img;
        this.studios = studios;
        this.source = source;
        this.main_cast = main_cast;
        this.c1 = c1;
        this.c2 = c2;
        this.members = members;
    }


    @Override
    public String toString() {
        return "Anime{" +
                "_id='" + _id + '\'' +
                ", anime_id=" + anime_id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", episodes=" + episodes +
                ", rating=" + rating +
                ", img='" + img + '\'' +
                ", studios='" + studios + '\'' +
                ", source='" + source + '\'' +
                ", main_cast='" + main_cast + '\'' +
                ", c1=" + c1 +
                ", c2=" + c2 +
                ", members=" + members +
                '}';
    }
}