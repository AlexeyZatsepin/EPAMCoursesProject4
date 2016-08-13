package controller.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/13/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class CustomTag extends SimpleTagSupport{

    private String message;
    private StringWriter sw = new StringWriter();

    public void setMessage(String msg) {
        this.message = msg;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (message != null) {
          /* Use message from attribute */
            JspWriter out = getJspContext().getOut();
            out.println( message );
        }
        else {
          /* use message from the body */
            getJspBody().invoke(sw);
            getJspContext().getOut().println(sw.toString());
        }
    }
}
