package com.cuandorindov2.errorhandling;

import com.cuandorindov2.main.errorhandling.BaseException;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tomaslingotti on 7/2/17.
 */
public class BaseExceptionTest {

    private static final String MESSAGE = "NOT_FOUND";

    @Test
    public void testBaseExceptionBuilder_shouldReturnGivenMsg() {
        BaseException be = new BaseException.BaseExceptionBuilder(MESSAGE).build();
        Assert.assertThat(be.getMessage(), Is.is(MESSAGE));
    }

    @Test
    public void shouldReturnMessageAndStatus() {
        BaseException be = new BaseException.BaseExceptionBuilder(MESSAGE).status(404).build();

        Assert.assertThat(be.getMessage(), Is.is(MESSAGE));
        Assert.assertThat(be.getStatus(), Is.is(404));
    }



}
