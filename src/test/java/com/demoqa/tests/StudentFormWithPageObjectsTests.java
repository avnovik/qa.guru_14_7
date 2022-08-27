package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentFormWithPageObjectsTests extends TestBaseConfig {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    String firstname,
            lastName,
            email,
            gender,
            mobileNumber,
            dayOfBirth,
            monthBirthday,
            yearBirthday,
            subject,
            hobby,
            currentAddress;
//            state,
    //          city;

    /*
            picture

    */
    @BeforeEach
    void prepareTestData() {
        firstname = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        gender = TestData.getGenderRandom();
        mobileNumber = faker.phoneNumber().subscriberNumber(10);           // 10 Digits
        dayOfBirth = TestData.getDayOfBirth();
        monthBirthday = TestData.getMonthOfBirth();
        yearBirthday = faker.number().numberBetween(1940, 2022) + "";
        subject = TestData.getSubjectsRandom();
        hobby = TestData.getRandomHobby();
        currentAddress = faker.address().fullAddress();
    }


    @Test
    void fillFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setEmailInput(email)
                .setGender(TestData.getGenderRandom())
                .setMobileNumber(mobileNumber)
                .setBirthDay(dayOfBirth, monthBirthday, yearBirthday)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(TestData.sourcePicture)
                .setAddress(currentAddress)
                .setState(TestData.userState)
                .setCity(TestData.userCity)
                .submitForm()

                .checkResultsTableVisible()
                .checkResultsTable("Student Name", firstname + " " + lastName)
                .checkResultsTable("Student Email", email)
                .checkResultsTable("Gender", gender)
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
