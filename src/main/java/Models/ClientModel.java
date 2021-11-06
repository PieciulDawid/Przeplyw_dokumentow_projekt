package Models;

public class ClientModel {
    private int Id;
    private String Email;
    private String Address;
    private int TelephoneNumber;

    public ClientModel(int id, String email, String address, int telephoneNumber) {
        Id = id;
        Email = email;
        Address = address;
        TelephoneNumber = telephoneNumber;
    }

    //Getters
    public int getId() {
        return Id;
    }
    public String getEmail() {
        return Email;
    }
    public String getAddress() {
        return Address;
    }
    public int getTelephoneNumber() {
        return TelephoneNumber;
    }

    //Setters
    public void setId(int id) {
        Id = id;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setTelephoneNumber(int telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }
}
