package com.android.aaronbonilla.infoapp.clases;

//----------------------------------------------------
//Pojo de datos, para hacer refrencia a bd firebase, para cada elemento
//----------------------------------------------------
public class Model {
    //Declracion de variables para referencia a BD firebase....
    String title, image, description;

    public Model(){
    }

    //geters and setters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
