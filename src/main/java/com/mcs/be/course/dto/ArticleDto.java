package com.mcs.be.course.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by mcolombo on 02/12/17.
 */
@Data
public class ArticleDto implements Serializable {

    private Long id;
    private String title;
    private String picture;
    private String plot;
    private String tag;
    private Boolean like;

    public ArticleDto() {
    }

    public ArticleDto(Long id, String title, String picture, String plot, String tag, Boolean like) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.plot = plot;
        this.tag = tag;
        this.like = like;
    }
}
