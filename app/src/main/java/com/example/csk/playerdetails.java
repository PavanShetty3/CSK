package com.example.csk;

import java.io.Serializable;

public class playerdetails implements Serializable {
    public String firstName,lastName,position,country,imageName,largeImage;
    public playerdetails(String firstName,String lastName,String position,String country,String imageName,String largeImage)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.position=position;
        this.country=country;
        this.imageName=imageName;
        this.largeImage=largeImage;
    }
}
