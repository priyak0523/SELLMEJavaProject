/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HACKER
 */
public class adPostTest {

    /**
     * Test of getAdPostListObj method, of class adPost.
     */
    @Test
    public void testGetAdPostListObj() {
        System.out.println("getAdPostListObj");
        adPost instance = new adPost();
        ArrayList<adPost> expResult = null;
        ArrayList<adPost> result = instance.getAdPostListObj();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAdPostListObj method, of class adPost.
     */
    @Test
    public void testSetAdPostListObj() {
        System.out.println("setAdPostListObj");
        ArrayList<adPost> adPostListObj = null;
        adPost instance = new adPost();
        instance.setAdPostListObj(adPostListObj);
        ArrayList<adPost> result = instance.getAdPostListObj();
        assertEquals(result, null);
    }

    /**
     * Test of getAdPost_firstName method, of class adPost.
     */
    @Test
    public void testGetAdPost_firstName() {
        System.out.println("getAdPost_firstName");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_firstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_firstName method, of class adPost.
     */
    @Test
    public void testSetAdPost_firstName() {
        System.out.println("setAdPost_firstName");
        String adPost_firstName = "saibaba";
        adPost instance = new adPost();
        instance.setAdPost_firstName(adPost_firstName);
        String result= instance.getAdPost_firstName();
        assertEquals(result, adPost_firstName);
    }

    /**
     * Test of getAdPost_lastName method, of class adPost.
     */
    @Test
    public void testGetAdPost_lastName() {
        System.out.println("getAdPost_lastName");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_lastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_lastName method, of class adPost.
     */
    @Test
    public void testSetAdPost_lastName() {
        System.out.println("setAdPost_lastName");
        String adPost_lastName = "Kumar";
        adPost instance = new adPost();
        instance.setAdPost_lastName(adPost_lastName);
        String result = instance.getAdPost_lastName();
        assertEquals(result, adPost_lastName);
    }

    /**
     * Test of getAdPost_street method, of class adPost.
     */
    @Test
    public void testGetAdPost_street() {
        System.out.println("getAdPost_street");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_street();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_street method, of class adPost.
     */
    @Test
    public void testSetAdPost_street() {
        System.out.println("setAdPost_street");
        String adPost_street = "Priya Street";
        adPost instance = new adPost();
        instance.setAdPost_street(adPost_street);
        String result = instance.getAdPost_street();
        assertEquals(result, adPost_street);
    }

    /**
     * Test of getAdPost_city method, of class adPost.
     */
    @Test
    public void testGetAdPost_city() {
        System.out.println("getAdPost_city");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_city();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_city method, of class adPost.
     */
    @Test
    public void testSetAdPost_city() {
        System.out.println("setAdPost_city");
        String adPost_city = "Sarnia";
        adPost instance = new adPost();
        instance.setAdPost_city(adPost_city);
        String result = instance.getAdPost_city();
        assertEquals(adPost_city, result);
    }

    /**
     * Test of getAdPost_province method, of class adPost.
     */
    @Test
    public void testGetAdPost_province() {
        System.out.println("getAdPost_province");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_province();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_province method, of class adPost.
     */
    @Test
    public void testSetAdPost_province() {
        System.out.println("setAdPost_province");
        String adPost_province = "Ontario";
        adPost instance = new adPost();
        instance.setAdPost_province(adPost_province);
        String result = instance.getAdPost_province();
        assertEquals(adPost_province, result);
    }

    /**
     * Test of getAdPost_country method, of class adPost.
     */
    @Test
    public void testGetAdPost_country() {
        System.out.println("getAdPost_country");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_country();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_country method, of class adPost.
     */
    @Test
    public void testSetAdPost_country() {
        System.out.println("setAdPost_country");
        String adPost_country = "Canada";
        adPost instance = new adPost();
        instance.setAdPost_country(adPost_country);
        String result = instance.getAdPost_country();
        assertEquals(adPost_country, result);
    }

    /**
     * Test of getAdPost_pincode method, of class adPost.
     */
    @Test
    public void testGetAdPost_pincode() {
        System.out.println("getAdPost_pincode");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_pincode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_pincode method, of class adPost.
     */
    @Test
    public void testSetAdPost_pincode() {
        System.out.println("setAdPost_pincode");
        String adPost_pincode = "N7S 1R5";
        adPost instance = new adPost();
        instance.setAdPost_pincode(adPost_pincode);
        String result = instance.getAdPost_pincode();
        assertEquals(adPost_pincode, result);
    }

    /**
     * Test of getAdPost_email method, of class adPost.
     */
    @Test
    public void testGetAdPost_email() {
        System.out.println("getAdPost_email");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_email();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_email method, of class adPost.
     */
    @Test
    public void testSetAdPost_email() {
        System.out.println("setAdPost_email");
        String adPost_email = "kalai@gmail.com";
        adPost instance = new adPost();
        instance.setAdPost_email(adPost_email);
        String result = instance.getAdPost_email();
        assertEquals(adPost_email, result);
    }

    /**
     * Test of getAdPost_contact method, of class adPost.
     */
    @Test
    public void testGetAdPost_contact() {
        System.out.println("getAdPost_contact");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_contact();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_contact method, of class adPost.
     */
    @Test
    public void testSetAdPost_contact() {
        System.out.println("setAdPost_contact");
        String adPost_contact = "519-444-8888";
        adPost instance = new adPost();
        instance.setAdPost_contact(adPost_contact);
        String result = instance.getAdPost_contact();
        assertEquals(adPost_contact, result);
    }

    /**
     * Test of getAdPost_ad_title method, of class adPost.
     */
    @Test
    public void testGetAdPost_ad_title() {
        System.out.println("getAdPost_ad_title");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_ad_title();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdPost_ad_title method, of class adPost.
     */
    @Test
    public void testSetAdPost_ad_title() {
        System.out.println("setAdPost_ad_title");
        String adPost_ad_title = "Sale of Computer";
        adPost instance = new adPost();
        instance.setAdPost_ad_title(adPost_ad_title);
        String result = instance.getAdPost_ad_title();
        assertEquals(adPost_ad_title, result);
    }

    /**
     * Test of getAdPost_ad_des method, of class adPost.
     */
    @Test
    public void testGetAdPost_ad_des() {
        System.out.println("getAdPost_ad_des");
        adPost instance = new adPost();
        String expResult = "";
        String result = instance.getAdPost_ad_des();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAdPost_ad_des method, of class adPost.
     */
    @Test
    public void testSetAdPost_ad_des() {
        System.out.println("setAdPost_ad_des");
        String adPost_ad_des = "This is to check Whether it is working fine or not";
        adPost instance = new adPost();
        instance.setAdPost_ad_des(adPost_ad_des);
        String result = instance.getAdPost_ad_des();
        assertEquals(adPost_ad_des, result);
    }

    
}
