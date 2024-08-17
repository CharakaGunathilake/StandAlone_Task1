package controller;

import db.ThogakadePOS;
import model.Customer;

import java.util.List;

public class Validation {

    public static Customer getCustomer(String givenId) {
        List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
        Customer customerDetails = new Customer();
        for (Customer customer : customerList) {
            if (givenId.equals(customer.getId())) customerDetails = customer;
        }return customerDetails;
    }

    public static boolean isValidID(String givenId) {
        List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
        for (Customer customer : customerList) {
            if (givenId.equals(customer.getId())) {
                return true;
            }
        } return false;
    }
}
