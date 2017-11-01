package com.gi.ctdn.view.common;

/**
 * Created by vincent on 16-10-2.
 */
public class StringUtils {


    public static String makeDistrictName(String districtName){
        if (districtName.indexOf("广西") != -1){
            return "广西";
        }else if(districtName.indexOf("西藏") != -1){
            return "西藏";
        }else if(districtName.indexOf("新疆") != -1){
            return "新疆";
        }else if(districtName.indexOf("宁夏") != -1){
            return "宁夏";
        }else if(districtName.indexOf("青海") != -1){
            return "青海";
        }else if(districtName.indexOf("台湾") != -1){
            return "台湾";
        }else if(districtName.indexOf("香港") != -1){
            return "香港";
        }else{
            return districtName.toString().replace("省","").replace("市","").replace("自治区","");
        }
    }
}
