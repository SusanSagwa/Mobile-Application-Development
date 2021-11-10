package com.example.mydroidcaffev1;

public class Stores {
    private final int storesImage;
    private String storesTitle;
    private String storesDescription;

    Stores(int storesImage, String storesTitle, String storesDescription){
        this.storesImage = storesImage;
        this.storesTitle = storesTitle;
        this.storesDescription = storesDescription;
    }
    public int getstoresImage(){
        return storesImage;
    }
    public String getstoresTitle(){
        return storesTitle;
    }
    public String getstoresDescription(){
        return  storesDescription;
    }
}
