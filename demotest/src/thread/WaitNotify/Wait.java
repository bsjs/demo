package thread.WaitNotify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Wait implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Constant.lock) {
			while(Constant.flag)
			{	
				try {
					System.out.println("thread" + Thread.currentThread().getName()+"@"
							+new SimpleDateFormat("HH:mm:ss").format(new Date()));
					Constant.lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		System.out.println("thread" + Thread.currentThread().getName()+"@"
				+new SimpleDateFormat("HH:mm:ss").format(new Date())+"Constant.flag is false");	
	}

	
}
