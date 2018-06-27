package cn.jansen.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BirdMixin {
	
	BirdMixin(@JsonProperty("color") String color) {
	}

	@JsonProperty("name")
	abstract String getName();

	@JsonProperty("category")
	abstract String getCategory();
	
}
