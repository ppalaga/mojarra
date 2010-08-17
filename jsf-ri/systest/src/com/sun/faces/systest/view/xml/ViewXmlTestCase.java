/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2010 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.faces.systest.view.xml;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.sun.faces.htmlunit.AbstractTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * <p>Test Case for JSP Interoperability.</p>
 */

public class ViewXmlTestCase extends AbstractTestCase {


    // ------------------------------------------------------------ Constructors


    /**
     * Construct a new instance of this test case.
     *
     * @param name Name of the test case
     */
    public ViewXmlTestCase(String name) {
        super(name);
    }


    // ------------------------------------------------------ Instance Variables


    // ---------------------------------------------------- Overall Test Methods


    /**
     * Set up instance variables required by this test case.
     */
    public void setUp() throws Exception {
        super.setUp();
    }


    /**
     * Return the tests included in this test suite.
     */
    public static Test suite() {
        return (new TestSuite(ViewXmlTestCase.class));
    }


    /**
     * Tear down instance variables required by this test case.
     */
    public void tearDown() {
        super.tearDown();
    }


    // ------------------------------------------------- Individual Test Methods


    public void testPrefixAndExtensionMapping() throws Exception {
        doTest("/view.xml/templateClientUsingXmlAndXhtml.faces", "foo", "bar");
        doTest("/faces/view.xml/templateClientUsingXmlAndXhtml.view.xml", "baz", "baba");
    }

    public void testSimpleXml() throws Exception {
        HtmlPage page = getPage("/view.xml/index.faces");
        String text = page.asText();
        assertTrue(text.matches("(?s).*Raw XML View\\s*hello\\s*reload.*"));


    }

    private void doTest(String path, String param1, String param2) throws Exception {
        HtmlPage page = getPage(path + "?param1=" + param1 + "&param2=" + param2);
        String text = page.asText();
        assertTrue(text.matches("(?s).*Templating and XML views\\s*column1\\s*column2\\s*column3\\s*This is the header text declared in xhtmlTemplate.xhtml. The preceding columns are declared in header.view.xml.\\s*hello\\s*reload\\s*HTML table column 1\\s*HTML table column 2\\s*" + 
                param1 + "\\s*" + param2 + ".*"));
        HtmlSubmitInput button = (HtmlSubmitInput) page.getElementById("button");
        page = button.click();
        text = page.asText();
        assertTrue(text.matches("(?s).*Templating and XML views\\s*column1\\s*column2\\s*column3\\s*This is the header text declared in xhtmlTemplate.xhtml. The preceding columns are declared in header.view.xml.\\s*hello\\s*reload\\s*HTML table column 1\\s*HTML table column 2\\s*" +
                param1 + "\\s*" + param2 + ".*"));
        
    }

}
