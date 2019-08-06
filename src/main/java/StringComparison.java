import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.util.*;

@Slf4j
public class StringComparison {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void test() {
        String nine = "9";
        String ten = "10";

        if(log.isDebugEnabled()) {
            log.debug("nine : {}, ten : {}", nine.getBytes(), ten.getBytes());
        }

        List<String> dictionary = new ArrayList<>();
        dictionary.add(nine);
        dictionary.add(ten);

        log.debug("dic : {}", Arrays.toString(dictionary.toArray()));
        Collections.sort(dictionary);
        log.debug("dic : {}", Arrays.toString(dictionary.toArray()));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(9);
        numbers.add(10);

        log.debug("numbers : {}", Arrays.toString(numbers.toArray()));
        Collections.sort(numbers);
        log.debug("numbers : {}", Arrays.toString(numbers.toArray()));
    }

}
