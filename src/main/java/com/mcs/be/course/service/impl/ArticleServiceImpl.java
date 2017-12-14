package com.mcs.be.course.service.impl;

import com.mcs.be.course.dao.ArticleDao;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.model.Article;
import com.mcs.be.course.service.ArticleService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created by mcolombo on 06/12/17.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    @Setter
    private ArticleDao articleDao;

    @Override
    public List<Article> retrieveAllArticles() {
        return articleDao.findAll();
    }

    @Override
    public Article retrieveArticleById(final Long id) throws ElementNotFound {

        Article article = articleDao.findOne(id);

        if (article == null) {
            throw new ElementNotFound("Article with id " + id + " not exist");
        }

        return article;

    }

    @Override
    public Article saveArticle(final Article article) {

        Objects.requireNonNull(article.getTitle(), "the article title cannot be null");
        Objects.requireNonNull(article.getImage(), "the article image cannot be null");
        Objects.requireNonNull(article.getContent(), "the article content cannot be null");

        return articleDao.save(article);
    }

    @Override
    public Article updateArticle(final Article article) throws ElementNotFound {

        Long id = article.getId();
        Objects.requireNonNull(id, "the article id cannot be null during an update");

        Article entity = articleDao.findOne(id);

        if (entity == null) {
            throw new ElementNotFound("Article with id " + id + " not exist");
        }

        if (StringUtils.hasText(article.getTitle())){
            entity.setTitle(article.getTitle());
        }

        if (StringUtils.hasText(article.getContent())){
            entity.setContent(article.getContent());
        }

        if (StringUtils.hasText(article.getImage())){
            entity.setImage(article.getImage());
        }

        if (StringUtils.hasText(article.getTag())){
            entity.setTag(article.getTag());
        }

        if (article.getApprove()){
            entity.setApprove(article.getApprove());
        }

        return articleDao.save(entity);
    }

    @Override
    public Article addLikeToArticle(Long id) throws ElementNotFound {

        Article entity = this.retrieveArticleById(id);

        entity.setApprove(entity.getApprove() ? Boolean.FALSE : Boolean.TRUE);
        entity = articleDao.save(entity);

        return entity;
    }
}
