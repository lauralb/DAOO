package daoo.encoder;

import encoder.EncoderTest;

public class InverseEncoderTest extends EncoderTest<InvertEncoder> {

    @Override
    public void testEncode() {
        InvertEncoder encoder = new InvertEncoder();
        String s = new String(encoder.encode("hola"));
        assertEquals(s,("aloh"));
    }

    @Override
    public void testDecode() {
        InvertEncoder encoder = new InvertEncoder();
        String s = encoder.decode("HoLA".getBytes());
        assertEquals(s, ("ALoH"));
    }

    public void testEncodeDecode(){
        InvertEncoder encoder = new InvertEncoder();
        String s = encoder.decode(encoder.encode("HOLA"));
        assertEquals(s,"HOLA");
    }


}
