package com.cloud.multithread.activeobject.test;

import com.cloud.multithread.activeobject.ActiveObject;
import com.cloud.multithread.activeobject.Result;

public class MakerClientThread extends Thread {
	private final ActiveObject object;
	private final char fillChar;

	public MakerClientThread(String name, ActiveObject object) {
		super(name);
		this.object = object;
		fillChar = name.charAt(0);
	}

	public void run() {
		try {
			int i = 0;
			while (true) {
				Result result = object.makeString(i++, fillChar);
				Thread.sleep(10);
				String value = (String) result.getResultValue();
				System.out.println(Thread.currentThread().getName()
						+ " : value = " + value);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
