/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author c0663421
 */
@Named
@ManagedBean

public class HomePage {

    String firstName = "", lastName = "", email = "", emailConfirm = "", password = "", passwordConfirm = "", securityQues = "", securityAnswer = "";
    String userNameerr = "", firstNameErr = "", lastNameErr = "", emailErr = "", emailConfirmErr = "", passwordErr = "", passwordConfirmErr = "", securityQuesErr = "", securityAnswerErr = "";

    boolean Valid = false;

    public void Homepage() {
        Valid = false;
    }

    public String getUserNameerr() {
        return userNameerr;
    }

    public void setUserNameerr(String userNameerr) {
        this.userNameerr = userNameerr;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(String emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getSecurityQues() {
        return securityQues;
    }

    public void setSecurityQues(String securityQues) {
        this.securityQues = securityQues;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getFirstNameErr() {
        return firstNameErr;
    }

    public void setFirstNameErr(String firstNameErr) {
        this.firstNameErr = firstNameErr;
    }

    public String getLastNameErr() {
        return lastNameErr;
    }

    public void setLastNameErr(String lastNameErr) {
        this.lastNameErr = lastNameErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getEmailConfirmErr() {
        return emailConfirmErr;
    }

    public void setEmailConfirmErr(String emailConfirmErr) {
        this.emailConfirmErr = emailConfirmErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getPasswordConfirmErr() {
        return passwordConfirmErr;
    }

    public void setPasswordConfirmErr(String passwordConfirmErr) {
        this.passwordConfirmErr = passwordConfirmErr;
    }

    public String getSecurityQuesErr() {
        return securityQuesErr;
    }

    public void setSecurityQuesErr(String securityQuesErr) {
        this.securityQuesErr = securityQuesErr;
    }

    public String getSecurityAnswerErr() {
        return securityAnswerErr;
    }

    public void setSecurityAnswerErr(String securityAnswerErr) {
        this.securityAnswerErr = securityAnswerErr;
    }

    public void getUsersFromDB() {
        Valid = false;
        String selectSql = "SELECT * FROM user WHERE email=?";
        try (Connection conn = Connect.getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(selectSql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Valid = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void makeEmpty() {
        firstName = "";
        lastName = "";
        email = "";
        password = "";
        securityQues = "";
        securityAnswer = "";
        emailConfirm = "";

        userNameerr = "";

        firstNameErr = "";
        lastNameErr = "";
        emailErr = "";
        emailConfirmErr = "";
        passwordErr = "";
        passwordConfirmErr = "";
        securityQuesErr = "";
        securityAnswerErr = "";

    }

    public String doValidation() {

        getUsersFromDB();

        if (Valid == true) {
            userNameerr = "User Name Already Exists please select different Username or Email";
        } else {
            userNameerr = "";
        }

        if (firstName.isEmpty() || (lastName.isEmpty()) || email.isEmpty()
                || emailConfirm.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()
                || securityQues.isEmpty() || securityAnswer.isEmpty() || (!(email.equals(emailConfirm)))
                || (!(password.equals(passwordConfirm)))) {

            if (firstName.isEmpty()) {
                firstNameErr = "* First Name Should not be Empty";
            } else {
                firstNameErr = "";
            }

            if (lastName.isEmpty()) {
                lastNameErr = "* Last Name Should not be Empty";
            } else {
                lastNameErr = "";
            }

            if (email.isEmpty()) {
                emailErr = "* Email Should not be Empty";
            } else {
                emailErr = "";
            }

            if (password.isEmpty()) {
                passwordErr = "* Password Should not be Empty";
            } else {
                passwordErr = "";
            }

            if (securityAnswer.isEmpty()) {
                securityAnswerErr = "* Answer Should not be Empty";
            } else {
                securityAnswerErr = "";
            }

            if (!(email.equals(emailConfirm))) {
                emailConfirmErr = "* Email should match";
            } else {
                emailConfirmErr = "";
            }

            if (!(password.equals(passwordConfirm))) {
                passwordConfirmErr = "* Password should match";
            } else {
                passwordConfirmErr = "";
            }

        } else {
            getUsersFromDB();

            if (Valid == false) {
                userNameerr = "";
                savePost(firstName, lastName, email, password, securityQues, securityAnswer);
                makeEmpty();
                return "index";
            } else {
                userNameerr = "User Name Already Exists please select different Username or Email";

            }

        }

        return "register";
    }

    public void savePost(String firstName, String lastName, String email, String password, String securityQues, String securityAnswer) {

        Connection conn;
        try {

            conn = Connect.getConnection();
            String sql = "Insert into user Values(?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setString(5, securityQues);
            pstmt.setString(6, securityAnswer);
            pstmt.executeUpdate();
            makeEmpty();

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
