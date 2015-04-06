package sale.xiao.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import sale.xiao.entity.Pagination;

/**
 * @description 标签
 * @author Administrator
 *
 */
public class PaginationTag extends SimpleTagSupport {
    
    private Pagination<?> pagination;

    private String        queryForm = "queryForm";

    private String        divId     = "paginationId";

    private String        divClass  = "technorati";



    @Override
    public void doTag() throws JspException, IOException {
        // 参数验证
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("<script type=\"text/javascript\">");
        strBuf.append("var page_queryForm = document.forms['").append(this.queryForm).append("'];")
                .append(" function page_toPage(pageNo){").append(" page_queryForm.pageNo.value=").append("pageNo;")
                .append("page_queryForm.submit();").append("}").append("</script>");

        strBuf.append("<div id=\"").append(this.divId).append("\" class=\"").append(this.divClass).append("\">");

        // 上一页
        if (pagination.getPageNo() == 1) {
            strBuf.append("<span class=\"disabled\">").append("<< </span>");
        } else {
            strBuf.append(" <a href=\"#\" onclick=\"page_toPage(").append(pagination.getPageNo() - 1)
                    .append(")\"> << </a> ");
        }

        for (int i = this.pagination.getStartIndex(); i <= this.pagination.getEndIndex(); i++) {
            if (this.pagination.getPageNo() == i) {
                strBuf.append("<span class=\"current\">").append(i).append("</span>");
            } else {
                strBuf.append("<a href=\"#\"").append(" onclick=\"page_toPage(").append(i).append(");\">").append(i)
                        .append("</a>");
            }

        }
        
        // 下一页
        if (pagination.getPageNo() == pagination.getTotalPage()) {
            strBuf.append(" <span class=\"disabled\">").append(" >> </span> ");
        } else {
            strBuf.append(" <a href=\"#\" onclick=\"page_toPage(").append(pagination.getPageNo() + 1)
                    .append(")\"> >> </a> ");
        }

        strBuf.append("<span class=\"info\">(第").append(pagination.getPageNo()).append("/")
                .append(pagination.getTotalPage()).append("页").append(" 共").append(pagination.getTotalRecord())
                .append("条)</span>").append("</div>");

        JspContext ctx = getJspContext();
        JspWriter out = ctx.getOut();
        out.print(strBuf.toString());
    }



    public Pagination<?> getPagination() {
        return pagination;
    }



    public void setPagination(Pagination<?> pPagination) {
        pagination = pPagination;
    }



    public String getQueryForm() {
        return queryForm;
    }



    public void setQueryForm(String pQueryForm) {
        queryForm = pQueryForm;
    }



    public String getDivId() {
        return divId;
    }



    public void setDivId(String pDivId) {
        divId = pDivId;
    }



    public String getDivClass() {
        return divClass;
    }



    public void setDivClass(String pDivClass) {
        divClass = pDivClass;
    }
}
