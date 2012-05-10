package cn.yzy.antHelper.ui

import java.io.File

import javax.swing.SwingUtilities

class AntWorker
{
	def mLocations=[]
	def mOutput
	def mAntHome
	def mTarget
	def mBuildFile

	def setLocations(def locations)
	{
		this.mLocations=locations
	}

	def setBuildFile(def buildFile)
	{
		this.mBuildFile=buildFile
	}

	def setOutput(def output)
	{
		this.mOutput=output
	}

	def setAntHome(def antHome)
	{
		this.mAntHome=antHome
	}

	def setTarget(def target)
	{
		this.mTarget=target
	}

	def buildAll()
	{
		mLocations.each
		{
			def file=new File(it)
			if(file.exists() && file.isDirectory())
			{
				buildDir(file)
			}else
			{
				printOutput("\"${file.getAbsolutePath()}\" doesn't exist or isn't a dir.")
			}
		}
		
		printOutput("Done!")
	}

	def buildDir(File dir)
	{
		dir.eachFile
		{
			if(it.isFile())
			{
				if(it.name==mBuildFile)
				{
					runAnt(it)
				}
			}else
			{
				buildDir(it)
			}
		}
	}

	def runAnt(File buildFile)
	{
		if(hasJasperTarget(buildFile))
		{
			printOutput ("***************************************************************")
			printOutput "build jasperreport : ${buildFile.getAbsolutePath()}"
			String parent=buildFile.getParent()
			String cmd="${getAntCMD(mAntHome)} -f ${buildFile.getAbsolutePath()} ${mTarget}"
			printOutput "${cmd}".execute().text
			printOutput ("")
		}
	}

	String getAntCMD(String antHome)
	{
		String cmd=""

		cmd=validateSeperator(antHome)

		if(!cmd.endsWith("/"))
		{
			cmd+="/"
		}

		cmd+="bin/ant.bat"
		return cmd
	}

	String validateSeperator(String path)
	{
		if(path.contains("\\\\"))
		{
			return path.replaceAll("\\\\", "/")
		}

		return path
	}

	def boolean hasJasperTarget(File f)
	{
		return f.text.contains(mTarget)
	}

	def printOutput(String msg)
	{
		mOutput.text="${mOutput.text}${msg}\n"
		mOutput.setCaretPosition(mOutput.text.size())
	}
}