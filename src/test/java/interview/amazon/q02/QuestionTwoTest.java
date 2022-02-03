package interview.amazon.q02;

import org.junit.jupiter.api.Test;

import static interview.amazon.q02.QuestionTwo.solution;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTwoTest {

    @Test
    public void testQuestionTwo(){
        assertEquals(1,  solution("aabb"));
        assertEquals(2,  solution("bbacccabab"));
        assertEquals(0,  solution("aaaa"));
        assertEquals(0,  solution("a"));
        assertEquals(0,  solution(""));
    }

    @Test
    public void testQuestionTwoWithNullParam(){
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> solution(null));
        assertTrue(thrown.getMessage().contains("Input can not be null"));
    }
}
