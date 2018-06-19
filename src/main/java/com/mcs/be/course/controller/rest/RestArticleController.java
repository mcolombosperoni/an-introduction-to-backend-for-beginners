package com.mcs.be.course.controller.rest;

import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.facade.ArticleFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by mcolombo on 02/12/17.
 */
@RestController
@RequestMapping(value = "/articles")
@CrossOrigin
public class RestArticleController {

    private static final Logger LOGGER = LogManager.getLogger(RestArticleController.class);


    @Autowired
    private ArticleFacade articleFacade;


    @GetMapping
    public List<ArticleDto> getArticles() {
        return articleFacade.retrieveAllArticles();
    }

    @GetMapping(value = "/{id}")
    public ArticleDto getArticle(@PathVariable("id") Long id) throws ElementNotFound {
        return articleFacade.retrieveArticleById(id);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ArticleDto createArticle(@RequestBody ArticleDto articleDto) throws ElementNotFound {
        return articleFacade.saveOrUpdate(articleDto);
    }

    @PatchMapping(value = "/like")
    @Deprecated
    public ArticleDto like(@RequestBody ArticleDto articleDto ) throws ElementNotFound {
        LOGGER.info("Called like update article, id passed {}", articleDto.getId());
        return articleFacade.addLikeToArticle(articleDto.getId());
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ArticleDto updateArticle(@PathVariable("id") Long id, @RequestBody ArticleDto articleDto) throws ElementNotFound {
        articleDto.setId(id);
        return articleFacade.saveOrUpdate(articleDto);
    }

}
