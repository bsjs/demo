package designModel.adapter;

import designModel.adapter.Interface.ObjectAdapterTarget;
import designModel.adapter.adaptee.Adaptee;

public class ObjectAdapterImpl implements ObjectAdapterTarget{

	/**
	 * 内含Adaptee对象
	 */
	private Adaptee adaptee;
	
    public ObjectAdapterImpl(Adaptee adaptee) {
		// TODO Auto-generated constructor stub
		this.adaptee = adaptee;
	}
	
	@Override
	public void request() {
		// TODO Auto-generated method stub
		this.adaptee.requestPrint();
	}

}
