package com.mcs.be.course.mapping;

import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.model.Article;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created by mcolombo on 06/12/17.
 */
@Component
public class ArticleMapping implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(Article.class, ArticleDto.class)
                .field("image", "picture")
                .field("content", "plot")
                .field("approve", "like")
                .byDefault()
                .mapNulls(false)
                .mapNullsInReverse(true)
                .register();
    }
}