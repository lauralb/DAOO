package daoo.encoder;

import com.sun.istack.internal.NotNull;
import daoo.ioc.MessageEncoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 07/06/13
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
public class SimpleEncoder implements MessageEncoder{

    @Override
    public byte[] encode(@NotNull String message) {
        final String encode = new BASE64Encoder().encodeBuffer(message.getBytes());
        return encode.getBytes();

    }

    @Override
    public String decode(@NotNull byte[] message) {
        try {
            final byte[] bytes = new BASE64Decoder().decodeBuffer(new String(message));
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }




}
