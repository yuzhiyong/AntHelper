package cn.yzy.antHelper.ui

import java.io.File

import javax.swing.JFileChooser
import javax.swing.JTable.BooleanRenderer
import javax.swing.JTable.ModelChange


public class AntHelpFrame extends AntHelpFrameView
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L
	private AntHelperModel mDataModel
	File mPropertyFile
	String KEY_ANT_HOME='antHome'
	String KEY_BUILD_FILE_NAME='buildFileName'
	String KEY_TARGET='target'
	String KEY_LOCATION_TABLE_MODEL='locationTableModel'
	String KEY_LOCATION_ID='id'
	String KEY_LOCATION_ENABLE='enable'
	String KEY_LOCATION_PATH='location'
	String lastPath=null

	def AntHelpFrame(File propertyFile)
	{
		super()
		this.mPropertyFile=propertyFile
		this.mDataModel=getModelFromXml(propertyFile)

		initUI()
	}

	def getModelFromXml(File propertyFile)
	{
		def dataModel=new AntHelperModel()

		if(propertyFile.exists())
		{
			def data=new XmlParser().parse(propertyFile)
			data.each
			{
				def key=it.name()
				def value=it.value()[0]
				switch (key)
				{
					case KEY_ANT_HOME:
						dataModel.antHome=value
						break
					case KEY_BUILD_FILE_NAME:dataModel.buildFileName=value
						break
					case KEY_TARGET:dataModel.target=value
						break
					case KEY_LOCATION_TABLE_MODEL:parseTableModel(it,dataModel)
						break
				}
			}
		}

		return dataModel
	}

	def parseTableModel(Node node,AntHelperModel model)
	{
		def rowList=[]

		node.value().each
		{rowNode->
			def aRow=[]
			rowNode.value().each
			{itemNode->
				def key=itemNode.name()
				def value=itemNode.value()[0]
				switch (key)
				{
					case KEY_LOCATION_ENABLE:aRow[0]=(value=='true')
						break
					case KEY_LOCATION_PATH:aRow[1]=value
						break
				}
			}
			rowList<<aRow
		}

		model.locationListTableModel=new LocationTableModel(rowList)
	}

	private void initUI()
	{
		setTitle('Ant Helper')

		btnAntHome.actionPerformed=
		{
			def fileChooser=new JFileChooser()
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
			def result=fileChooser.showOpenDialog(this)
			if(result==JFileChooser.APPROVE_OPTION)
			{
				mDataModel.antHome=fileChooser.getSelectedFile().getAbsolutePath()
				updateUI()
			}
		}

		btnLocation.actionPerformed=
		{
			def fileChooser=new JFileChooser()
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
			if(lastPath!=null) {
				fileChooser.setCurrentDirectory(new File(lastPath))
			}
			def result=fileChooser.showOpenDialog(this)
			if(result==JFileChooser.APPROVE_OPTION)
			{
				mDataModel.location=fileChooser.getSelectedFile().getAbsolutePath()
				lastPath=mDataModel.location
				updateUI()
			}
		}

		locationsTable.setModel(mDataModel.locationListTableModel)
		locationsTable.getColumnModel().getColumn(0).setMaxWidth(50)

		btnAddLocation.actionPerformed=
		{
			if(tfLoation.text!=null && tfLoation.text.trim().length()>0)
			{
				locationsTable.getModel().addNew(tfLoation.text)
			}
		}

		btnDeleteLocation.actionPerformed=
		{
			def idx=locationsTable.getSelectedRow()
			locationsTable.getModel().remove(idx)
		}

		//		dataModel.buildFileName='build.xml'

		//		dataModel.target='compile.jasperreports'

		tfBuildFileName.focusLost=
		{
			mDataModel.buildFileName=tfBuildFileName.text
		}

		tfTarget.focusLost=
		{
			mDataModel.target=tfTarget.text
		}


		taOutput.setEditable(false)

		btnRun.actionPerformed=
		{
			Thread.start {
				buildTarget(mDataModel)
				persistDataModel(mDataModel)
				btnRun.setEnabled(true)
			}
			btnRun.setEnabled(false)
		}

		btnCancel.actionPerformed=
		{ this.dispose() }

		updateUI()
	}

	def persistDataModel(AntHelperModel model)
	{
		String xmlTableModel=""
		model.locationListTableModel.each { xmlTableModel+= """
<row>
 <enable>${it[0]}</enable>
<location>${it[1]}</location>
</row>
""" }
		String xmlAll="""
<antHelper>
 <antHome>${model.antHome}</antHome>
 <locationTableModel>
${xmlTableModel}
</locationTableModel>
</antHelper>
"""
		mPropertyFile.write(xmlAll)

	}

	def buildTarget(AntHelperModel model) {
		AntWorker worker=new AntWorker()
		worker.setAntHome(model.antHome)
		worker.setTarget(model.target)
		worker.setBuildFile(model.buildFileName)
		worker.setOutput(taOutput)
		worker.setLocations(getLocations(model.locationListTableModel))

		worker.buildAll()
	}

	def getLocations(LocationTableModel tableModel) {
		def locations=[]
		tableModel.each {
			if(it[0]==true) {
				locations<<it[tableModel.findColumn("Location")]
			}
		}

		return locations
	}

	private void updateUI()
	{
		tfAntHome.text=mDataModel.antHome
		tfBuildFileName.text=mDataModel.buildFileName
		tfTarget.text=mDataModel.target
		tfLoation.text=mDataModel.location

	}
}
