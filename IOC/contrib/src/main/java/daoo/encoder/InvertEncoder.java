package daoo.encoder;

import com.sun.istack.internal.NotNull;
import daoo.ioc.MessageEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 17/05/13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class InvertEncoder implements MessageEncoder {
    @Override
    public byte[] encode(@NotNull String message) {
        return invert(message);
    }

    @Override
    public String decode(@NotNull byte[] message) {
        return invert(message);
    }

    private String invert(@NotNull byte[] msg){
        return new String(invert(new String(msg)));
    }
    private byte[] invert(@NotNull String message) {

        String temp = "";
        for (int i = message.length() - 1; i >= 0; i--)
            temp += message.charAt(i);
        return temp.getBytes();
    }
}
