package designModel.Decorator;

import designModel.Decorator.Decorator.Decorator;
import designModel.Decorator.Interface.Component;

public class ConcreteComponentImpl extends Decorator{

	public ConcreteComponentImpl(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
   
	public void operBefore()
	{
		System.out.println("ConcreteComponentImpl");
	}
	
	public void operEnd()
	{
		System.out.println("ConcreteComponentImpl");
	}
	
	public void oper()
	{
		operBefore();
		//call father
		super.oper();
		operEnd();
	}
}
