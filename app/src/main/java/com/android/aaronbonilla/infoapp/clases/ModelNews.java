package com.android.aaronbonilla.infoapp.clases;

//----------------------------------------------------
//Pojo de datos, para hacer refrencia a bd firebase, para cada elemento
//----------------------------------------------------
public class ModelNews {
    //Declracion de variables para referencia a BD firebase....
    String titles, images, authors, descriptions;

    public ModelNews() {
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
