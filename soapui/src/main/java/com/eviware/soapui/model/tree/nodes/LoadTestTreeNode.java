/*
 *  SoapUI, copyright (C) 2004-2012 smartbear.com
 *
 *  SoapUI is free software; you can redistribute it and/or modify it under the
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  SoapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.LoadTest;
import com.eviware.soapui.model.tree.AbstractModelItemTreeNode;
import com.eviware.soapui.model.tree.SoapUITreeModel;

/**
 * SoapUITreeNode for LoadTest implementations
 * 
 * @author Ole.Matzura
 */

public class LoadTestTreeNode extends AbstractModelItemTreeNode<LoadTest>
{
	public LoadTestTreeNode( LoadTest loadTest, ModelItem parent, SoapUITreeModel treeModel )
	{
		super( loadTest, parent, treeModel );
	}
}
