package com.developer.superuser.shared.enumeration;

public enum Currency {
    IDR("Indonesian Rupiah"),
    SGD("Singapore Dollar"),
    USD("US Dollar");

    public final String label;

    Currency(String label) {
        this.label = label;
    }
}