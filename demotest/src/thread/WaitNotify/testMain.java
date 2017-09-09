package thread.WaitNotify;

import thread.common.SleepUtil;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Thread thread = new Thread(new Wait(),"Wait");
        thread.start();
        SleepUtil.second(5);
        Thread thread2 = new Thread(new Notify(),"Notify");
        thread2.start();
	}

}
