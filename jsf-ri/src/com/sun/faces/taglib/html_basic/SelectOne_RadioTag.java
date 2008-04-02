/*
 * $Id: SelectOne_RadioTag.java,v 1.30 2003/09/25 16:36:33 rlubke Exp $
 */

/*
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.faces.taglib.html_basic;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectOne;

/**
 * This class is the tag handler that evaluates the 
 * <code>selectone_radio</code> custom tag.
 */

public class SelectOne_RadioTag extends SelectOne_ListboxTag
{
    //
    // Protected Constants
    //

    //
    // Class Variables
    //

    //
    // Instance Variables
    //

    // Attribute Instance Variables

    protected String layout = null;
    protected String border = null;


    // Relationship Instance Variables

    //
    // Constructors and Initializers    
    //

    public SelectOne_RadioTag()
    {
        super();
    }

    //
    // Class methods
    //

    // 
    // Accessors
    //

    public void setLayout(String newLayout) {
	layout = newLayout;
    }

    public void setBorder(String newBorder) {
	border = newBorder;
    }

    //
    // General Methods
    //

    public String getRendererType() { 
        return "Radio"; 
    }
    public String getComponentType() { 
        return "SelectOne"; 
    }

    protected void overrideProperties(UIComponent component) {
	super.overrideProperties(component);
	UISelectOne uiSelectOne = (UISelectOne) component;
	
        if (null != layout) {
	    uiSelectOne.getAttributes().put("layout", layout);
	}
        if (null != border) {
	    uiSelectOne.getAttributes().put("border", layout);
	}
    }
    //
    // Methods from TagSupport
    // 


} // end of class SelectOne_RadioTag
