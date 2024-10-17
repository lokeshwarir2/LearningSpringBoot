package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value=0,message="must be greater than or equal to 0")
    @Max(value=10,message="must be less than or equal to 10")
    private Integer freePases;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 digits allowed")
    private String postalCode;
    @CourseCode(value = "RV",message = "should start with RV only")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "is required") @Size(min = 1, message = "is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "is required") @Size(min = 1, message = "is required") String lastName) {
        this.lastName = lastName;
    }

    public @NotNull(message = "is required") @Min(value = 0, message = "must be greater than or equal to 0") @Max(value = 10, message = "must be less than or equal to 10") Integer getFreePases() {
        return freePases;
    }

    public void setFreePases(@NotNull(message = "is required") @Min(value = 0, message = "must be greater than or equal to 0") @Max(value = 10, message = "must be less than or equal to 10") Integer freePases) {
        this.freePases = freePases;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits allowed") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits allowed") String postalCode) {
        this.postalCode = postalCode;
    }
}
