package com.company.userappws.userappcrud.model.updateRequest;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequest {
    @NotNull(message = "first Name cannot be null")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    private String lastName;

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
}
