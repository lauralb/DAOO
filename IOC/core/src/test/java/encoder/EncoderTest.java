package encoder;


import com.sun.istack.internal.NotNull;
import daoo.ioc.MessageEncoder;
import junit.framework.TestCase;


public abstract class EncoderTest<T extends MessageEncoder> extends TestCase {

    public void testEncode(@NotNull T encoder, @NotNull String message, @NotNull String encodedMessage){
        String encoded = new String(encoder.encode(message));
        assertEquals(encoded.replaceAll("\\s",""),encodedMessage);
    }

    public void testDecode(@NotNull T encoder, @NotNull String message, @NotNull String decodedMessage){
        String decoded = encoder.decode(message.getBytes());
        assertEquals(decoded, decodedMessage);
    }

    public void testEncodeDecode(@NotNull T encoder, @NotNull String message){
        String s = encoder.decode(encoder.encode(message));
        assertEquals(s,message);
    }

}
