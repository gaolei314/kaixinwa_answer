package com.zbar.lib;

import java.util.concurrent.CountDownLatch;

import com.qkhl.fragment.AnswerFragment;


import android.os.Handler;
import android.os.Looper;

/**
 *
 * 描述: 解码线程
 */
final class DecodeThread extends Thread {

	AnswerFragment activity;
	private Handler handler;
	private final CountDownLatch handlerInitLatch;

	DecodeThread(AnswerFragment activity) {
		this.activity = activity;
		handlerInitLatch = new CountDownLatch(1);
	}

	Handler getHandler() {
		try {
			handlerInitLatch.await();
		} catch (InterruptedException ie) {
			// continue?
		}
		return handler;
	}

	@Override
	public void run() {
		Looper.prepare();
		handler = new DecodeHandler(activity);
		handlerInitLatch.countDown();
		Looper.loop();
	}

}
