package com.github.yuizho;

sealed interface State permits InsertedYen, Completed, Default, Canceled {
}

record Default() implements State {
    @Override
    public String toString() {
        return "デフォルト状態";
    }
}

record InsertedYen(Yen paidAmount) implements State {
    @Override
    public String toString() {
        return "金額投入済み(投入金額: " + paidAmount + ")";
    }
}

record Canceled(Yen paidAmount) implements State {
    @Override
    public String toString() {
        return "キャンセル済み(返却金額: " + paidAmount + ")";
    }
}

record Completed(Drink drink, Yen change) implements State {
    @Override
    public String toString() {
        return "購入完了(購入されたドリンク: " + drink + ", お釣り: " + change + ")";
    }
}
