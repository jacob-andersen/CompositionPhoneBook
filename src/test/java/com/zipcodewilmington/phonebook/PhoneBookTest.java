package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void hasEntryTest() {
        //Given
        PhoneBook book = new PhoneBook();
        String name = "sally fields";
        String phonenumber = "214-335-4545";
        //when
        book.add(name, phonenumber);
        boolean actualOutput = book.hasEntry(name);
        //then
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void addTest() {
        //Given
        PhoneBook book = new PhoneBook();
        String name = "bruce willis";
        String phonenumber = "123-456-7890";
        //when
        book.add(name, phonenumber);
        String expected = "123-456-7890";
        String actual = book.lookup(name);
        Assert.assertEquals(expected, actual);
        //then
    }

    @Test
    public void lookupTest() {
        PhoneBook book = new PhoneBook();
        book.add("johnny", "302-555-6789");
        String name = "johnny";

        String expected = "302-555-6789";

        String actual = book.lookup(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest() {
        PhoneBook book = new PhoneBook();
        book.add("charlie chaplin", "123-456-7890");

        String expected = "charlie chaplin";

        String actual = book.reverseLookup("123-456-7890");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        PhoneBook book = new PhoneBook();
        book.add("johnny carson", "124-680-3345");
        book.removeRecord("johnny carson");

        boolean expected = false;

        boolean actual = book.hasEntry("johnny carson");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeRecord() {
        PhoneBook book = new PhoneBook();
        book.add("jimbo", "210-2478-1111");
        book.removeRecord("jimbo");

        boolean expected = false;

        boolean actual = book.hasEntry("jimbo");
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void removePhoneNumber() {
        PhoneBook book = new PhoneBook();
        book.add("jimbo", "210-2478-1111");
        book.removePhoneNumber("210-2478-1111");

        String expected = "person not found!";

        String actual = book.reverseLookup("210-2478-1111");
        Assert.assertEquals(expected, actual);

    }

}
