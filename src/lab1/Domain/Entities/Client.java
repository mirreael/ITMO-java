package lab1.Domain.Entities;

public class Client {
    private String firstName;
    private String lastName;
    private String address;
    private Integer passportID;
    public Client(
            String firstName,
            String lastName,
            String address,
            Integer passportID
    ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passportID=passportID;
    }
}
