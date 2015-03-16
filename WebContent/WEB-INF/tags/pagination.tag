<%@ tag language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tagtlds/page.tld" prefix="page"%>
<%@ attribute name="currentPage" required="true" type="java.lang.Integer"%>
<%@ attribute name="totalSize" required="false" type="java.lang.Integer"%>
<%@ attribute name="pageSize" required="false" type="java.lang.Integer"%>
<%@ attribute name="formName" required="false" type="java.lang.String"%>

<page:Pagination pagination=""/>