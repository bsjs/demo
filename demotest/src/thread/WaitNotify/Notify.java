package thread.WaitNotify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notify implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Constant.lock) {
			System.out.println("thread" + Thread.currentThread().getName()+"@"
					+new SimpleDateFormat("HH:mm:ss").format(new Date())+"Constant.flag is true");	
			Constant.flag = false;
			
			Constant.lock.notifyAll();
		}
		synchronized (Constant.lock) {
			System.out.println("thread" + Thread.currentThread().getName()+"@"
					+new SimpleDateFormat("HH:mm:ss").format(new Date()));
		}
			
	}

}
