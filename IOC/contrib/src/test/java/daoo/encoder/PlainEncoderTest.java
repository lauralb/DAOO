package daoo.encoder;


import encoder.EncoderTest;

public class PlainEncoderTest extends EncoderTest<PlainEncoder> {

    private static final PlainEncoder encoder = new PlainEncoder();

    @Override
    public void testEncode() {
        String encodedMessage = new String(encoder.encode("HoLa"));
        assertEquals(encodedMessage, "HoLa");
    }

    @Override
    public void testDecode() {
        String decodedMessage = encoder.decode("HoLa".getBytes());
        assertEquals(decodedMessage, "HoLa");
    }

    @Override
    public void testEncodeDecode() {
        String encodeDecodeMessage = encoder.decode(encoder.encode("HoLa"));
        assertEquals(encodeDecodeMessage, "HoLa");
    }
}
