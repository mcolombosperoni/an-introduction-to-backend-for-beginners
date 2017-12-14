package com.mcs.be.course.service;

import com.mcs.be.course.dao.ArticleDao;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.model.Article;
import com.mcs.be.course.service.impl.ArticleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.mcs.be.course.TestUtils.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;

/**
 * Created by mcolombo on 13/12/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTest {

    @Mock
    private ArticleDao articleDao;

    private ArticleService articleService;

    @Before
    public void init() {
        articleService = new ArticleServiceImpl();
        ((ArticleServiceImpl)articleService).setArticleDao(articleDao);
    }

    @Test
    public void saveArticle() {
        given(this.articleDao.save(any(Article.class))).willReturn(dummyArticleWithIdOne);
        Article article = articleService.saveArticle(dummyArticleWithoutID);
        assertTrue(article.equals(dummyArticleWithIdOne));
    }

    @Test(expected = NullPointerException.class)
    public void saveArticle_withoutTitle() throws ElementNotFound {
        given(this.articleDao.save(any(Article.class))).willReturn(dummyArticleWithIdOne);
        articleService.saveArticle(dummyArticleWithoutTitle);
    }

    @Test(expected = NullPointerException.class)
    public void saveArticle_withNoImage() throws ElementNotFound {
        given(this.articleDao.save(any(Article.class))).willReturn(dummyArticleWithIdOne);
        articleService.saveArticle(dummyArticleWithoutImage);
    }

    @Test(expected = NullPointerException.class)
    public void saveArticle_withNoContent() throws ElementNotFound {
        given(this.articleDao.save(any(Article.class))).willReturn(dummyArticleWithIdOne);
        articleService.saveArticle(dummyArticleWithoutContent);
    }


    @Test
    public void retrieveArticleById_withExistentId() throws ElementNotFound {
        given(this.articleDao.findOne(1L)).willReturn(dummyArticleWithIdOne);
        Article article = articleService.retrieveArticleById(1L);
        assertTrue(article.equals(dummyArticleWithIdOne));
    }

    @Test(expected = ElementNotFound.class)
    public void retrieveArticleById_withNotExistentId() throws ElementNotFound {
        given(this.articleDao.findOne(anyLong())).willReturn(null);
        articleService.retrieveArticleById(2L);
    }

}



