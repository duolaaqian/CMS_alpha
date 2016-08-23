package com.dlaq.test.thread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer --> 定时器
 * TimerTask --> 定时任务
 * 
 * Timer.schedule(TimerTask,Date,long)
 * 	执行任务，在 Date 时间点执行 TimerTask 任务 ，每隔 long 执行一次(可选)
 * 
 */
public class ScheduleDemo01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
			@Override
			public void run() {
				System.out.println("任务执行开始....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("任务执行结束....");
			}
		};
		timer.schedule(task,new Date(),2000);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
	}
}
