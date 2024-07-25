package com.github.yuizho;

import java.util.Optional;

public class VendingMachine {
    private State state;

    public VendingMachine() {
        this.state = new Default();
    }

    public void insertYen(Yen yen) {
        state = switch (state) {
            case InsertedYen(Yen insertedYen) -> new InsertedYen(insertedYen.plus(yen));
            default -> new InsertedYen(yen);
        };
    }

    public void cancel() {
        state = switch (state) {
            case InsertedYen(Yen paidAmount) -> new Canceled(paidAmount);
            default -> new Default();
        };
    }

    public void chooseDrink(Drink drink) {
        state = switch (state) {
            case InsertedYen(Yen paidAmount) when paidAmount.isGreaterThan(drink.getPrice()) ->
                    new Completed(drink, paidAmount.minus(drink.getPrice()));
            case InsertedYen(Yen paidAmount) when paidAmount.equals(drink.getPrice()) ->  new Completed(drink, new Yen(0));
            case InsertedYen(Yen paidAmount) -> state;
            default -> new Default();
        };
    }

    public Optional<Drink> getDrink() {
        return switch (state) {
            case Completed(Drink drink, Yen change) -> Optional.of(drink);
            default -> Optional.empty();
        };
    }

    public Optional<Yen> getChange() {
        return switch (state) {
            case Completed(Drink drink, Yen change) -> Optional.of(change);
            default -> Optional.empty();
        };
    }
}
