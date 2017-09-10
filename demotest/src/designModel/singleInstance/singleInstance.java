package designModel.singleInstance;

public class singleInstance {
   
	private static singleInstance instance = new singleInstance();
	
	public static singleInstance getInstance()
	{
		return instance;
	}
}
