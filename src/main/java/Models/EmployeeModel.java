package Models;

public class EmployeeModel {
    private int id;
    private String Name;
    private String Surname;
    private String Login;
    private String Password;

   public void EmployeeModel(int id, String name, String Surname, String Login, String Password){

    }

    //Getters
    public int getId(){
       return id;
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

    //Seters
    public void setId(int id) {
        this.id = id;
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
