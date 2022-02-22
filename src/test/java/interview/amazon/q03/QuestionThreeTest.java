package interview.amazon.q03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static interview.amazon.q03.QuestionThree.maxSubarrayLength;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionThreeTest {

    @Test
    public void testQuestionThree(){
        List<Integer> badges = new ArrayList<>();
        badges.add(1);
        badges.add(-1);
        badges.add(-1);
        badges.add(-1);
        badges.add(1);
        badges.add(1);
        assertEquals(4,  maxSubarrayLength(badges));
    }

    @Test
    public void testQuestionThreeWithDifferenInput(){
        List<Integer> badges = new ArrayList<>();
        badges.add(1);
        badges.add(-1);
        badges.add(-1);
        badges.add(1);
        badges.add(1);
        badges.add(-1);
        assertEquals(5,  maxSubarrayLength(badges));
    }

}
