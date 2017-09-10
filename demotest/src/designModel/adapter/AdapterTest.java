package designModel.adapter;

import designModel.adapter.Interface.ClassAdapterTarget;
import designModel.adapter.adaptee.Adaptee;

public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//对象适配器
        Adaptee adaptee = new Adaptee();
        
        ObjectAdapterImpl objectAdapterImpl = new ObjectAdapterImpl(adaptee);
        
        objectAdapterImpl.request();
        
        //类适配器
        ClassTargetImpl classTargetImpl = new ClassTargetImpl();
        classTargetImpl.request();
	}

}
