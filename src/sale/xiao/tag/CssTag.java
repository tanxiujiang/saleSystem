package sale.xiao.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 分页样式 <class description>
 * 
 * @author: harrytan
 * @version: 1.0, Apr 7, 2015
 */
public class CssTag extends SimpleTagSupport {
    // 判断是否启用该样式
    private boolean enable;



    /**
     * 重写，然后输出样式信息
     * 
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     */
    @Override
    public void doTag() throws JspException, IOException {
        if (enable) {
            JspContext ctx = getJspContext();
            JspWriter out = ctx.getOut();
            out.print(this.getCssElement().toString());
        } else {
            super.doTag();
        }
    }



    /**
     * 
     * <method description> 样式拼接
     * 
     * @return
     */
    private StringBuffer getCssElement() {
        StringBuffer cssStr = new StringBuffer();
        cssStr.append("<style type=\"text/css\"> ");
        cssStr.append("DIV.technorati {PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 3px; MARGIN: 3px; PADDING-TOP: 3px; TEXT-ALIGN: center}");
        cssStr.append("DIV.technorati A {BORDER-RIGHT: #ccc 1px solid; PADDING-RIGHT: 6px; BACKGROUND-POSITION: 50% bottom; BORDER-TOP: #ccc 1px solid; PADDING-LEFT: 6px; FONT-WEIGHT: bold; PADDING-BOTTOM: 2px; BORDER-LEFT: #ccc 1px solid; COLOR: rgb(66,97,222); MARGIN-RIGHT: 3px; PADDING-TOP: 2px; BORDER-BOTTOM: #ccc 1px solid; TEXT-DECORATION: none}");
        cssStr.append("DIV.technorati A:hover {BACKGROUND-IMAGE: none; COLOR: #fff; BACKGROUND-COLOR: #4261df}");
        cssStr.append("DIV.technorati A:active {BACKGROUND-IMAGE: none; COLOR: #fff; BACKGROUND-COLOR: #4261df}");
        cssStr.append("DIV.technorati SPAN.current {PADDING-RIGHT: 6px; PADDING-LEFT: 6px; FONT-WEIGHT: bold; PADDING-BOTTOM: 2px; COLOR: #000; MARGIN-RIGHT: 3px; PADDING-TOP: 2px}");
        cssStr.append("DIV.technorati SPAN.disabled {BORDER-RIGHT: #eee 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #eee 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; MARGIN: 2px; BORDER-LEFT: #eee 1px solid; COLOR: #ddd; PADDING-TOP: 2px; BORDER-BOTTOM: #eee 1px solid}");
        cssStr.append("</style>");
        return cssStr;
    }



    public boolean isEnable() {
        return enable;
    }



    public void setEnable(boolean pEnable) {
        enable = pEnable;
    }
}
