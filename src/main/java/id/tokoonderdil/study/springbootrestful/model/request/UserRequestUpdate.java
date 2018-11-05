package id.tokoonderdil.study.springbootrestful.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestUpdate {
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @NotNull(message = "First Name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must not greater than 50 char")
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
