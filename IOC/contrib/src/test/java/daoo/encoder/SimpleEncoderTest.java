package daoo.encoder;

import encoder.EncoderTest;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 08/06/13
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
public class SimpleEncoderTest extends EncoderTest<SimpleEncoder> {

    private final SimpleEncoder encoder = new SimpleEncoder();


    public void testEncode() {
        testEncode(encoder, "StringForTesting ", "U3RyaW5nRm9yVGVzdGluZyA=");
    }

    public void testDecode() {
        testDecode(encoder, "U3RyaW5nRm9yVGVzdGluZyA=", "StringForTesting ");
    }

    public void testEncodeDecode(){
        testEncodeDecode(encoder, "Encoder-decoder testing");
        testEncodeDecode(encoder, "laura123");
        testEncodeDecode(encoder, "");
    }
}
