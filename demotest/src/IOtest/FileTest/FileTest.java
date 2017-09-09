package IOtest.FileTest;

import java.util.List;

import IOtest.FileTest.FileOper.FileDo;
import IOtest.FileTest.FileOper.FileList;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         List<FileDo> result = FileList.getAllFile(".");
         
         for(FileDo file: result)
         {
        	 System.out.println(file);
         }
	}

}
