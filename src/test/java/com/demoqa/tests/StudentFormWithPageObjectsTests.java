package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1200x800";
    }

    @Test
    void fillFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName("James")
                .setLastName("Bond")
                .setEmailInput("jb@007.gb")
                .setGender("Other")
                .setMobileNumber("0123456789")
                .setBirthDay("21", "July", "2010")
                .setSubjects("A")
                .setSubjects("ar")
                .setHobbies("Music")
                .uploadPicture("pictures/Picture.pic")
                .setAddress("Wellington Square, 25")
                .setState("ha")
                .setCity("k")
                .submitForm()
                .checkResultsTableVisible()
                .checkResultsTable("Student Name", "Bond")
                .checkResultsTable("Student Email", "jb@007.gb")
                .checkResultsTable("Gender", "Other")
                .checkResultsTable("Mobile", "0123456789")
                .checkResultsTable("Date of Birth", "21 July,2010")
                .checkResultsTable("Subjects", "Maths, Arts")
                .checkResultsTable("Hobbies", "Music")
                .checkResultsTable("Picture", "Picture.pic")
                .checkResultsTable("Address", "Wellington Square, 25")
                .checkResultsTable("State and City", "Haryana Karnal")
                .checkResultsTableIsClose();
    }
}
