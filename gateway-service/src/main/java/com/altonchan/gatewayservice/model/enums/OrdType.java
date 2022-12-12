package com.altonchan.gatewayservice.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum OrdType {
    MARKET("1"),
    LIMIT("2"),
    STOP("3"),
    STOP_LIMIT("4"),
    WITH_OR_WITHOUT("6"),
    LIMIT_OR_BETTER("7"),
    LIMIT_WITH_OR_WITHOUT("8"),
    ON_BASIS("9"),
    PREVIOUSLY_QUOTED("D"),
    PREVIOUSLY_INDICATED("E"),
    FOREX_SWAP("G"),
    FUNARI("I"),
    MIT("J"),
    MARKET_WITH_LEFTOVER_AS_LIMIT("K"),
    PREVIOUS_FUND_VALUATION_POINT("L"),
    NEXT_FUND_VALUATION_POINT("M"),
    PEGGED("P");

    public final String code;

    private OrdType(String code) {
        this.code = code;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OrdType decode(final String code) {
        return Stream.of(OrdType.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }
}
