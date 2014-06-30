package com.cloud.multithread.activeobject;

public class MakeStringRequest extends MethodRequest {
	private final int count;
	private final char c;

	public MakeStringRequest(Servant servant, FutureResult future, int count,
			char c) {
		super(servant, future);
		this.count = count;
		this.c = c;
	}

	@Override
	public void execute() {
		Result result = servant.makeString(count, c);
		future.setResult(result);
	}

}
