package Models;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClientModel implements Model {
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

    @Override
    public String toString() {
        return "ClientModel{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", TelephoneNumber=" + TelephoneNumber +
                '}';
    }


    public Object[] toTableRow() {
        return new Object[] { Id, Email, Address, TelephoneNumber};
    }



//Tu zaczyna się sekcja bazodanowa

    private static TreeMap<Integer,ClientModel> clientModel = null;

    public static TreeMap<Integer,ClientModel> getAll() {
        if(clientModel != null) {
            return clientModel;
        }

        try {
            List<String[]> clientsRaw = new CSVReader(new FileReader("src/main/java/Backend/clients.csv")).readAll();
            clientModel = clientsRaw.stream()
                    .map((String[] raw)->
                            new ClientModel(
                                    Integer.parseInt(raw[0]),
                                    raw[1],
                                    raw[2],
                                    Integer.parseInt(raw[3])
                            ))
                    .collect(Collectors.toMap(
                            ClientModel::getId,
                            Function.identity(),
                            (a, b)-> a,
                            TreeMap::new));
        }
        catch(IOException | CsvException e) {
            e.printStackTrace();
        }

        return clientModel;
    }

    public static TreeMap<Integer,ClientModel> search(String keyword) {
        String keywordLowerCase = keyword.toLowerCase(Locale.ROOT);
        Predicate<ClientModel> filterFunction = null;
        if(keyword.matches("^[0-9]{3}")) {
             filterFunction = (ClientModel item) -> {
                 return Integer.toString(item.getTelephoneNumber()).startsWith(keywordLowerCase);
             };
        }
        else {
            filterFunction = (ClientModel item)-> {
                return item.getEmail().toLowerCase(Locale.ROOT).startsWith(keywordLowerCase) ||
                        item.getAddress().toLowerCase(Locale.ROOT).startsWith(keywordLowerCase);
            };
        }
        TreeMap<Integer,ClientModel> result = getAll().values().stream()
                .filter(filterFunction)
                .collect(Collectors.toMap(
                        ClientModel::getId,
                        Function.identity(),
                        (a, b)-> a,
                        TreeMap::new));
        return result;
    }

    public static ClientModel get(int id) {
        return getAll().get(id);
    }

    public static void add(ClientModel client) {
        TreeMap<Integer,ClientModel> clients = getAll();
        client.setId(clients.lastKey()+1);
        clients.put(client.getId(), client);
    }

    public static void modify(ClientModel client) {
        getAll().replace(client.getId(), client);
    }


    public static void delete(ClientModel client) {
        getAll().remove(client.getId());
    }

    public static void delete(int id) {
        getAll().remove(id);
    }

    public static void saveChanges() {
        TreeMap<Integer,ClientModel> clients = getAll();
        try {
            ICSVWriter writer = new CSVWriterBuilder(new FileWriter("src/main/java/Backend/clients.csv")).build();
            List<String[]> rawClients = clients.values().stream()
                    .map((ClientModel client)->{
                        String[] rawClient = new String[4];
                        rawClient[0] = String.valueOf(client.getId());
                        rawClient[1] = client.getEmail();
                        rawClient[2] = client.getAddress();
                        rawClient[3] = String.valueOf(client.getTelephoneNumber());
                        return rawClient;
                    })
                    .collect(Collectors.toList());

            writer.writeAll(rawClients);
            writer.flushQuietly();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
