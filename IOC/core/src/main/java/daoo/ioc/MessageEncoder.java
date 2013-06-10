package daoo.ioc;

import com.sun.istack.internal.NotNull;


public interface MessageEncoder {

    byte[] encode(@NotNull String message);

    String decode(@NotNull byte[] message);
}
