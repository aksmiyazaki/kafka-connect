package com.github.aksmiyazaki.validators;

import org.apache.kafka.common.config.ConfigException;
import org.junit.Test;

public class TimestampValidatorTest {

    @Test
    public void whenValueIsValid_thenItIsValidatedCorrectly() {
        TimestampValidator bsv = new TimestampValidator();
        bsv.ensureValid("dummy", "2022-02-21T07:00:00Z");
    }

    @Test(expected = ConfigException.class)
    public void whenValueIsNotATimestamp_thenItThrowsAnException() {
        TimestampValidator bsv = new TimestampValidator();
        bsv.ensureValid("dummy", "potato");
    }
}
