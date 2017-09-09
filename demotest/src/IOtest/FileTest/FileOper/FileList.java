package IOtest.FileTest.FileOper;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FileList {
       
	private static Deque<File> fileDeque = new ArrayDeque<File>();
	
	/**
	 * @param path
	 * @return
	 */
	public static List<FileDo> getAllFile(final String path)
	{
		List<FileDo> result = new ArrayList<FileDo>();	
		
		if(null == path || path.isEmpty())
		{
			return result;
		}
		//获取文件描述符
		File file = new File(path);
		
		File [] fileArrays = file.listFiles();
		if(0 == fileArrays.length)
		{
			return result;
		}
							
		//全部放在队列中进行处理
		for(File s:fileArrays)
		{
			fileDeque.add(s);
		}
		
		while(!fileDeque.isEmpty())
		{
			File s = fileDeque.removeFirst();
			if(s.isDirectory())
			{
				dealDirectory(s,result);				
				continue;
			}
			dealInformation(s, result);
		}
		return result;
	}
	
	/**
	 * @param path
	 * @return
	 */
	public static String[] getFile(final String path)
	{
		return null;
		
	}
	
	/**
	 * @param s
	 */
	private static void dealDirectory(File s,List<FileDo> result)
	{
		if(null == s || !s.exists())
		{
			return;
		}
		
		File [] file = s.listFiles();
		for(File tmpFile : file)
		{
			if(tmpFile.isDirectory())
			{
				fileDeque.add(tmpFile);
				continue;
			}
			dealInformation(tmpFile, result);
		}
		
	}
	/**
	 * @param s
	 * @param result
	 */
	private static void dealInformation(File s,List<FileDo> result)
	{
		if(null == s || !s.exists())
		{
			return;
		}
		FileDo fileDo = new FileDo();
		fileDo.setFileName(s.getName());
		fileDo.setAbsolutePath(s.getAbsolutePath());
		fileDo.setIsDir(s.isDirectory());
		fileDo.setCanRead(s.canRead());
		fileDo.setCanExecute(s.canExecute());
		fileDo.setCanWrite(s.canWrite());
		fileDo.setFileLength(s.length());
		fileDo.setLastModifyTime(s.lastModified());
		
		result.add(fileDo);
	}
}
