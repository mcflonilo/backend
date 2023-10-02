package com.example;

import java.util.ArrayList;
import java.util.List;

public class CatRepository {
    private static ArrayList<ApiServlet.Cat> catList = new ArrayList<>();
    public static void addCat(ApiServlet.Cat cat){
        catList.add(cat);
    }

    public static List<ApiServlet.Cat> getCats(){
        return catList;
    }
}
