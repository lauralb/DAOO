package daoo.ioc;

/**
 * Created by IntelliJ IDEA.
 * User: Laura
 * Date: 15/11/14
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public interface EncodeStrategy {

    String getResponse(String requestHeader, MessageEncoder messageEncoder);

}
