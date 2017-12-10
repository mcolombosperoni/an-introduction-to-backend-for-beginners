package com.mcs.be.course.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mcolombo on 02/12/17.
 */
@Entity
@Data
@NoArgsConstructor
@Table
public class Article implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String image;

    @Column
    private String content;

    @Column
    private String tag;

    @Column
    private Boolean approve;


}
