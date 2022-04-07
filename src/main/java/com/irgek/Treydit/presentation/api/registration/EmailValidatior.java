package com.irgek.Treydit.presentation.api.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidatior  implements Predicate<String> {
    @Override
    public boolean test(String s) {
        // ToDO: Regex to validate email
        return true;
    }
}
