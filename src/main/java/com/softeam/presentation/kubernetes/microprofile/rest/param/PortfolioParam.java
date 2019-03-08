package com.softeam.presentation.kubernetes.microprofile.rest.param;

import com.softeam.presentation.kubernetes.microprofile.model.enums.Devise;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PortfolioParam {
    @Positive
    public int amount;
    @NotNull
    public Devise devise;
    @NotEmpty
    public String manager;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
