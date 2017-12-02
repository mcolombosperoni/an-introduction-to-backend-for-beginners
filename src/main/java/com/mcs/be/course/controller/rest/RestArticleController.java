package com.mcs.be.course.controller.rest;

import com.mcs.be.course.dto.ArticleDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mcolombo on 02/12/17.
 */
@RestController
@RequestMapping("/articles")
public class RestArticleController {


    @RequestMapping(method = RequestMethod.GET)
    public ArticleDto articles() {
        final ArticleDto articleDto = new ArticleDto();
        articleDto.setId(1l);
        articleDto.setTitle("Test");
        return articleDto;
    }

}
