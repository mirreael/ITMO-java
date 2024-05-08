package lab1.Domain.Entities;

import lab1.Domain.Enums.Subscription;

public class Client {
    private String firstName;
    private String lastName;
    private String address;
    private int passportID;
    private Subscription status;
    public Client(
            String firstName,
            String lastName,
            String address,
            int passportID,
            Subscription subscription
    ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passportID=passportID;
        status = subscription;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public int getPassportID(){
        return passportID;
    }

    public Subscription getStatus(){
        return status;
    }

    public void setStatus(Subscription status) {
        this.status = status;
    }


}
