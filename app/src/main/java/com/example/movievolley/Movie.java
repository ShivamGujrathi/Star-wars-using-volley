package com.example.movievolley;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Movie{

	@SerializedName("next")
	private Object next;

	@SerializedName("previous")
	private Object previous;

	@SerializedName("count")
	private int count;

	@SerializedName("results")
	private List<ResultsItem> results;

	public Movie(String title) {
	}

    public Object getNext(){
		return next;
	}

	public Object getPrevious(){
		return previous;
	}

	public int getCount(){
		return count;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}