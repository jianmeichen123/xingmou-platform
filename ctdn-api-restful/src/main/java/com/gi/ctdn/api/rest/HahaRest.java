package com.gi.ctdn.api.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("haha")
public class HahaRest {


    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "itjuzi", method=RequestMethod.POST)
    @ResponseBody
    public void getListByEventId(@RequestBody Heihei heihei){
        mongoTemplate.save(heihei);
    }

}
