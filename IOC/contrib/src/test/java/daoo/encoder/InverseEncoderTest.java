package daoo.encoder;

import encoder.EncoderTest;

public class InverseEncoderTest extends EncoderTest<InvertEncoder> {

    private static final InvertEncoder encoder = new InvertEncoder();

    public void testEncode() {
        testEncode(encoder, "Hola", "aloH");
        testEncode(encoder, "123456", "654321");
    }

    public void testDecode() {
        testEncode(encoder, "aloH", "Hola");
        testEncode(encoder, "123456", "654321");
    }

    public void testEncodeDecode(){
        testEncodeDecode(encoder, "Encoder-decoder testing");
        testEncodeDecode(encoder, "laura123");
        testEncodeDecode(encoder, "");
    }



}
