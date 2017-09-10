package designModel.Decorator.Decorator;

import designModel.Decorator.Interface.Component;

public abstract class Decorator extends Component {

	protected Component component;
	
	public Decorator(Component component)
	{
		this.component=component;
	}
	
	
	/* (non-Javadoc)
	 * @see designModel.Decorator.Interface.Component#oper()
	 */
	public void oper()
	{
		//call ComponentImpl
		component.oper();
	}
}
