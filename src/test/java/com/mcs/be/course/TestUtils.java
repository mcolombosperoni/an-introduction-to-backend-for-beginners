package com.mcs.be.course;

import com.esotericsoftware.kryo.Kryo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcs.be.course.controller.rest.RestArticleController;
import com.mcs.be.course.model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by mcolombo on 13/12/17.
 */
public final class TestUtils {

    private static final Logger LOGGER = LogManager.getLogger(RestArticleController.class);

    public static Article dummyArticleWithIdOne;
    public static List<Article> dummyListArticle;
    public static Article dummyArticleWithoutID;
    public static Article dummyArticleWithoutTitle;
    public static Article dummyArticleWithoutImage;
    public static Article dummyArticleWithoutContent;

    static {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final URI uri = ClassLoader.getSystemResource("articles.json").toURI();
            final String content = new String(Files.readAllBytes(Paths.get(uri)));
            final TypeReference<List<Article>> typeWrapper = new TypeReference<List<Article>>() {};
            dummyListArticle = objectMapper.readValue(content, typeWrapper);
            dummyArticleWithIdOne = dummyListArticle
                    .stream()
                    .filter(e -> 1L == e.getId())
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("no element with ID one found"));
            final Kryo kryo = new Kryo();
            dummyArticleWithoutID = kryo.copy(dummyArticleWithIdOne);
            dummyArticleWithoutID.setId(null);
            dummyArticleWithoutTitle = kryo.copy(dummyArticleWithIdOne);
            dummyArticleWithoutTitle.setTitle(null);
            dummyArticleWithoutImage = kryo.copy(dummyArticleWithIdOne);
            dummyArticleWithoutImage.setImage(null);
            dummyArticleWithoutContent = kryo.copy(dummyArticleWithIdOne);
            dummyArticleWithoutContent.setContent(null);

        } catch (Exception e) {
            LOGGER.error("TestUtils not initialized correctly");
            throw new IllegalStateException(e);
        }
    }

}
