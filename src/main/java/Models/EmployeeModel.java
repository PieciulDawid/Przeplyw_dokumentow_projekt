package Models;

public class EmployeeModel {
    private int Id;
    private String Name;
    private String Surname;
    private String Login;
    private String Password;
    
    public EmployeeModel(int id, String name, String surname, String login, String password){
        Id = id;
        Name = name;
        Surname = surname;
        Login = login;
        Password = password;
    }

    //Getters
    public int getId(){
       return Id;
    }
    public String getName(){
        return Name;
    }
    public String getSurname(){
        return Surname;
    }
    public String getLogin(){
        return Login;
    }
    public String getPassword(){
        return Password;
    }

    //Setters
    public void setId(int id) {
        this.Id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    public void setLogin(String Login) {
        this.Login = Login;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

}
