import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MommifierTest {
    @Test
    void should_return_null_for_nullString() {
        String testStr = null;
        String result = VowelsStringTransfer.transfer(testStr);
        assertEquals(null, result);
    }

    @Test
    void should_return_emptyString_for_emptyString() {
        String testStr = "";
        String result = VowelsStringTransfer.transfer(testStr);
        assertEquals("", result);
    }

    @Test
    void should_return_originalString_if_no_more_than_30per_continuous_vowels() {
        String testStr = "abcdeef";
        String result = VowelsStringTransfer.transfer(testStr);
        assertEquals(testStr, result);
    }

    @Test
    void should_return_transferedString_if_more_than_30per_continuous_vowels(){
        String testStr = "acdeef";
        String result = VowelsStringTransfer.transfer(testStr);
        assertEquals("acdemommyef", result);
    }

    @Test
    void should_return_recursively_transferedString_if_more_than_30per_continuous_vowels(){
        String testStr = "acdeeeeeef";
        String result = VowelsStringTransfer.transfer(testStr);
        assertEquals("acdemommyemommyeeeef", result);
    }
}
