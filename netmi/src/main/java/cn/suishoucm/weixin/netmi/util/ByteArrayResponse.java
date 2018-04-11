package cn.suishoucm.weixin.netmi.util;

import java.nio.charset.Charset;

public class ByteArrayResponse {
	private Integer statusCode;
	private byte[] responseBody;
	private String mimeType;
	private String fileName;
	private Charset charset;

	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public byte[] getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(byte[] responseBody) {
		this.responseBody = responseBody;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Charset getCharset() {
		return charset;
	}
	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	
	
	
	

}
