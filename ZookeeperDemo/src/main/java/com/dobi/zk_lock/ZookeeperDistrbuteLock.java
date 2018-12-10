package com.dobi.zk_lock;

import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * 自己实现zookeeper分布式锁
 */
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {
	private CountDownLatch countDownLatch = null;

	/**
	 * 获取锁
	 * 能创建节点成功，就能拿到锁，否则拿不到锁，等待
	 * @return
	 */
	@Override
	boolean tryLock() {
		try {
			zkClient.createEphemeral(PATH);
			return true;
		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 检测节点，如果存在则等待
	 * 注册事件监听，如果节点被删除，则被监听通知，去获取锁，拿到锁后，删除对这个节点的监听
	 */
	@Override
	void waitLock() {
		IZkDataListener izkDataListener = new IZkDataListener() {
			//当节点被删除的时候，会走这个方法
			public void handleDataDeleted(String path) throws Exception {
				// 唤醒被等待的线程
				if (countDownLatch != null) {
					countDownLatch.countDown();
				}
			}
			//当节点改变的时候，会走这个方法
			public void handleDataChange(String path, Object data) throws Exception {

			}
		};
		// 注册事件
		zkClient.subscribeDataChanges(PATH, izkDataListener);
		if (zkClient.exists(PATH)) {
			countDownLatch = new CountDownLatch(1);
			try {
				//等待
				countDownLatch.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 删除监听
		zkClient.unsubscribeDataChanges(PATH, izkDataListener);
	}

}
