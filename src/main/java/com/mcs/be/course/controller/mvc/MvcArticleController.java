package com.mcs.be.course.controller.mvc;

import com.mcs.be.course.controller.rest.RestArticleController;
import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.facade.ArticleFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mcolombo on 14/12/17.
 */
@Controller(value = "/webmvc")
public class MvcArticleController {

    private static final Logger LOGGER = LogManager.getLogger(RestArticleController.class);


    @Autowired
    private ArticleFacade articleFacade;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        return "jsp/welcome";
    }

    @GetMapping("/w2")
    public String welcome2(Map<String, Object> model) {
        model.put("time", new Date());
        return "thymeleaf/welcome";
    }

}
