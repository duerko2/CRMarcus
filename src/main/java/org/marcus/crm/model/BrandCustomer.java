package org.marcus.crm.model;

import java.util.List;

public class BrandCustomer {
    Customer customer;
    Brand brand;
    List<Order> orders;
    List<Budget> budgets;
    List<String> seasons;

    public BrandCustomer(Customer customer, Brand brand, List<Order> orders, List<Budget> budgets, List<String> seasons) {
        this.customer = customer;
        this.brand = brand;
        this.orders = orders;
        this.budgets = budgets;
        this.seasons = seasons;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<String> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<String> seasons) {
        this.seasons = seasons;
    }
}
