package com.example.demo.websecurity;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by hello on 2018/4/4.
 */
public class MyEncode implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
