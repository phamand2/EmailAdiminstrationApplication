package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();


        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);


        // Combine elements to generate email

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;

    }




    public String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQSTRVWXYZ0123456789!@#$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }


    public String setDepartment() {
        System.out.print("New Worker: " + firstName + ". DEPARTMENT CODES\n1 for Sales\n2 for Development \n3 for Accounting\n0 for none\nEnter department code");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();

        if(deptChoice == 1) return "sales";
        else if(deptChoice == 2) return "dev";
        else if(deptChoice == 3) return "acct";
        else return "";

    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password){
        this.password = password;

    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "Email{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", mailboxCapacity=" + mailboxCapacity +
                ", defaultPasswordLength=" + defaultPasswordLength +
                ", alternateEmail='" + alternateEmail + '\'' +
                ", companySuffix='" + companySuffix + '\'' +
                '}';
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nYOUR PASSWORD: " +password +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
