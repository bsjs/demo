package designModel.adapter;

import designModel.adapter.Interface.ClassAdapterTarget;
import designModel.adapter.adaptee.Adaptee;

public class ClassTargetImpl extends Adaptee implements ClassAdapterTarget{

	@Override
	public void request() {
		// TODO Auto-generated method stub
		requestPrint();
	}

}
