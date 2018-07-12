package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.fail;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_return_invaildate_when_createAnswer_input_is_inputStr() {
        actualAnswer = Answer.createAnswer("1 2 10 2");
        try {
            actualAnswer.validate();
            fail("it should be invaildate");
        } catch (AnswerFormatIncorrectException e) {
        }
    }
    @Test
    public void should_return_vaildate_when_createAnswer_input_is_inputStr() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
        try {
            actualAnswer.validate();

        } catch (AnswerFormatIncorrectException e) {
            fail("it should be vaildate");
        }
    }
    @Test
    public void should_return_Record_when_check_input_is_inputAnswer() {
        Answer actualAnswer1 = Answer.createAnswer("1 2 4 3");
        Answer actualAnswer2 = Answer.createAnswer("1 2 3 4");
        Record record = actualAnswer1.check( actualAnswer2 );
        assertThat(record.getValue(),is(String.format("2A2B")));
    }
    @Test
    public void should_return_String_when_toString_input_is_list() {
        actualAnswer = Answer.createAnswer("1 2 4 3");

        assertThat(actualAnswer.toString(),is("1 2 4 3"));
    }
    @Test
    public void should_return_num_when_getIndexOfNum_input_is_num() {
        actualAnswer = Answer.createAnswer("1 2 4 3");

        assertThat(actualAnswer.getIndexOfNum( "2" ),is(1));
    }

}