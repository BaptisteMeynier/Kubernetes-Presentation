package com.softeam.presentation.kubernetes.microprofile.model;

import com.softeam.presentation.kubernetes.microprofile.model.enums.Devise;

import java.util.Objects;

public class Portfolio {
    private long id;
    private int amount;
    private Devise devise;
    private String manager;

    private Portfolio() {
    }

    private Portfolio(long id, int amount, Devise devise, String manager) {
        this.id = id;
        this.amount = amount;
        this.devise = devise;
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Devise getDevise() {
        return devise;
    }

    public String getManager() {
        return manager;
    }

    public static IdStep builder() {
        return new Builder();
    }

    public interface IdStep {
        AmountStep setId(long id);
    }

    public interface AmountStep {
        DeviseStep setAmount(int amount);
    }

    public interface DeviseStep {
        ManagerStep setDevise(Devise devise);
    }

    public interface ManagerStep {
        Portfolio setManager(String manager);
    }

    private static class Builder implements IdStep, AmountStep, DeviseStep, ManagerStep {

        private long id;
        private int amount;
        private Devise devise;

        @Override
        public AmountStep setId(long id) {
            this.id = id;
            return this;
        }

        @Override
        public DeviseStep setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        @Override
        public ManagerStep setDevise(Devise devise) {
            this.devise = devise;
            return this;
        }

        @Override
        public Portfolio setManager(String manager) {
            return new Portfolio(id, amount, devise, manager);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return id == portfolio.id &&
                amount == portfolio.amount &&
                devise == portfolio.devise &&
                Objects.equals(manager, portfolio.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, devise, manager);
    }
}
