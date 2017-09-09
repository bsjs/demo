package IOtest.FileTest.FileOper;

public class FileDo {
  
	String fileName;
	
	long lastModifyTime;
	
	String  absolutePath;
	
	long    fileLength;	
	
	boolean isDir;
	
	boolean isCanRead;
	
	boolean isCanWrite;
	
	boolean isCanExecute;
		
	/**
	 * 
	 */
	public FileDo() {
		
	}
	public String getFileName()
	{
		return this.fileName;
	}
	
	public long getLastModifyTime()
	{
		return this.lastModifyTime;
	}
	
	public String getAbsolutePath()
	{
		return this.absolutePath ;
	}
	
	public long getFileLength()
	{
		return this.fileLength;
	}
	
	public boolean getIsDir()
	{
		return this.isDir;
	}
	public boolean getCanRead()
	{
		return this.isCanRead ;
	}
	
	public boolean getCanWrite()
	{
		return this.isCanWrite ;
	}
	
	public boolean getCanExecute()
	{
		return this.isCanExecute;
	}
	
	
	public void setFileName(String name)
	{
		this.fileName = name;
	}
	
	public void setLastModifyTime(long time)
	{
		this.lastModifyTime = time;
	}
	
	public void setAbsolutePath(String path)
	{
		this.absolutePath = path;
	}
	
	public void setFileLength(long length)
	{
		this.fileLength = length;
	}
	public void setIsDir(boolean isDir)
	{
		this.isDir = isDir;
	}
	public void setCanRead(boolean canRead)
	{
		this.isCanRead = canRead;
	}
	
	public void setCanWrite(boolean canWrite)
	{
		this.isCanWrite = canWrite;
	}
	
	public void setCanExecute(boolean canExecute)
	{
		this.isCanExecute = canExecute;
	}
	
	public String toString()
	{
		return "The file name is:"+this.getFileName()+" "
				+ "length:"+String.valueOf(this.getFileLength());
				
	}
}
