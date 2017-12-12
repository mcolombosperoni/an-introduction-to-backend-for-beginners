package com.mcs.be.course.facade.impl;

import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.facade.ArticleFacade;
import com.mcs.be.course.model.Article;
import com.mcs.be.course.service.ArticleService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mcolombo on 06/12/17.
 */
@Component
public class ArticleFacadeImpl implements ArticleFacade {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public List<ArticleDto> retrieveAllArticles() {
        List<Article> articles = articleService.retrieveAllArticles();

        List<ArticleDto> articleDtoList = articles.stream()
                .map(a -> mapperFacade.map(a,ArticleDto.class))
                .collect(Collectors.toList());


        return articleDtoList;
    }

    @Override
    public ArticleDto retrieveArticleById(Long id) throws ElementNotFound {
        Article article = articleService.retrieveArticleById(id);
        return mapperFacade.map(article, ArticleDto.class);
    }

    @Override
    public ArticleDto saveOrUpdate(ArticleDto articleDto) throws ElementNotFound {

        Article article = mapperFacade.map(articleDto, Article.class);

        if(article.getId() != null){
            article = articleService.updateArticle(article);
        } else {
            article = articleService.saveArticle(article);
        }

        return mapperFacade.map(article, ArticleDto.class);
    }

    @Override
    public ArticleDto addLikeToArticle(Long id) throws ElementNotFound {
        Article article = articleService.addLikeToArticle(id);
        return mapperFacade.map(article, ArticleDto.class);
    }
}
