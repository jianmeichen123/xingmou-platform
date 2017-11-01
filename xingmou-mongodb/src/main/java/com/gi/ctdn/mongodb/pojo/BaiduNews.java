package com.gi.ctdn.mongodb.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by vincent on 16-8-21.
 */
@Document(collection = "baidu_news")
@Data
public class BaiduNews extends Pojo {

    private String author;
    private String url;
    private String abs;
    private String title;
    private String imgUrl;
    private Long publicTime;
    private Long sortTime;
}
