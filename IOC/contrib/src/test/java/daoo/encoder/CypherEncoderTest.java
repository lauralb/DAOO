package daoo.encoder;

import encoder.EncoderTest;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 10/06/13
 * Time: 09:46
 * To change this template use File | Settings | File Templates.
 */
public class CypherEncoderTest extends EncoderTest<CypherEncoder>{

    private final CypherEncoder encoder = new CypherEncoder();

    public void testEncodeDecode(){
        testEncodeDecode(encoder, "Encoder-decoder testing");
        testEncodeDecode(encoder, "laura123");
        testEncodeDecode(encoder, "");
    }
}
