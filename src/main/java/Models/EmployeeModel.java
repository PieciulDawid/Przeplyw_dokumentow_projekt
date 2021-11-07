package Models;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    
    @Override
    public String toString() {
        return "EmployeeModel{" + "Id=" + Id + ", Name='" + Name + '\'' + ", Surname='" + Surname + '\'' + ", Login='" + Login + '\'' + ", Password='" + Password + '\'' + '}';
    }

    private static final ArrayList<EmployeeModel> employeeModels = null;
    private static EmployeeModel loggedUser = null;

    public static EmployeeModel login(String login, String password) {
        try {
            List<String[]> users = new CSVReader(new FileReader("src/main/java/Backend/users.csv"))
                    .readAll()
                    .stream()
                    .filter((String[] attr)->attr[3].equals(login) && attr[4].equals(password))
                    .collect(Collectors.toList());
            if(users.isEmpty()) {
                return null;
            }
            String[] userRaw = users.get(0);
            loggedUser = new EmployeeModel(
                    Integer.parseInt(userRaw[0]),
                    userRaw[1],
                    userRaw[2],
                    userRaw[3],
                    userRaw[4]
            );
        }
        catch(IOException | CsvException e) {
            e.printStackTrace();
        }

        return loggedUser;
    }

    public static EmployeeModel getLoggedUser() {
        return loggedUser;
    }

    public static void logout() {
        loggedUser = null;
    }
}
