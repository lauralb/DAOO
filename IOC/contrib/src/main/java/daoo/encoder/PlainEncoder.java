package daoo.encoder;

import com.sun.istack.internal.NotNull;
import daoo.ioc.MessageEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 17/05/13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class PlainEncoder implements MessageEncoder {

    @Override
    public byte[] encode(@NotNull String message) {
        return message.getBytes();
    }

    @Override
    public String decode(@NotNull byte[] message) {
        return new String(message);
    }
}
