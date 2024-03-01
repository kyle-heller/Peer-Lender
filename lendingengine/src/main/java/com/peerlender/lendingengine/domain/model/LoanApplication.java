package com.peerlender.lendingengine.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;

@Entity
public final class LoanApplication {
    @Id
    private long id;
    private final int amount;
    @ManyToOne
    private final User borrower;
    private final Duration repaymentTerm;
    private final double interestRate;

    public LoanApplication(int amount, Optional<User> borrower, Duration repaymentTerm, double interestRate) {
        this.amount = amount;
        this.borrower = borrower;
        this.repaymentTerm = repaymentTerm;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public User getBorrower() {
        return borrower;
    }

    public Duration getRepaymentTerm() {
        return repaymentTerm;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanApplication that = (LoanApplication) o;
        return amount == that.amount && Double.compare(interestRate, that.interestRate) == 0 && Objects.equals(borrower, that.borrower) && Objects.equals(repaymentTerm, that.repaymentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrower, repaymentTerm, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrower=" + borrower +
                ", repaymentTerm=" + repaymentTerm +
                ", interestRate=" + interestRate +
                '}';
    }
}
