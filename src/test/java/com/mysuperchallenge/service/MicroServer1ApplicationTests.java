package com.mysuperchallenge.service;

import com.mysuperchallenge.dto.Anime;
import com.mysuperchallenge.microServer1.repository.MicroServer1Repository;
import com.mysuperchallenge.microServer1.service.MicroServer1Service;
import com.mysuperchallenge.microServer1.service.implementation.MicroServer1ServiceImpl;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroServer1ServiceImpl.class)
public class MicroServer1ApplicationTests {

    @Autowired
    private MicroServer1Service microServer1Service;

    @MockBean
    private MicroServer1Repository microServer1Repository;

    private Anime dataTest;
    private Anime dataTest2;
    private List<Anime> animeList = new ArrayList<>();

    @Before
    public void setup() {
        dataTest = new Anime();
        dataTest.set_id("10");
        dataTest.setAnime_id(1);
        dataTest.setName("AnimeTest1");
        dataTest.setGenre("genreTest");
        dataTest.setType("typeTest");
        dataTest.setEpisodes(999);
        dataTest.setRating(2.0);
        dataTest.setImg("imagetest");
        dataTest.setStudios("studiosTest");
        dataTest.setSource("sourceTest");
        dataTest.setMain_cast("Daniela,Danilo");
        dataTest.setC1(999);
        dataTest.setC2(666);
        dataTest.setMembers(999);
        dataTest2 = new Anime();
        dataTest.set_id("20");
        dataTest2.setAnime_id(2);
        dataTest2.setName("AnimeTest2");
        dataTest2.setGenre("genreTest2");
        dataTest2.setType("typeTest2");
        dataTest2.setEpisodes(99);
        dataTest2.setRating(9.2);
        dataTest2.setImg("imagetest2");
        dataTest2.setStudios("studiosTest2");
        dataTest2.setSource("sourceTest2");
        dataTest2.setMain_cast("Jairo,Juan");
        dataTest2.setC1(99);
        dataTest2.setC2(66);
        dataTest2.setMembers(99);
        animeList.add(dataTest);
        animeList.add(dataTest2);
        Mockito.when(microServer1Repository.findAll()).thenReturn(animeList);
        Mockito.doAnswer(invocationOnMock -> {
            Object[] arguments = invocationOnMock.getArguments();
            if (((int) arguments[0]) == 1) {
                return dataTest;
            } else
                return dataTest2;
        }).when(microServer1Repository).findByanimeid(Mockito.anyInt());



    }

    @Test
    public void TestFindAllId() {
        List<Integer> listAnime = (List<Integer>) microServer1Service.getId(1,"dss").collect(Collectors.toList());
        assertNotNull(listAnime);
        assertEquals(2, listAnime.size());
    }

    @Test
    public void TestFindAnimeById() {
        Anime animeFound = microServer1Service.search(dataTest.getAnime_id());
        assertNotNull(animeFound);
        assertEquals(dataTest.getName(), animeFound.getName());
    }

    @Test
    public void TestRatingCantidad() {
      /*  List<Anime> listRating = (List<Anime>) microServer1Service.top(2).collect(Collectors.toList());
        assertNotNull(listRating);
        assertEquals(2, listRating.size());*/


    }


}
