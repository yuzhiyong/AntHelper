package cn.yzy.antHelper.ui

import java.awt.Container
import java.awt.Toolkit

import javax.swing.BorderFactory
import javax.swing.border.Border
import javax.swing.border.EmptyBorder
import javax.swing.border.EtchedBorder


class SwingUtil
{
	static centerInScreen(Container child)
	{
		int parWd = Toolkit.getDefaultToolkit().getScreenSize().width
		int parHt = Toolkit.getDefaultToolkit().getScreenSize().height
		int x
		int y

		x = ((parWd - child.getSize().width) / 2)
		y = ((parHt - child.getSize().height) / 2)
		child.setLocation(x, y)
	}

	static Border createEtchedBorder()
	{
		return BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5), new EtchedBorder())
	}

	static createEmptyBorder()
	{
		return BorderFactory.createEmptyBorder(2,2,2,2)
	}
}