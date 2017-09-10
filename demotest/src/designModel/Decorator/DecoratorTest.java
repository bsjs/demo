package designModel.Decorator;

import designModel.Decorator.Interface.Component;

public class DecoratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Component component = new ComponentImpl();
		
		ConcreteComponentImpl concreteComponentImpl = new ConcreteComponentImpl(component);
		
		concreteComponentImpl.oper();
	}

}
