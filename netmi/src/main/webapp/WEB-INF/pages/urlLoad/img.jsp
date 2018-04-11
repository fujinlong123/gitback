<%@ page language="java" contentType="image/png"
    pageEncoding="UTF-8"%>
<%

ServletOutputStream sos = response.getOutputStream();  
sos.write((byte[])(request.getAttribute("binary")));  
sos.flush();  
sos.close();
response.flushBuffer();  
out.clear();  
out = pageContext.pushBody();  
%>