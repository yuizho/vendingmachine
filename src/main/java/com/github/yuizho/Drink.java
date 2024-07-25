package com.github.yuizho;

public enum Drink {
    ファンタ(120),
    爽健美茶(200),
    コーラ(100);

    Drink(int price) {
        this.price = price;
    }

    private int price;

    public Yen getPrice() {
        return new Yen(price);
    }
}

