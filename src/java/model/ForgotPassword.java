/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author surya
 */
@Named
@SessionScoped
@ManagedBean
public class ForgotPassword {
    
    String fmail="";
    String fmailErr="";
    String fmaildb="",fsecurityques="", fsecurityans="", fsecurityansdb="", fsecurityanSErr="";

    public String getFsecurityques() {
        return fsecurityques;
    }

    public void setFsecurityques(String fsecurityques) {
        this.fsecurityques = fsecurityques;
    }

    
    
    public String getFmail() {
        return fmail;
    }

    public void setFmail(String fmail) {
        this.fmail = fmail;
    }

    public String getFmailErr() {
        return fmailErr;
    }

    public void setFmailErr(String fmailErr) {
        this.fmailErr = fmailErr;
    }

    public String getFsecurityans() {
        return fsecurityans;
    }

    public void setFsecurityans(String fsecurityans) {
        this.fsecurityans = fsecurityans;
    }

    
    
    
    public String checkMail(){
        if(fmail.isEmpty()){
            fmailErr = "*Email Id should not be empty";
        } 
        else{
            

            String selectSql = "SELECT * FROM user WHERE email=?";
        try (Connection conn = Connect.getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(selectSql);
            pstmt.setString(1, fmail);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                fmaildb= rs.getString("email");
                fsecurityques=rs.getString("securityQues");
                fsecurityansdb = rs.getString("securityAnswer");
                Login.User_session=fmaildb;
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if(fmaildb.equals(fmail)) {
            fsecurityans="";
            fsecurityanSErr="";
            fmailErr="";
             return "passwordRecoveryMain";
             
        } 
        else{
            fmailErr = "*Username is not registered";
            fmaildb="";
            fsecurityques="";
            return "passwordRecovery";
        } 
        
        
  } 
        return "passwordRecovery";
    } 

    public String getFsecurityanSErr() {
        return fsecurityanSErr;
    }

    public void setFsecurityanSErr(String fsecurityanSErr) {
        this.fsecurityanSErr = fsecurityanSErr;
    }
    
    public String checkSecQue(){

         if(fmail.isEmpty())
        {
            fmailErr = "*Email Id should not be empty";
        } 
        else
         {
            
             if(fsecurityans.isEmpty()) 
        {
            fsecurityanSErr="*Answer should not be empty";
        } 
        else
        {
            if(fsecurityans.equals(fsecurityansdb)) 
            {
                getPostsFromDB();
                return "welcome";
            } 
            else
            {
                fsecurityanSErr="*Incorrect Answer";
            }
        }
    }
     return "passwordRecoveryMain";
    }
    
    
    private void getPostsFromDB() 
   {
        String selectSqlsecond = "SELECT * FROM owner where own_username=? order by own_refno";
         //this.entryCounter=true;
        try (Connection conn = Connect.getConnection()) {

            PreparedStatement smtSecond = conn.prepareStatement(selectSqlsecond);
            smtSecond.setString(1, Login.User_session);
            ResultSet rssecond = smtSecond.executeQuery();
            adPost.adPostListObj.clear();
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
                adPost.adPostListObj.add(postObj);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
