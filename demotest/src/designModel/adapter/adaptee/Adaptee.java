package designModel.adapter.adaptee;

/**
 * @author koda
 * 提供服务的待适配类
 */
public class Adaptee {

	public void requestPrint()
	{
		System.out.println("Adaptee offer service for target ");
	}
}
