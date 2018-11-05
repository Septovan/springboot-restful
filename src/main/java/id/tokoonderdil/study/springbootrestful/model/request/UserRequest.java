package id.tokoonderdil.study.springbootrestful.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @NotNull(message = "First Name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must not greater than 50 char")
    private String lastName;

    @NotNull(message = "First Name cannot be null")
    @Email
    private String email;

    @NotNull(message = "First Name cannot be null")
    private Integer userId;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
