package com.mcs.be.course.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by mcolombo on 02/12/17.
 */
@Entity
@Data
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;




}
