package com.cloud.multithread.activeobject;

public class Proxy implements ActiveObject {
	private final SchedulerThread scheduler;
	private final Servant servant;

	public Proxy(SchedulerThread scheduler, Servant servant) {
		this.scheduler = scheduler;
		this.servant = servant;
	}

	@Override
	public Result makeString(int count, char fillchar) {
		FutureResult future = new FutureResult();
		MethodRequest request = new MakeStringRequest(servant, future, count,
				fillchar);
		scheduler.invoke(request);
		return future;
	}

	@Override
	public void displayString(String string) {
		DisplayStringRequest request = new DisplayStringRequest(servant, string);
		scheduler.invoke(request);
	}

}
