package com.github.fabriciolfj.shoppingcart.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Status {

    APPROVED("approved"), PENDING("pending"), DISAPPROVED("disapproved"), PRE_APPROVED("pre_approved");

    private final String describe;

    public static Status toEnum(final String describe) {
        return Stream.of(Status.values())
                .filter(status -> status.getDescribe().equalsIgnoreCase(describe))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Enum not found: " + describe));
    }
}
