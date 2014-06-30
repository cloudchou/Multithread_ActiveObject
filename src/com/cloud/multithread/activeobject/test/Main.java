package com.cloud.multithread.activeobject.test;

import com.cloud.multithread.activeobject.ActiveObject;
import com.cloud.multithread.activeobject.ActiveObjectFactory;

public class Main {

	public static void main(String[] args) {
		ActiveObject object = ActiveObjectFactory.createActiveObject();
		new MakerClientThread("Aclice", object).start();
		new MakerClientThread("Bobby", object).start();
		new DisplayClientThread("Chris", object).start();
	}

}
