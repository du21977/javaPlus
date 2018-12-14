
package com.dobi;

import java.io.Serializable;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * netty5
 */
class ClientHandler extends ChannelHandlerAdapter {

	/**
	 * 当通道被调用,执行该方法
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 接收数据
		String value = (String) msg;
		System.out.println("client msg:" + value);
	}

}

public class NettyClient {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("客户端已经启动....");
		// 创建负责接收客户端连接
		NioEventLoopGroup pGroup = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(pGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				//设置分隔符达到拆包效果
				 ByteBuf buf = Unpooled.copiedBuffer("_mayi".getBytes());
				 sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,
				 buf));
				//设置每个包的长度达到拆包效果
//				sc.pipeline().addLast(new FixedLengthFrameDecoder(10));

				sc.pipeline().addLast(new StringDecoder());
				sc.pipeline().addLast(new ClientHandler());
			}
		});
		ChannelFuture cf = b.connect("127.0.0.1", 8080).sync();
		// Thread.sleep(1000);
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("yushengjun".getBytes()));
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("yushengjun_mayi".getBytes()));
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("yushengjun_mayi".getBytes()));

		// 等待客户端端口号关闭
		cf.channel().closeFuture().sync();
		pGroup.shutdownGracefully();

	}

}
