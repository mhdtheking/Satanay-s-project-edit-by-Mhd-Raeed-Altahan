/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking_edit;

/**
 *
 * @author mhd
 */
public abstract class Customer {

    int id;
    String name;
    String number;

    abstract void addCustomer();

    abstract void showInfo();
    abstract String toSString();

}
