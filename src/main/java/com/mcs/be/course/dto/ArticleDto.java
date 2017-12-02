package com.mcs.be.course.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by mcolombo on 02/12/17.
 */
@Data
public class ArticleDto implements Serializable{

    private Long id;
    private String title;

}
