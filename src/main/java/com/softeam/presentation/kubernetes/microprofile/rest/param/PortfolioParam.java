package com.softeam.presentation.kubernetes.microprofile.rest.param;

import com.softeam.presentation.kubernetes.microprofile.model.enums.Devise;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PortfolioParam {
    @Positive
    public int amount;
    @NotNull
    public Devise devise;
    @NotEmpty
    public String manager;
}
