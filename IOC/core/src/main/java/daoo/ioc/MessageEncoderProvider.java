package daoo.ioc;

import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 17/05/13
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */
public class MessageEncoderProvider {

    public static void listEncoder(){
        final ServiceLoader<MessageEncoder> loader = ServiceLoader.load(MessageEncoder.class);
        for (MessageEncoder messageEncoder : loader) {
            System.out.println(messageEncoder.getClass().getName());
        }

    }

    public static void main(String[] args) {
        listEncoder();
    }
}
