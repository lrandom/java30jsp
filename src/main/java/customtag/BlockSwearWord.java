package customtag;

import jakarta.servlet.jsp.JspContext;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.*;

import java.io.IOException;

public class BlockSwearWord extends SimpleTagSupport {
    private String[] swearWords = new String[]{
            "shit", "damn"
    };
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter jspWriter = getJspContext().getOut();
        String filterContent = "";
        for (String swearWord : swearWords
        ) {
            filterContent = this.content.replaceAll(swearWord, "***");
        }
        jspWriter.write(filterContent);
    }

    @Override
    public void setParent(JspTag parent) {
    }


    @Override
    public void setJspContext(JspContext pc) {
        super.setJspContext(pc);
    }

    @Override
    protected JspContext getJspContext() {
        return super.getJspContext();
    }

    @Override
    public void setJspBody(JspFragment jspBody) {
        super.setJspBody(jspBody);
    }

    @Override
    protected JspFragment getJspBody() {
        return super.getJspBody();
    }
}
