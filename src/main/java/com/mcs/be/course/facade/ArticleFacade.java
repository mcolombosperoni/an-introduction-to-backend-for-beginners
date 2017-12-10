package com.mcs.be.course.facade;

import com.mcs.be.course.dto.ArticleDto;

import java.util.List;

/**
 * Created by mcolombo on 06/12/17.
 */
public interface ArticleFacade {

    List<ArticleDto> retrieveAllArticles();

}
