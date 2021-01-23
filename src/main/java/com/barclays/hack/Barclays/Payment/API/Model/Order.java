package com.barclays.hack.Barclays.Payment.API.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import javax.validation.constraints.*;

@ApiModel
public class Order {

    /**
     * The amount.
     */
    @ApiModelProperty(name="Cart value",required = true)
    @NotBlank(message = "Amount can't be blank")
    @NotNull(message = "Amount can't be null")
    @Min(value = 10, message = "Amount should not be less than 10")
    private Double amount;

    /**
     * The name.
     */
    @ApiModelProperty(name="Name of the Payee",required = true)
    @NotBlank(message = "name shouldn't be blank")
    @NotNull(message = "name shouldn't be null")
    private String name;

    /**
     * The email.
     */
    @ApiModelProperty(name="Email of the Payee",required = true)
    @NotBlank(message = "Email shouldn't be blank")
    @NotNull(message = "Email should not be null")
    @Email(message = "Email should be valid")
    private String email;

    /**
     * The phone.
     */
    @ApiModelProperty(name="Email of the Payee",required = true)
    @NotBlank(message = "Phone number cannot be blank")
    @NotNull(message = "Phone number cannot be null")
    @Size(min=10,max = 10,message = "10 Digit Phone Number Required")
    private String phone;

    /**
     * The description.
     */
    @ApiModelProperty(name="Description of the Order",required = true)
    @NotBlank
    @NotNull
    private String description;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
