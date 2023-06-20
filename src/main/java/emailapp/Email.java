package emailapp;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "drain.com";

    //constructor for first and last name
    public Email (String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created "+ this.firstName + " " + this.lastName);

        //get department
        this.department =  setDepartment();
        System.out.println("Your Department is " + this.department);

        //generate password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("PASSWORD: "+ this.password);

        //generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@" + department + "." + companySuffix;

    }

    //Ask for department
    private String setDepartment(){
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        if (depChoice == 1){
            return "Sales";
        } else if (depChoice == 2){
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    //Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()1234567890";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set Alternate Email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change password
    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getPassword() {
        return password;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
