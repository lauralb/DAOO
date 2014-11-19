package daoo;

import daoo.ioc.EncodeStrategy;
import daoo.ioc.EncodeStrategyProvider;
import daoo.ioc.MessageEncoder;
import daoo.ioc.MessageEncoderProvider;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 28/06/13
 * Time: 10:07
 */
public class MockingFactory {

    public static MessageEncoderProvider mockedMessageEncoderProvider(){
        MessageEncoder mockedEncoder = mock(MessageEncoder.class);
        when(mockedEncoder.encode(anyString())).thenReturn("encoded".getBytes());
        when(mockedEncoder.decode(any(byte[].class))).thenReturn("decoded");

        MessageEncoderProvider mockedEncoderProvider = mock(MessageEncoderProvider.class);
        when(mockedEncoderProvider.getMessageEncoder()).thenReturn(mockedMessageEncoder());
        return mockedEncoderProvider;
    }

    public static MessageEncoder mockedMessageEncoder(){
        MessageEncoder mockedEncoder = mock(MessageEncoder.class);
        when(mockedEncoder.encode(anyString())).thenReturn("encoded".getBytes());
        when(mockedEncoder.decode(any(byte[].class))).thenReturn("decoded");

        return mockedEncoder;
    }

    public static EncodeStrategyProvider mockedEncodeStrategyProvider(){
        EncodeStrategy mockedStrategy = mock(EncodeStrategy.class);
        when(mockedStrategy.getResponse(anyString(), any(MessageEncoder.class))).thenReturn("mocked response");

        EncodeStrategyProvider mockedProvider = mock(EncodeStrategyProvider.class);
        when(mockedProvider.getEncodeStrategy()).thenReturn(mockedStrategy);

        return mockedProvider;
    }

}
