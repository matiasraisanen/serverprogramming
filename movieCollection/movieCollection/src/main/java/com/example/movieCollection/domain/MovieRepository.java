package com.example.movieCollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource
public interface MovieRepository extends CrudRepository<Movie, Long>{

}
