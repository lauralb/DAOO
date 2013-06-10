package daoo.encoder;


import encoder.EncoderTest;

public class PlainEncoderTest extends EncoderTest<PlainEncoder> {

    private static final PlainEncoder encoder = new PlainEncoder();

    public void testEncode() {
        testEncode(encoder, "Hola", "Hola");
        testEncode(encoder, "123456", "123456");
    }

    public void testDecode() {
        testDecode(encoder, "Hola", "Hola");
        testDecode(encoder, "123456", "123456");
    }

    public void testEncodeDecode(){
        testEncodeDecode(encoder, "Encoder-decoder testing");
        testEncodeDecode(encoder, "laura123");
        testEncodeDecode(encoder, "");
    }
}
