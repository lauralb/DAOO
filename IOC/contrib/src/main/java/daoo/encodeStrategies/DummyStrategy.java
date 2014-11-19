package daoo.encodeStrategies;

import daoo.ioc.EncodeStrategy;
import daoo.ioc.MessageEncoder;

/**
 * Created by IntelliJ IDEA.
 * User: Laura
 * Date: 19/11/14
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class DummyStrategy implements EncodeStrategy{

    @Override
    public String getResponse(String requestHeader, MessageEncoder messageEncoder) {
        return  "Dummy response";

    }
}
