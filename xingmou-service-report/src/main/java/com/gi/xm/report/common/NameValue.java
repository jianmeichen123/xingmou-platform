package com.gi.xm.report.common;

import com.gi.xm.report.pojo.Pojo;

import java.util.List;

/**
 * Created by vincent on 16-10-1.
 */
public class NameValue extends Pojo {

    private  String name;

    private Long value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }


    public static NameValue getNameValue(List<NameValue> nameValues, String name){
        for (NameValue nameValue : nameValues){
            if (name.equalsIgnoreCase(nameValue.getName())){
                return nameValue;
            }
        }
        NameValue nameValue = new NameValue();
        nameValue.setName(name);
        nameValue.setValue(0l);
        nameValues.add(nameValue);
        return nameValue;
    }
}
