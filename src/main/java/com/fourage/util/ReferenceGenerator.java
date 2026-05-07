package com.fourage.util;

public class ReferenceGenerator {

    private static int compteur = 0;

    public static String genererReference() {
        compteur++;
        return String.format("REF-%04d", compteur);
    }
}