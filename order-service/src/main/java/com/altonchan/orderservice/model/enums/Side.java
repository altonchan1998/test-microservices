package com.altonchan.orderservice.model.enums;

public enum Side {
    BUY("1"),
    Sell("2"),
    BUY_MINUS("3"),
    SELL_SHORT("4"),
    SELL_SHORT_EXEMPT("6"),
    UNDISCLOSED("7"),
    CROSS("8"),
    CROSS_SHORT("9"),
    CROSS_SHORT_EXEMPT("A"),
    AS_DEFINED("B"),
    OPPOSITE("C"),
    SUBSCRIBE("D"),
    REDEEM("E"),
    LEND("F"),
    FOREX_SWAP("G");

    public final String value;

    private Side(String value) {
        this.value = value;
    }
}
