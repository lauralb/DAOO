package encoder;


import daoo.ioc.MessageEncoder;
import junit.framework.TestCase;


public abstract class EncoderTest<T extends MessageEncoder> extends TestCase {

    public abstract void testEncode();

    public abstract void testDecode();

    public abstract void testEncodeDecode();

}
