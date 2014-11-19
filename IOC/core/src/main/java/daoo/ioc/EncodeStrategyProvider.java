package daoo.ioc;

import daoo.encodeStrategies.EncodeDecodeStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: Laura
 * Date: 17/11/14
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class EncodeStrategyProvider {

    public EncodeStrategy getEncodeStrategy(){

        return new EncodeDecodeStrategy();
        /*
        final ServiceLoader<EncodeStrategy> loader = ServiceLoader.load(EncodeStrategy.class);
        for (EncodeStrategy encodeStrategy : loader){
            System.out.println(encodeStrategy.getClass().getName());
            return encodeStrategy;
        }
        return null;
        */

    }
}
