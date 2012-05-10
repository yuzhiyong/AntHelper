package cn.yzy.antHelper.uiimport javax.swing.table.AbstractTableModel

class LocationTableModel extends AbstractTableModel{	def mRowList	def colNames=['Enable', 'Location']	def LocationTableModel(def rowList)	{		this.mRowList=rowList	}	@Override	public int getColumnCount()	{		return colNames.size	}	@Override	public Class getColumnClass(int col)	{		if (getColumnName(col)=='Enable')		{			return Boolean.class		}		return String.class	}	@Override	public String getColumnName(int col)	{		return colNames[col]	}	@Override	public int getRowCount()	{		return this.mRowList.size	}	@Override	public Object getValueAt(int row, int col)	{		def value=mRowList[row][col]		if(value != null)		{			return value		}		return ''	}	@Override	public boolean isCellEditable(int row, int col)	{		if(getColumnName(col)=='Enable')		{			return true		}		return false	}	@Override	public void setValueAt(def value, int row, int col)	{		if (value !=null && value instanceof Boolean)		{			mRowList[row][col]=value		}	}	def addNew(String location)	{		def newRow=[true, location]		if(!mRowList.contains(newRow))		{			mRowList<<newRow		}		fireTableDataChanged()	}	def remove(int idx)	{		mRowList.remove(idx)		fireTableDataChanged()	}}