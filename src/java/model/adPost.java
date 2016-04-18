/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
author kalaipriya
*/
package model;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author kalaipriya
 */
@Named
@ManagedBean
@SessionScoped
@ApplicationScoped

public class adPost {

    private Part file;

    String adPost_file_path = "";
    int x = 0;
    public boolean validationCheck = true;

    String adPost_firstName, adPost_lastName, adPost_street, adPost_city, adPost_province, adPost_country,
            adPost_pincode, adPost_email, adPost_contact, adPost_ad_title, adPost_ad_des, adPost_category;

    String adPost_firstName_errmsg, adPost_lastName_errmsg, adPost_street_errmsg, adPost_city_errmsg,
            adPost_province_errmsg, adPost_country_errmsg,
            adPost_pincode_errmsg, adPost_email_errmsg, adPost_contact_errmsg, adPost_ad_title_errmsg,
            adPost_ad_des_errmsg, adPost_category_errmsg;

//    String temp_adPost_firstName, temp_adPost_lastName, temp_adPost_street, temp_adPost_city, temp_adPost_province, 
//           temp_adPost_country,temp_adPost_pincode, temp_adPost_email, temp_adPost_contact, temp_adPost_ad_title,
//            temp_adPost_ad_des, temp_adPost_category;
    public boolean entryCounter = true;

    int adPost_ref_no;

    public static ArrayList<adPost> adPostListObj = new ArrayList<adPost>();

    public boolean isEntryCounter() {
        return entryCounter;
    }

    public void setEntryCounter(boolean entryCounter) {
        this.entryCounter = entryCounter;
    }

    public int getAdPost_ref_no() {
        return adPost_ref_no;
    }

    public void setAdPost_ref_no(int adPost_ref_no) {
        this.adPost_ref_no = adPost_ref_no;
    }

    public ArrayList<adPost> getAdPostListObj() {
        return adPostListObj;
    }

    public void setAdPostListObj(ArrayList<adPost> adPostListObj) {
        this.adPostListObj = adPostListObj;
    }

    public adPost() {
        this.entryCounter = true;
        makeemptyvar();
    }

    public adPost(String adPost_firstName, String adPost_lastName, String adPost_street,
            String adPost_city, String adPost_province, String adPost_country,
            String adPost_pincode, String adPost_email, String adPost_contact,
            String adPost_ad_title, String adPost_ad_des, String adPost_category, int adPost_ref_no,String adPost_file_path) {
        this.adPost_firstName = adPost_firstName;
        this.adPost_lastName = adPost_lastName;
        this.adPost_street = adPost_street;
        this.adPost_city = adPost_city;
        this.adPost_province = adPost_province;
        this.adPost_country = adPost_country;
        this.adPost_pincode = adPost_pincode;
        this.adPost_email = adPost_email;
        this.adPost_contact = adPost_contact;
        this.adPost_ad_title = adPost_ad_title;
        this.adPost_ad_des = adPost_ad_des;
        this.adPost_category = adPost_category;
        this.adPost_ref_no = adPost_ref_no;
        this.adPost_file_path=adPost_file_path;
        this.entryCounter = true;
        //this.adPost_username= adPost_username;
    }

    public void makeemptyvar() {
        this.adPost_firstName = "";
        adPost_lastName = "";
        adPost_street = "";
        adPost_city = "";
        adPost_province = "";
        adPost_country = "";
        adPost_pincode = "";
        adPost_email = "";
        adPost_contact = "";
        adPost_ad_title = "";
        adPost_ad_des = "";
        adPost_file_path = "";
        adPost_category = "";
        adPost_file_path="";

        this.adPost_firstName_errmsg = "";
        this.adPost_lastName_errmsg = "";
        this.adPost_street_errmsg = "";
        this.adPost_city_errmsg = "";
        this.adPost_province_errmsg = "";
        this.adPost_country_errmsg = "";
        this.adPost_pincode_errmsg = "";
        this.adPost_email_errmsg = "";
        this.adPost_contact_errmsg = "";
        this.adPost_ad_title_errmsg = "";
        this.adPost_ad_des_errmsg = "";
        this.adPost_category_errmsg = "";
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getAdPost_category() {
        return adPost_category;
    }

    public void setAdPost_category(String adPost_category) {
        this.adPost_category = adPost_category;
    }

    public String getAdPost_file_path() {
        return adPost_file_path;
    }

    public void setAdPost_file_path(String adPost_file_path) {
        this.adPost_file_path = adPost_file_path;
    }

    public String getAdPost_firstName() {
        return adPost_firstName;
    }

    public void setAdPost_firstName(String adPost_firstName) {
        this.adPost_firstName = adPost_firstName;
    }

    public String getAdPost_lastName() {
        return adPost_lastName;
    }

    public void setAdPost_lastName(String adPost_lastName) {
        this.adPost_lastName = adPost_lastName;
    }

    public String getAdPost_street() {
        return adPost_street;
    }

    public void setAdPost_street(String adPost_street) {
        this.adPost_street = adPost_street;
    }

    public String getAdPost_city() {
        return adPost_city;
    }

    public void setAdPost_city(String adPost_city) {
        this.adPost_city = adPost_city;
    }

    public String getAdPost_province() {
        return adPost_province;
    }

    public void setAdPost_province(String adPost_province) {
        this.adPost_province = adPost_province;
    }

    public String getAdPost_country() {
        return adPost_country;
    }

    public void setAdPost_country(String adPost_country) {
        this.adPost_country = adPost_country;
    }

    public String getAdPost_pincode() {
        return adPost_pincode;
    }

    public void setAdPost_pincode(String adPost_pincode) {
        this.adPost_pincode = adPost_pincode;
    }

    public String getAdPost_email() {
        return adPost_email;
    }

    public void setAdPost_email(String adPost_email) {
        this.adPost_email = adPost_email;
    }

    public String getAdPost_contact() {
        return adPost_contact;
    }

    public void setAdPost_contact(String adPost_contact) {
        this.adPost_contact = adPost_contact;
    }

    public String getAdPost_ad_title() {
        return adPost_ad_title;
    }

    public void setAdPost_ad_title(String adPost_ad_title) {
        this.adPost_ad_title = adPost_ad_title;
    }

    public String getAdPost_ad_des() {
        return adPost_ad_des;
    }

    public void setAdPost_ad_des(String adPost_ad_des) {
        this.adPost_ad_des = adPost_ad_des;
    }

    public void upload() throws IOException {

///        file1.write("D:\\data\\"+getFilename(file1));
//        file2.write("D:\\data\\"+getFilename(file2));
        InputStream inputStream = file.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\HACKER\\Desktop\\hhhh\\SELLME\\web\\images\\" + getFilename(file));
        adPost_file_path = getFilename(file);
        byte[] buffer = new byte[4096];
        int bytesRead = 0;
        while (true) {
            bytesRead = inputStream.read(buffer);
            if (bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            } else {
                break;
            }
        }
        outputStream.close();
        inputStream.close();

    }

     private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }

        return null;
    }

    public void validation() {

        this.validationCheck = true;

        this.adPost_firstName_errmsg = "";
        this.adPost_lastName_errmsg = "";
        this.adPost_street_errmsg = "";
        this.adPost_city_errmsg = "";
        this.adPost_province_errmsg = "";
        this.adPost_country_errmsg = "";
        this.adPost_pincode_errmsg = "";
        this.adPost_email_errmsg = "";
        this.adPost_contact_errmsg = "";
        this.adPost_ad_title_errmsg = "";
        this.adPost_ad_des_errmsg = "";
        this.adPost_category_errmsg = "";

        if (adPost_firstName.isEmpty()) {
            validationCheck = false;
            this.adPost_firstName_errmsg="*First Name Shouldnot be Empty";

        }
        if (adPost_lastName.isEmpty()) {
            validationCheck = false;
            this.adPost_lastName_errmsg ="*Last Name Shouldnot be Empty";

        }
        if (adPost_street.isEmpty()) {
            validationCheck = false;
            this.adPost_street_errmsg="*Street Shouldnot be Empty";

        }
        if (adPost_city.isEmpty()) {
            validationCheck = false;
            this.adPost_city_errmsg="*City Shouldnot be Empty";

        }
        if (adPost_province.isEmpty()) {
            validationCheck = false;
            this.adPost_province_errmsg="*Province Shouldnot be Empty";

        }
        if (adPost_country.isEmpty()) {
            validationCheck = false;
            this.adPost_country_errmsg="*Country Shouldnot be Empty";

        }
        if (adPost_pincode.isEmpty()) {
            validationCheck = false;
            this.adPost_pincode_errmsg="*Pincode Shouldnot be Empty";

        }
        if (adPost_email.isEmpty()) {
            validationCheck = false;
            this.adPost_email_errmsg="*Email Shouldnot be Empty";

        }
        if (adPost_contact.isEmpty()) {
            validationCheck = false;
            this.adPost_contact_errmsg="*Contact Shouldnot be Empty";

        }
        if (adPost_ad_title.isEmpty()) {
            validationCheck = false;
            this.adPost_ad_title_errmsg="*Add Title Shouldnot be Empty";

        }
        if (adPost_ad_des.isEmpty()) {
            validationCheck = false;
            this.adPost_ad_des_errmsg="*Add Description Shouldnot be Empty";

        }
        if (adPost_category.isEmpty()) {
            validationCheck = false;
            this.adPost_category_errmsg="*Add Category Shouldnot be Empty";

        }
    }

    public String insertedData() {
        
        
        this.validationCheck = true;
        validation();
        //ALTER TABLE owner ADD own_refno INT NOT NULL AUTO_INCREMENT PRIMARY KEY;

        if (validationCheck == true) {
            Connection conn;
            try {
                conn = Connect.getConnection();
                String sql = "Insert into owner Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, adPost_firstName);
                pstmt.setString(2, adPost_lastName);
                pstmt.setString(3, adPost_street);
                pstmt.setString(4, adPost_city);
                pstmt.setString(5, adPost_province);
                pstmt.setString(6, adPost_country);
                pstmt.setString(7, adPost_pincode);
                pstmt.setString(8, adPost_email);
                pstmt.setString(9, adPost_contact);
                pstmt.setString(10, adPost_ad_title);
                pstmt.setString(11, adPost_ad_des);
                pstmt.setString(12, adPost_file_path);
                pstmt.setString(13, Login.User_session); //email
                pstmt.setString(14, adPost_category);
                pstmt.setInt(15, x);
                pstmt.executeUpdate();
                makeemptyvar();
                Login.counterFunction();
                insertList();

                return "welcome";
            } catch (SQLException ex) {
                Logger.getLogger(adPost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "";
    }

    public void insertList() {

        String selectSqlsecond = "SELECT * FROM owner where own_username=? order by own_refno";
        this.entryCounter = true;
        try (Connection conn = Connect.getConnection()) {

            PreparedStatement smtSecond = conn.prepareStatement(selectSqlsecond);
            smtSecond.setString(1, Login.User_session);
            ResultSet rssecond = smtSecond.executeQuery();
            adPostListObj.clear();
            while (rssecond.next()) {
                adPost postObj = new adPost(
                        rssecond.getString("own_firstName"),
                        rssecond.getString("own_lastName"),
                        rssecond.getString("own_street"),
                        rssecond.getString("own_city"),
                        rssecond.getString("own_province"),
                        rssecond.getString("own_country"),
                        rssecond.getString("own_pincode"),
                        rssecond.getString("own_email"),
                        rssecond.getString("own_contact"),
                        rssecond.getString("own_ad_title"),
                        rssecond.getString("own_ad_des"),
                        rssecond.getString("own_category"),
                        rssecond.getInt("own_refno"),
                        rssecond.getString("own_file_path")
                );
                adPostListObj.add(postObj);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String deleteList(adPost or) {

        Connection conn;
        try {
            conn = Connect.getConnection();
            String selectSqldelete = "DELETE FROM owner where own_username=? AND own_refno=? ";
            PreparedStatement pstmt = conn.prepareStatement(selectSqldelete);
            pstmt.setString(1, Login.User_session);
            pstmt.setInt(2, or.adPost_ref_no);
            pstmt.executeUpdate();
            insertList();
            return "welcome";

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        // adPostListObj.remove(or);
        return "";
    }

    public String editList(adPost or) {

        String selectSqlsecond = "SELECT * FROM owner where own_username=? AND own_refno=? order by own_refno";

        try (Connection conn = Connect.getConnection()) {

            PreparedStatement smtSecond = conn.prepareStatement(selectSqlsecond);
            smtSecond.setString(1, Login.User_session);
            smtSecond.setInt(2, or.adPost_ref_no);
            ResultSet rssecond = smtSecond.executeQuery();
            adPostListObj.clear();
            makeemptyvar();
            while (rssecond.next()) {
                this.adPost_firstName = rssecond.getString("own_firstName");
                this.adPost_lastName = rssecond.getString("own_lastName");
                this.adPost_street = rssecond.getString("own_street");
                this.adPost_city = rssecond.getString("own_city");
                this.adPost_province = rssecond.getString("own_province");
                this.adPost_country = rssecond.getString("own_country");
                this.adPost_pincode = rssecond.getString("own_pincode");
                this.adPost_email = rssecond.getString("own_email");
                this.adPost_contact = rssecond.getString("own_contact");
                this.adPost_ad_title = rssecond.getString("own_ad_title");
                this.adPost_ad_des = rssecond.getString("own_ad_des");
                this.adPost_category = rssecond.getString("own_category");
                this.adPost_ref_no = rssecond.getInt("own_refno");
                this.adPost_file_path=rssecond.getString("own_file_path");
                Login.User_session = rssecond.getString("own_username");
            }
            entryCounter = false;
            return "adPost";

        } catch (SQLException ex) {
            Logger.getLogger(adPost.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public String updateList() {

        Connection conn;
        try {
            conn = Connect.getConnection();
            String selectSqldelete = "DELETE FROM owner where own_username=? AND own_refno=? ";
            PreparedStatement pstmt = conn.prepareStatement(selectSqldelete);
            pstmt.setString(1, Login.User_session);
            pstmt.setInt(2, this.adPost_ref_no);
            pstmt.executeUpdate();
            //insertedData();

            conn = Connect.getConnection();
            String sql = "Insert into owner Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1, adPost_firstName);
            pstmt1.setString(2, adPost_lastName);
            pstmt1.setString(3, adPost_street);
            pstmt1.setString(4, adPost_city);
            pstmt1.setString(5, adPost_province);
            pstmt1.setString(6, adPost_country);
            pstmt1.setString(7, adPost_pincode);
            pstmt1.setString(8, adPost_email);
            pstmt1.setString(9, adPost_contact);
            pstmt1.setString(10, adPost_ad_title);
            pstmt1.setString(11, adPost_ad_des);
            pstmt1.setString(12, adPost_file_path);
            pstmt1.setString(13, Login.User_session); //email
            pstmt1.setString(14, adPost_category);
            pstmt1.setInt(15, x);
            pstmt1.executeUpdate();
            makeemptyvar();
            Login.counterFunction();
            insertList();

            return "welcome";

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String returnfun()
    {
        makeemptyvar();
        return "adPost";
    }
    
    public String getListValue(adPost or) {

        String selectSqlsecond = "SELECT * FROM owner where own_username=? AND own_refno=? order by own_refno";

        try (Connection conn = Connect.getConnection()) {

            PreparedStatement smtSecond = conn.prepareStatement(selectSqlsecond);
            smtSecond.setString(1, Login.User_session);
            smtSecond.setInt(2, or.adPost_ref_no);
            ResultSet rssecond = smtSecond.executeQuery();
            //adPostListObj.clear();
            makeemptyvar();
            while (rssecond.next()) {
                this.adPost_firstName = rssecond.getString("own_firstName");
                this.adPost_lastName = rssecond.getString("own_lastName");
                this.adPost_street = rssecond.getString("own_street");
                this.adPost_city = rssecond.getString("own_city");
                this.adPost_province = rssecond.getString("own_province");
                this.adPost_country = rssecond.getString("own_country");
                this.adPost_pincode = rssecond.getString("own_pincode");
                this.adPost_email = rssecond.getString("own_email");
                this.adPost_contact = rssecond.getString("own_contact");
                this.adPost_ad_title = rssecond.getString("own_ad_title");
                this.adPost_ad_des = rssecond.getString("own_ad_des");
                this.adPost_category = rssecond.getString("own_category");
                this.adPost_ref_no = rssecond.getInt("own_refno");
                this.adPost_file_path=rssecond.getString("own_file_path");
                //Login.User_session=rssecond.getString("own_username");
            }

        } catch (SQLException ex) {
            Logger.getLogger(adPost.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";

    }

    public String getAdPost_firstName_errmsg() {
        return adPost_firstName_errmsg;
    }

    public void setAdPost_firstName_errmsg(String adPost_firstName_errmsg) {
        this.adPost_firstName_errmsg = adPost_firstName_errmsg;
    }

    public String getAdPost_lastName_errmsg() {
        return adPost_lastName_errmsg;
    }

    public void setAdPost_lastName_errmsg(String adPost_lastName_errmsg) {
        this.adPost_lastName_errmsg = adPost_lastName_errmsg;
    }

    public String getAdPost_street_errmsg() {
        return adPost_street_errmsg;
    }

    public void setAdPost_street_errmsg(String adPost_street_errmsg) {
        this.adPost_street_errmsg = adPost_street_errmsg;
    }

    public String getAdPost_city_errmsg() {
        return adPost_city_errmsg;
    }

    public void setAdPost_city_errmsg(String adPost_city_errmsg) {
        this.adPost_city_errmsg = adPost_city_errmsg;
    }

    public String getAdPost_province_errmsg() {
        return adPost_province_errmsg;
    }

    public void setAdPost_province_errmsg(String adPost_province_errmsg) {
        this.adPost_province_errmsg = adPost_province_errmsg;
    }

    public String getAdPost_country_errmsg() {
        return adPost_country_errmsg;
    }

    public void setAdPost_country_errmsg(String adPost_country_errmsg) {
        this.adPost_country_errmsg = adPost_country_errmsg;
    }

    public String getAdPost_pincode_errmsg() {
        return adPost_pincode_errmsg;
    }

    public void setAdPost_pincode_errmsg(String adPost_pincode_errmsg) {
        this.adPost_pincode_errmsg = adPost_pincode_errmsg;
    }

    public String getAdPost_email_errmsg() {
        return adPost_email_errmsg;
    }

    public void setAdPost_email_errmsg(String adPost_email_errmsg) {
        this.adPost_email_errmsg = adPost_email_errmsg;
    }

    public String getAdPost_contact_errmsg() {
        return adPost_contact_errmsg;
    }

    public void setAdPost_contact_errmsg(String adPost_contact_errmsg) {
        this.adPost_contact_errmsg = adPost_contact_errmsg;
    }

    public String getAdPost_ad_title_errmsg() {
        return adPost_ad_title_errmsg;
    }

    public void setAdPost_ad_title_errmsg(String adPost_ad_title_errmsg) {
        this.adPost_ad_title_errmsg = adPost_ad_title_errmsg;
    }

    public String getAdPost_ad_des_errmsg() {
        return adPost_ad_des_errmsg;
    }

    public void setAdPost_ad_des_errmsg(String adPost_ad_des_errmsg) {
        this.adPost_ad_des_errmsg = adPost_ad_des_errmsg;
    }

    public String getAdPost_category_errmsg() {
        return adPost_category_errmsg;
    }

    public void setAdPost_category_errmsg(String adPost_category_errmsg) {
        this.adPost_category_errmsg = adPost_category_errmsg;
    }

}
