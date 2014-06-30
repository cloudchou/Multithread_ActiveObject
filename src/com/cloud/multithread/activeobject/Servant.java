package com.cloud.multithread.activeobject;

public class Servant implements ActiveObject {

	@Override
	public Result makeString(int count, char fillchar) {
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = fillchar;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
		return new RealResult(new String(buffer));
	}

	@Override
	public void displayString(String string) {
		try {
			System.out.println("display String : " + string);
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
