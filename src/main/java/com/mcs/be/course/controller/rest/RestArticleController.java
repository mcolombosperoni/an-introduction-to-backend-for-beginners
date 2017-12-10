package com.mcs.be.course.controller.rest;

import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.facade.ArticleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcolombo on 02/12/17.
 */
@RestController
@RequestMapping("/articles")
public class RestArticleController {

    @Autowired
    private ArticleFacade articleFacade;


    @RequestMapping(method = RequestMethod.GET)
    public List<ArticleDto> articles() {
        return articleFacade.retrieveAllArticles();
    }

}
