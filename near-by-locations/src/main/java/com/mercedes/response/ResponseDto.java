package com.mercedes.response;

public class ResponseDto {

	private Response response;

	public ResponseDto() {
		super();
	}
	public ResponseDto(Response response) {
		super();
		this.response = response;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ResponseDto [response=" + response + "]";
	}
}
