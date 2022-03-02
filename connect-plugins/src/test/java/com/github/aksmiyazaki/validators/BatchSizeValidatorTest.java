package com.github.aksmiyazaki.validators;

import org.apache.kafka.common.config.ConfigException;
import org.junit.Test;


public class BatchSizeValidatorTest {

    @Test
    public void whenValueIsValid_thenItIsValidatedCorrectly() {
        BatchSizeValidator bsv = new BatchSizeValidator();
        bsv.ensureValid("dummy", 1);
        bsv.ensureValid("dummy", 100);
    }

    @Test(expected = ConfigException.class)
    public void whenValueIsLowerThanThreshold_thenItThrowsException() {
        BatchSizeValidator bsv = new BatchSizeValidator();
        bsv.ensureValid("dummy", 0);
    }

    @Test(expected = ConfigException.class)
    public void whenValueIsBiggerThanThreshold_thenItThrowsException() {
        BatchSizeValidator bsv = new BatchSizeValidator();
        bsv.ensureValid("dummy", 101);
    }
}
