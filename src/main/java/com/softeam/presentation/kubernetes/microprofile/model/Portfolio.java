package com.softeam.presentation.kubernetes.microprofile.model;

import com.softeam.presentation.kubernetes.microprofile.model.enums.Devise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Portfolio {
    private Long id;
  /*  @XmlElement(
            name = "amount",
            required = true,
            nillable = false
    )*/
    private int amount;
    private Devise devise;
    private String manager;

    private Portfolio() {
    }

    private Portfolio(Long id, int amount, Devise devise, String manager) {
        this.id = id;
        this.amount = amount;
        this.devise = devise;
        this.manager = manager;
    }

    public Long getId() {
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

    public static InitStep builder() {
        return new Builder();
    }

    public interface InitStep {
        AmountStep setId(Long id);
        DeviseStep setAmount(int amount);
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

    private static class Builder implements InitStep, AmountStep, DeviseStep, ManagerStep {

        private long id;
        private int amount;
        private Devise devise;

        @Override
        public AmountStep setId(Long id) {
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
        return amount == portfolio.amount &&
                Objects.equals(id, portfolio.id) &&
                devise == portfolio.devise &&
                Objects.equals(manager, portfolio.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, devise, manager);
    }
}
