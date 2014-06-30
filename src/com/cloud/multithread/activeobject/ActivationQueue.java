package com.cloud.multithread.activeobject;

public class ActivationQueue {
	private static final int MAX_METHOD_REQUEST = 100;
	private MethodRequest[] requestQueue;
	private int tail;
	private int head;
	private int count;

	public ActivationQueue() {
		requestQueue = new MethodRequest[MAX_METHOD_REQUEST];
		tail = 0;
		head = 0;
		count = 0;
	}

	public synchronized void putRequest(MethodRequest request) {
		while (count >= requestQueue.length)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		requestQueue[tail] = request;
		tail = (tail + 1) % requestQueue.length;
		count++;
		notifyAll();
	}

	public synchronized MethodRequest getRequest() {
		while (count <= 0)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		MethodRequest request = requestQueue[head];
		head = (head + 1) % requestQueue.length;
		count--;
		return request;
	}

}
