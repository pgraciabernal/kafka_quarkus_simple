package org.pedrogracia.util;

import org.apache.commons.lang3.RandomStringUtils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Utilities {

    public String getRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

}
