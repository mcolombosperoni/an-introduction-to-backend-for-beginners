package com.mcs.be.course.controller.mvc;

import com.mcs.be.course.controller.rest.RestArticleController;
import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.facade.ArticleFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mcolombo on 14/12/17.
 */
@Controller
@RequestMapping("/webmvc")
public class MvcArticleController {

    private static final Logger LOGGER = LogManager.getLogger(RestArticleController.class);


    @Autowired
    private ArticleFacade articleFacade;

    @GetMapping("/jsp")
    public String welcome(Map<String, Object> model) {

        prepareModel(model);

        return "jsp/welcome";
    }

    @GetMapping("/thymeleaf")
    public String welcome2(Map<String, Object> model) {

        prepareModel(model);

        return "thymeleaf/welcome";
    }

    private void prepareModel(Map<String, Object> model) {
        final List<ArticleDto> articles = articleFacade.retrieveAllArticles();

        model.put("time", new Date());
        model.put("articleList", articles);
    }

}
