package org.marcus.crm.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.marcus.crm.model.Brand;
import org.marcus.crm.model.BrandTab;
import org.marcus.crm.model.Customer;
import org.marcus.crm.model.Order;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HTTPRequest {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(5))
            .build();


    public static void postCustomer(Customer customer) throws IOException, InterruptedException, SQLException {
        String customerJson = new Gson().toJson(customer);

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(customerJson))
                .uri(URI.create("http://localhost:8080/customers"))
                .setHeader("User-Agent", "CRMarcus Client")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = null;

        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        if(response.body().equals("TimeoutException")){
            throw new SQLTimeoutException();
        }
        if(response.body().equals("SQLException")){
            throw new SQLException();
        }

    }

    public static List<Customer> getCustomers() throws IOException, InterruptedException, SQLException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/customers"))
                .setHeader("User-Agent", "CRMarcus Client")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        List<Customer> customerList = gson.fromJson(response.body(), new TypeToken<List<Customer>>(){}.getType());

        for(int i=0; i<customerList.size(); i++){
            System.out.println(customerList.get(i).getAccountName());
        }
        return customerList;
    }
    public static List<Order> getOrders() throws IOException, InterruptedException, SQLException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/orders"))
                .setHeader("User-Agent", "CRMarcus Client")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .create();

        List<Order> orderList = gson.fromJson(response.body(), new TypeToken<List<Order>>(){}.getType());

        for(int i=0;i<orderList.size();i++){
            System.out.println(orderList.get(i).getCustomer().getAccountName());
            System.out.println(orderList.get(i).getAmount());
        }

        return orderList;
    }

    public static List<BrandTab> getUniqueBrandNames() throws IOException, InterruptedException, SQLException{
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/brands/unique"))
                .setHeader("User-Agent", "CRMarcus Client")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .create();

        List<String> brandList = gson.fromJson(response.body(), new TypeToken<List<String>>(){}.getType());

        List<BrandTab> brandTabs = new ArrayList<>();

        for (String s : brandList) {
            brandTabs.add(new BrandTab(s));
        }


        return brandTabs;
    }

    public static List<String> getAreaNamesByBrand(String currentBrand) throws IOException, InterruptedException, SQLException{
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/brands/"+currentBrand+"/areaNames"))
                .setHeader("User-Agent", "CRMarcus Client")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .create();

        return gson.fromJson(response.body(), new TypeToken<List<String>>(){}.getType());
    }
}
