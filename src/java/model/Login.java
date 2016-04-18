/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author c0663421
 */
@Named
@ManagedBean
@SessionScoped

public class Login implements Serializable {

    String fname;
    String lname;
    String email;
    String pswd;
    String loginUsername, loginPassword = "", usernameerr = "", passworderr = "";

    public static String User_session, counter = "0";

    public Login() {
        returnIndex();
        usernameerr = "";
        passworderr = "";
    }

    public String returnIndex() {
        if ((Login.User_session == null) || (Login.User_session.equals(""))) {
            return "index";
        }

        return "";
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String LoginPassword) {
        this.loginPassword = LoginPassword;
    }

    public String getUsernameerr() {
        return usernameerr;
    }

    public void setUsernameerr(String usernameerr) {
        this.usernameerr = usernameerr;
    }

    public String getPassworderr() {
        return passworderr;
    }

    public void setPassworderr(String passworderr) {
        this.passworderr = passworderr;
    }

    public String setLogindb() {

        usernameerr="";
        passworderr="";
        
        if ((loginUsername.isEmpty()) || (loginPassword.isEmpty())) {
            if (loginUsername.isEmpty()) {
                usernameerr = "*Username should not be empty";
                loginUsername = "";
            }
            if (loginPassword.isEmpty()) {
                passworderr = "*Password should not be empty";
                loginPassword = "";
            }
        } else {

            String selectSql = "SELECT firstname,lastname,email,password FROM user where email=?";

            try (Connection conn = Connect.getConnection()) {

                PreparedStatement pstmt = conn.prepareStatement(selectSql);
                pstmt.setString(1, loginUsername);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    fname = rs.getString("firstname");
                    lname = rs.getString("lastname");
                    email = rs.getString("email");
                    pswd = rs.getString("password");
                }

                if (loginUsername.equals(email) && loginPassword.equals(pswd)) {
                    User_session = loginUsername;
                    counterFunction();
                    getPostsFromDB();
                    //adPost.setAdPostListObj(adPostListObj_second);
                    usernameerr = "";
                    passworderr = "";
                    return "welcome";
                } else {
                    if (!(loginUsername.equals(email))) {
                        usernameerr = "*Incorrect Username";
                    }
                    if (!(loginPassword.equals(pswd))) {
                        passworderr = "*Incorrect password";
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                // This Fails Silently -- Sets Post List as Empty

            }
        }

        return "index";
    }

    private void getPostsFromDB() {
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

    public void makeEmpty() {
        this.fname = "";
        this.lname = "";
        this.email = "";
        this.pswd = "";
        this.loginUsername = "";
        this.loginPassword = "";
    }

    public String loginLogOut() {
        makeEmpty();
        Login.User_session = "";
        return "index.xhtml";

    }

    public static void counterFunction() {
        String selectSqlsecond = "SELECT count(*) as countRecord FROM owner where owner_username=?";

        try (Connection conn = Connect.getConnection()) {

            PreparedStatement smtSecond = conn.prepareStatement(selectSqlsecond);
            smtSecond.setString(1, Login.User_session);
            ResultSet rssecond = smtSecond.executeQuery();
            while (rssecond.next()) {
                counter = rssecond.getString("countRecord");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
