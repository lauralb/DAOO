package daoo.encodeStrategies;

import daoo.ioc.EncodeStrategy;
import daoo.ioc.MessageEncoder;

/**
 * Created by IntelliJ IDEA.
 * User: Laura
 * Date: 15/11/14
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class EncodeDecodeStrategy implements EncodeStrategy{

    private static final String wrongActionMessage = "Please specify : encode, decode or encode-decode / message" +"\r\n";

    @Override
    public String getResponse(String requestHeader, MessageEncoder messageEncoder) {

        final String[] dividedPath = requestHeader.split("/");

        if(dividedPath.length > 2){
            String action = dividedPath[1];
            String message = dividedPath[2];
            if (action.equals("encode")){
                return getEncodeResponse(message, messageEncoder);
            } else if (action.equals("decode")){
                return getDecodeResponse(message, messageEncoder);
            }else if(action.equals("encode-decode")){
                return getEncodeDecodeResponse(message, messageEncoder);
            }
            else {
                return wrongActionMessage;
            }
        }else{
            return wrongActionMessage;
        }
    }


    private String getEncodeResponse(String message, MessageEncoder messageEncoder){
        StringBuffer encodeResponse = new StringBuffer();
        encodeResponse.append("You asked to encode:" +"\r\n");
        encodeResponse.append(message+"\r\n");
        encodeResponse.append("Your encoded message is:" +"\r\n");
        encodeResponse.append(new String(messageEncoder.encode(message))+"\r\n");
        return encodeResponse.toString();
    }

    private String getDecodeResponse(String message, MessageEncoder messageEncoder){
        StringBuffer decodeResponse = new StringBuffer();
        decodeResponse.append("You asked to decode:" + "\r\n");
        decodeResponse.append(message + "\r\n");
        decodeResponse.append("Your decoded message is:" + "\r\n");
        decodeResponse.append(messageEncoder.decode(message.getBytes()) + "\r\n");
        return decodeResponse.toString();
    }

    private String getEncodeDecodeResponse(String message, MessageEncoder messageEncoder){
        StringBuffer encodeDecodeResponse = new StringBuffer();
        encodeDecodeResponse.append("You asked to encode-decode:" + "\r\n");
        encodeDecodeResponse.append(message + "\r\n");
        encodeDecodeResponse.append("Your encoded message is:" + "\r\n");
        encodeDecodeResponse.append(new String(messageEncoder.encode(message)) + "\r\n");
        encodeDecodeResponse.append("And your encoded-decoded message is:" + "\r\n");
        encodeDecodeResponse.append(messageEncoder.decode(messageEncoder.encode(message)) + "\r\n");
        return encodeDecodeResponse.toString();
    }



}
