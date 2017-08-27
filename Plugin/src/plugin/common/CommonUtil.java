package plugin.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import plugin.loader.plugin;

public class CommonUtil {
	
	private static Properties properties = null;
	
	private static String PluginPositionPath = CommonUtil.getRootPath()+File.separator+"plugins"+File.separator;
	
	private static String configFileName = "pluginConfig.properties";
	
	private static final String KEY = "className";
	
	public static void getPluginInstance()
	{
		//先获取文件位置
		File folder = new File(PluginPositionPath);
		File[] fileList = folder.listFiles();
		
		if(null == fileList || 0 == fileList.length)
		{
			return;
		}
		for(File file : fileList)
		{
			createInstance(file);
		}
	}

	private static void createInstance(File file) 
	{
		String className;
		URLClassLoader urlClassLoader = null;
		try 
		{			 
			  JarFile jar = new JarFile(file);			
			  //获取配置的class
			  JarEntry jarEntry = jar.getJarEntry(configFileName);

			  if(null == properties)
			  {
			    Properties prob = new Properties();
			    //获取流
			    InputStream inputStream = jar.getInputStream(jarEntry);
			
			    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			  
			    prob.load(bufferedReader);
			  
			   className = prob.getProperty(KEY);
			  
			  }
			  else
			  {
				className = properties.getProperty(KEY);
			  }
			
			//jar包的全路径
			URL[] urls = new URL[1];
			urls[0] = new URL("file:"+file);
			
			urlClassLoader = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
		   
			Class<?> clazz = urlClassLoader.loadClass(className);
		    
		    Object object = clazz.newInstance();
		    
		    plugin pluginTest = (plugin) object;
		    
		    pluginTest.printPlugin();
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				urlClassLoader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	private static String getRootPath() {
		
		return System.getProperty("user.dir");
	}
}
