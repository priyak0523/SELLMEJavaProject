/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HACKER
 */
public class HomePageTest {

    public HomePageTest() {
    }

    /**
     * Test of getFirstName method, of class HomePage.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        HomePage instance = new HomePage();
        String str = "Ranjith";
        String expResult = str;
        instance.setFirstName(str);
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDifferentFirstName() {
        System.out.println("getDifferentFirstName");
        HomePage instance = new HomePage();
        String str = "Ranjith";
        String expResult = "Kalai";
        instance.setFirstName(str);
        String result = instance.getFirstName();
        assertFalse(expResult, false);
    }

    /**
     * Test of getLastName method, of class HomePage.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        HomePage instance = new HomePage();
        String str = "Kalai";
        String expResult = str;
        instance.setLastName(str);
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDifferentLastName() {
        System.out.println("getDifferentLastName");
        HomePage instance = new HomePage();
        String str = "Surya";
        String expResult = "Priya";
        instance.setFirstName(str);
        String result = instance.getFirstName();
        assertFalse(expResult, false);
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        HomePage instance = new HomePage();
        String email = "Kalaipriya.selvi@gmail.com";
        instance.setEmail(email);
        String expResult = email;
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDifferentEmail() {
        System.out.println("getDifferentEmail");
        HomePage instance = new HomePage();
        String email = "Kalaipriya.selvi@gmail.com";
        instance.setEmail(email);
        String expResult = "surya@gmail.com";
        String result = instance.getEmail();
        assertFalse(expResult, false);
    }

    @Test
    public void testGetEmailConfirm() {
        System.out.println("getEmailConfirm");
        HomePage instance = new HomePage();
        String email = "rranjii4u@gmail.com";
        instance.setEmailConfirm(email);
        String expResult = email;
        String result = instance.getEmailConfirm();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmailDifferentConfirm() {
        System.out.println("getEmailConfirm");
        HomePage instance = new HomePage();
        String email = "rranjii4u@gmail.com";
        instance.setEmailConfirm(email);
        String expResult = "kalaipriya.selvi@gmail.com";
        String result = instance.getEmailConfirm();
        assertFalse(expResult, false);
    }

}
