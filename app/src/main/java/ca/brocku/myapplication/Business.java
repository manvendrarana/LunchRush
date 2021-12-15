package ca.brocku.myapplication;

public class Business {

    //should be in the format " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5\n Phone: 647-332-5934 "
    String RestaurantHeading;

    //source id for the restaurant image.
    int titleImage;


    //constructor (can add address and phone number for additonal info. )
    public Business(String restaurantHeading, int titleImage) {
        RestaurantHeading = restaurantHeading;
        this.titleImage = titleImage;
    }
}
