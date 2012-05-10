package cn.yzy.antHelper.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AntHelperModel
{
	private String antHome="";
	private String location="";
	private String buildFileName="build.xml";
	private String target="compile.jasperreports";
	private LocationTableModel locationListTableModel=new LocationTableModel(new ArrayList<String>());

	public String getAntHome()
	{
		return antHome;
	}

	public void setAntHome(String antHome)
	{
		this.antHome = antHome;
	}

	public String getBuildFileName()
	{
		return buildFileName;
	}

	public void setBuildFileName(String buildFileName)
	{
		this.buildFileName = buildFileName;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	public AbstractTableModel getLocationListTableModel()
	{
		return locationListTableModel;
	}

	public void setLocationListTableModel(LocationTableModel locationListTableModel)
	{
		this.locationListTableModel = locationListTableModel;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

}
