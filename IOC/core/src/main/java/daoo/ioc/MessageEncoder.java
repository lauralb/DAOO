package daoo.ioc;

import com.sun.istack.internal.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 17/05/13
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public interface MessageEncoder {

    byte[] encode(@NotNull String message);

    String decode(@NotNull byte[] message);
}
