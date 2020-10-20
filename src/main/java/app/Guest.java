package app;

/*
 * Guess has a set of questions that can be presented to a person.
 * it also tracks the number of correct responses.
 * also tracks where in the quiz the person is at.
 */

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
    Date dob;
    String firsName;
    String lastName;
    String address;
    String status;

    public Guest(String id, String firsName, String lastName, Date dob, String address, String status) {
        this.id = id;
        this.dob = dob;
        this.firsName = firsName;
        this.lastName = lastName;
        this.address = address;
        this.status = status;
    }

    public Guest(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
