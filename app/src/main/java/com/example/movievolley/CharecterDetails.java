package com.example.movievolley;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CharecterDetails implements Parcelable {

	@SerializedName("films")
	private List<String> films;

	@SerializedName("homeworld")
	private String homeworld;

	@SerializedName("gender")
	private String gender;

	@SerializedName("skin_color")
	private String skinColor;

	@SerializedName("edited")
	private String edited;

	@SerializedName("created")
	private String created;

	@SerializedName("mass")
	private String mass;

	@SerializedName("vehicles")
	private List<String> vehicles;

	@SerializedName("url")
	private String url;

	@SerializedName("hair_color")
	private String hairColor;

	@SerializedName("birth_year")
	private String birthYear;

	@SerializedName("eye_color")
	private String eyeColor;

	@SerializedName("species")
	private List<Object> species;

	@SerializedName("starships")
	private List<String> starships;

	@SerializedName("name")
	private String name;

	@SerializedName("height")
	private String height;

	protected CharecterDetails(Parcel in) {
		films = in.createStringArrayList();
		homeworld = in.readString();
		gender = in.readString();
		skinColor = in.readString();
		edited = in.readString();
		created = in.readString();
		mass = in.readString();
		vehicles = in.createStringArrayList();
		url = in.readString();
		hairColor = in.readString();
		birthYear = in.readString();
		eyeColor = in.readString();
		starships = in.createStringArrayList();
		name = in.readString();
		height = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringList(films);
		dest.writeString(homeworld);
		dest.writeString(gender);
		dest.writeString(skinColor);
		dest.writeString(edited);
		dest.writeString(created);
		dest.writeString(mass);
		dest.writeStringList(vehicles);
		dest.writeString(url);
		dest.writeString(hairColor);
		dest.writeString(birthYear);
		dest.writeString(eyeColor);
		dest.writeStringList(starships);
		dest.writeString(name);
		dest.writeString(height);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<CharecterDetails> CREATOR = new Creator<CharecterDetails>() {
		@Override
		public CharecterDetails createFromParcel(Parcel in) {
			return new CharecterDetails(in);
		}

		@Override
		public CharecterDetails[] newArray(int size) {
			return new CharecterDetails[size];
		}
	};

	public List<String> getFilms(){
		return films;
	}

	public String getHomeworld(){
		return homeworld;
	}

	public String getGender(){
		return gender;
	}

	public String getSkinColor(){
		return skinColor;
	}

	public String getEdited(){
		return edited;
	}

	public String getCreated(){
		return created;
	}

	public String getMass(){
		return mass;
	}

	public List<String> getVehicles(){
		return vehicles;
	}

	public String getUrl(){
		return url;
	}

	public String getHairColor(){
		return hairColor;
	}

	public String getBirthYear(){
		return birthYear;
	}

	public String getEyeColor(){
		return eyeColor;
	}

	public List<Object> getSpecies(){
		return species;
	}

	public List<String> getStarships(){
		return starships;
	}

	public String getName(){
		return name;
	}

	public String getHeight(){
		return height;
	}
}