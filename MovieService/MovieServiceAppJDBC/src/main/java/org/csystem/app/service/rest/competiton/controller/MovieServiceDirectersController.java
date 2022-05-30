package org.csystem.app.service.rest.competiton.controller;

import org.csystem.app.service.rest.competiton.dto.DirectorsDetail;
import org.csystem.app.service.rest.competiton.entity.DirectorDetail;
import org.csystem.app.service.rest.competiton.service.MovieAppService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/director")
@CrossOrigin//angulardan verileri çekmek için kullandığımız anotation
public class MovieServiceDirectersController {
    private final MovieAppService service;

    public MovieServiceDirectersController(MovieAppService service) {
        this.service = service;
    }

    @GetMapping("directors/find/all")
    public Iterable<DirectorDetail> findAllDirector() {
        return service.findAllDirector();
    }


    @GetMapping("directors/find/movie")
    public DirectorsDetail findByMovieId(@RequestParam("id") Long movieId) {
        return service.findByMovieId(movieId);
    }
}
