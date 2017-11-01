package com.gi.ctdn.mongodb.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by vincent on 16-8-21.
 */
public class Pojo implements Serializable{

    @Id
    private String id;


}