package com.cloud.multithread.activeobject;

public class FutureResult extends Result {
	private boolean ready = false;
	private Result result;

	public synchronized void setResult(Result result) {
		this.result = result;
		this.ready = true;
		notifyAll();
	}

	@Override
	public synchronized Object getResultValue() {
		while (!ready)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		return result.getResultValue();
	}

}
