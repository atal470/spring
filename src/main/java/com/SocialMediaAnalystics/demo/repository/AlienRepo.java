package com.SocialMediaAnalystics.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SocialMediaAnalystics.demo.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel="/aliens",path="aliensPath")
public interface AlienRepo extends JpaRepository<Alien,Integer> {

              List<Alien> findByTech(String lang);
              List<Alien>findByIdGreaterThan(int aid);
//            @Query("from Alien where lang=?1 order by aname")
//            List<Alien>findByTechSorted(String lang);

    }

