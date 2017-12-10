package com.mcs.be.course.service.impl;

import com.mcs.be.course.dao.ArticleDao;
import com.mcs.be.course.model.Article;
import com.mcs.be.course.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mcolombo on 06/12/17.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> retrieveAllArticles() {
        return articleDao.findAll();
    }
}
