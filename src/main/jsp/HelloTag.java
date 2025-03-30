package main.jsp;


import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.util.Arrays;

public class HelloTag extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().print("Hello World");
        } catch (IOException e) {
            try {
                pageContext.getOut().print(Arrays.toString(e.getStackTrace()));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        return EVAL_PAGE;
    }
}
