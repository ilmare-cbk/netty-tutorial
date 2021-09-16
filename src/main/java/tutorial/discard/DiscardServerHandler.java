package tutorial.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * This method is called with the received message, whenever new data is received from a client.
     *
     * ByteBuf is a reference-counted object which has to be release explicitly via the release() method.
     * Keep in mind that it is hte handler's responsibility to release any reference-counted object passed to the handler.
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // Discard the received data silently.
        ((ByteBuf) msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // Close the connection when a exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
