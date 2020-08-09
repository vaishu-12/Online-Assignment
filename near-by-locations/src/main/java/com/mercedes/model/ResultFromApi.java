package com.mercedes.model;

//This Model holds exact data received from requested api. that is results.
public class ResultFromApi {
	
	private Result results;
	
	public ResultFromApi() {
		super();
	}

	public ResultFromApi(Result results) {
		super();
		this.results = results;
	}

	public Result getResults() {
		return results;
	}

	public void setResults(Result results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ResponseDto [results=" + results + "]";
	}
	
	
	
}
