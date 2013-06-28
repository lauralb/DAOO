package daoo;

import daoo.encoder.PlainEncoder;
import daoo.ioc.MessageEncoder;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Executor;
import daoo.server.TaskExecutorProvider;
import daoo.server.TaskServer;
import daoo.servers.DaooEncoderServer;
import daoo.tasks.EncoderTask;

import java.net.Socket;

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

    public static MessageEncoderProvider mockedEncoderProvider(){
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

}
