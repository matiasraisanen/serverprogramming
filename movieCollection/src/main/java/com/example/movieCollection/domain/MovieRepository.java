package com.example.movieCollection.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource
public interface MovieRepository extends CrudRepository<Movie, Long>{

}
