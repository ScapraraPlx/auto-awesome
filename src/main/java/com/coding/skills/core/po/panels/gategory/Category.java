package com.coding.skills.core.po.panels.gategory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    PHONES("Phones"),
    LAPTOPS("Laptops"),
    MONITORS("Monitors");

    private final String alias;
}
