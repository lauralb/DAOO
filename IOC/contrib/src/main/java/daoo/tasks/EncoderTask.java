package daoo.tasks;

import com.sun.istack.internal.NotNull;
import daoo.ioc.EncodeStrategy;
import daoo.ioc.MessageEncoder;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Task;

import java.io.*;
import java.net.Socket;


public class EncoderTask extends Task {

    private final MessageEncoderProvider messageEncoderProvider;
    private final EncodeStrategy encodeStrategy;

    public EncoderTask(@NotNull Socket socket, @NotNull MessageEncoderProvider messageEncoderProvider,
                       @NotNull EncodeStrategy encodeStrategy) {
        super(socket);
        this.messageEncoderProvider = messageEncoderProvider;
        this.encodeStrategy = encodeStrategy;
    }

    @Override
    protected void task() throws IOException {
        print("encoding...");
        encode();
    }

    private void encode() throws IOException {

        final MessageEncoder messageEncoder = messageEncoderProvider.getMessageEncoder();

        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        final StringBuilder header = new StringBuilder();

        while (true) {
            final String s = in.readLine();
            if(s == null || s.isEmpty()) break;
            header.append(s);
        }

        out.write("HTTP/1.1 200 OK\r\n");
        out.write("Content-Type: text/plain\r\n");

        // Encoder path
        out.write("\r\n");

        String response = encodeStrategy.getResponse(getHeaderPath(header.toString()), messageEncoder);
        out.write(response);

        out.close();
        in.close();

    }


}



