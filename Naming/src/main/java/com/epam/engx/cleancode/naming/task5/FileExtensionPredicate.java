package com.epam.engx.cleancode.naming.task5;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtensionPredicate implements Predicate<String> {

    private String[] extensions;

    FileExtensionPredicate(String[] extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean test(String fileName) {
        for (String e : extensions) {
            if (fileName.toLowerCase().endsWith(e)) {
                return true;
            }
        }
        return false;
    }
}
