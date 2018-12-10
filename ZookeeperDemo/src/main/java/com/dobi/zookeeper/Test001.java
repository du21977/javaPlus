package com.dobi.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Id;

public class Test001 {

	// 连接地址
	private static final String ADDRES = "127.0.0.1:2181";
	// session 会话
	private static final int SESSION_OUTTIME = 2000;
	// 信号量,阻塞程序执行,用户等待zookeeper连接成功,发送成功信号，
	private static final CountDownLatch countDownLatch = new CountDownLatch(1);

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		//子线程---守护线程
		//为什么zk的创建，创建一个新线程，而不是在主线程，为了提高响应速度
		ZooKeeper zk = new ZooKeeper(ADDRES, SESSION_OUTTIME, new Watcher() {
			//事件通知--子线程
			public void process(WatchedEvent event) {
				// 获取事件状态
				KeeperState keeperState = event.getState();
				// 获取事件类型
				EventType eventType = event.getType();
				if (KeeperState.SyncConnected == keeperState) {
					if (EventType.None == eventType) {

						System.out.println("zk 启动连接...");
						countDownLatch.countDown();
					}

				}
			}
		});
		// 进行阻塞----countDownLatch等于0就不阻塞了
		countDownLatch.await();
		//主线程
		//创建持久节点，节点开放权限
		//Ids.OPEN_ACL_UNSAFE权限
		String result = zk.create("/member", "temp".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);
		System.out.println("新增永久节点--："+result);

		//创建临时节点
		String result1 = zk.create("/duterminal", "dudud".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL);
		System.out.println("新增临时节点--："+result1);
		Thread.sleep(20000);//zk.close()后，超过时间，临时节点就会自动删除
		zk.close();
	}

}
