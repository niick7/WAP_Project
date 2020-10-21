package miu.hotel.model;

/*
 * Guess has a set of questions that can be presented to a person.
 * it also tracks the number of correct responses.
 * also tracks where in the quiz the person is at.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author levi
 * @since 110114
 */
public class Guest {
    String id;
    LocalDate dob;
    String firstName;
    String lastName;
    String address;
    String gender;
    LocalDate createdDate;


    public Guest(String id, String firstName, String lastName, LocalDate dob, String address, String gender) {
        this.id = id;
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.createdDate=LocalDate.now();
//        this.createdMonth=LocalDate.now().getDayOfMonth();
//        this.createdYear=LocalDate.now().getYear();
//        this.cretedDay=LocalDate.now().getMonthValue();

    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }


//
//    public LocalDate getCreatedMonth() {
//        return createdDate;
//    }
//
//    public void setCreatedMonth(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public int getCreatedYear() {
//        return createdYear;
//    }
//
//    public void setCreatedYear(int createdYear) {
//        this.createdYear = createdYear;
//    }
//
//    public int getCretedDay() {
//        return cretedDay;
//    }
//
//    public void setCretedDay(int cretedDay) {
//        this.cretedDay = cretedDay;
//    }
//
//    int createdYear;
//    int cretedDay;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }







    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getFirsName() {
        return firstName;
    }

    public void setFirsName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String status) {
        this.gender = gender;
    }
}
