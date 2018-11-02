package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    public static void main(String[] args) {





        PhoneBook phonebook = new PhoneBook();

        phonebook.add("johnny", "302-555-6789");
        phonebook.add("lewis black", "244-324-5590");
        phonebook.add("johnny", "215-344-5645");
         phonebook.add("sally fields", "214-335-4545");
        phonebook.add("sally fields", "213-336-4588");
        phonebook.add("jimbo", "210-2478-1111");
        phonebook.add("eric idle", "215-2245-3323");
        System.out.println(phonebook.listNamesAndNumbers());


    }

    private Map<String, ArrayList<String>> contacts;

    public PhoneBook() {
        contacts = new TreeMap<String, ArrayList<String>>();

    }

    public boolean hasEntry(String name) {

        return contacts.containsKey(name);
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> details = new ArrayList<>();
        if (hasEntry(name)) {
            details = contacts.get(name);
        }
        details.add(phoneNumber);
        contacts.put(name, details);

    }

    public String lookup(String name) {
        String s = "";
        ArrayList<String> pnumber = new ArrayList<>();
        pnumber = contacts.get(name);
        //    for (int i = 0; i < pnumber.size(); i++) {
        //   s += pnumber.get(i);
        s += pnumber.get(0);
        return s;
    }


    public String reverseLookup(String phoneNumber) {
        // if (contacts.containsValue(phoneNumber)) {
        String status = "person not found!";
        for (String name : contacts.keySet()) {
            ArrayList<String> reverse = contacts.get(name);
            for (String searching : reverse) {
                if (searching.equals(phoneNumber)) {
                    status = name;
                }
            }
        }
        return status;
    }

    public void remove(String name) {
        contacts.remove(name);
    }

    public void removeRecord(String name)
    {
        contacts.remove(name);
    }

    public void removePhoneNumber(String number) {
        String srcName = reverseLookup(number);
        ArrayList<String> newPhonelist = new ArrayList<>();
        ArrayList<String> pnumber = new ArrayList<>();
        pnumber = contacts.get(srcName);
        for (int i = 0; i < pnumber.size(); i++) {
            if (!(pnumber.get(i).equals(number))) {
                newPhonelist.add(i, pnumber.get(i));
            }
            contacts.put(srcName, newPhonelist);
        }
    }

    public String listNamesAndNumbers() {
        {
            String s = "";
            //System.out.println(contacts.keySet());
            for (String name : contacts.keySet()) {
                ArrayList<String> phoneList = contacts.get(name);
                for (int i = 0; i < phoneList.size(); i++) {
                    s += " " + name + " " + " " + phoneList.get(i) + "\n";
                }
            }
            return(s);
        }
    }
}