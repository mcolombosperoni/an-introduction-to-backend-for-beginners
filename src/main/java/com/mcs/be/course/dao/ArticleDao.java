package com.mcs.be.course.dao;

import com.mcs.be.course.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mcolombo on 06/12/17.
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {


}
