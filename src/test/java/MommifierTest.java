import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MommifierTest {
    @Test
    void should_return_null_for_nullString(){
        String testStr=null;
        String result=VowelsStringTransfer.transfer(testStr);
        assertEquals(null, result);
    }

    @Test
    void should_return_emptyString_for_emptyString(){
        String testStr="";
        String result=VowelsStringTransfer.transfer(testStr);
        assertEquals("",result);
    }
}
