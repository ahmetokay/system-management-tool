package com.smt.enm;

import java.util.ArrayList;
import java.util.List;

public class EnumRequestResponse {

    private static List<String> codeList;

    public EnumRequestResponse(List<String> codeList) {
        this.codeList = codeList;
    }

    public static void addValue(String value){
        if(codeList == null){
            codeList = new ArrayList<>();
        }

        codeList.add(value);
    }


}