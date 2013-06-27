package daoo.ioc;

import daoo.ioc.MessageEncoder;

import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 17/05/13
 * Time: 16:19
 */

public class MessageEncoderProvider {

    public static void listEncoder(){
        final ServiceLoader<MessageEncoder> loader = ServiceLoader.load(MessageEncoder.class);
        for (MessageEncoder messageEncoder : loader){
            System.out.println(messageEncoder.getClass().getName());
        }
    }

    public static void main(String[] args) {
        listEncoder();
    }

    public MessageEncoder getMessageEncoder(){
        final ServiceLoader<MessageEncoder> loader = ServiceLoader.load(MessageEncoder.class);
        for (MessageEncoder messageEncoder : loader){
            System.out.println(messageEncoder.getClass().getName());
            return messageEncoder;
        }
        return null;
    }
}
