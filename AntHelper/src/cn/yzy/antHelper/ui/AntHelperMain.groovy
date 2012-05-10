package cn.yzy.antHelper.ui

import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIManager;

class AntHelperMain
{
	JFrame mainFrame;
	String PROPERTY_FILE_NAME='AntHelper.xml';
	File propertyFile;



	def AntHelperMain()
	{
		UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName())
		mainFrame=new AntHelpFrame(getPropertyFile())
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
	}

	def getPropertyFile()
	{
		if(!propertyFile)
		{
			String currentDir=System.getProperties().getProperty("user.dir")
			propertyFile= new File("${currentDir}\\${PROPERTY_FILE_NAME}")
		}
		return propertyFile
	}



	def show()
	{
		SwingUtil.centerInScreen(mainFrame)
		mainFrame.setVisible(true)
	}

	public static void main(String[] args)
	{
		def antHelperMain=new AntHelperMain()
		antHelperMain.show()
		
	}
}