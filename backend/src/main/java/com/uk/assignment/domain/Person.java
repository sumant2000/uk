package com.uk.assignment.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "first_name", "last_name", "age", "favourite_colour", "hobby" })
@Data
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long personId;

	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("age")
	private String age;
	@JsonProperty("favourite_colour")
	private String favouriteColour;
	@JsonProperty("hobby")
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> hobby = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Person() {
	}

	/**
	 *
	 * @param favouriteColour
	 * @param lastName
	 * @param age
	 * @param hobby
	 * @param firstName
	 */
	public Person(String firstName, String lastName, String age, String favouriteColour, List<String> hobby) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.favouriteColour = favouriteColour;
		this.hobby = hobby;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("age")
	public String getAge() {
		return age;
	}

	@JsonProperty("age")
	public void setAge(String age) {
		this.age = age;
	}

	@JsonProperty("favourite_colour")
	public String getFavouriteColour() {
		return favouriteColour;
	}

	@JsonProperty("favourite_colour")
	public void setFavouriteColour(String favouriteColour) {
		this.favouriteColour = favouriteColour;
	}

	@JsonProperty("hobby")
	public List<String> getHobby() {
		return hobby;
	}

	@JsonProperty("hobby")
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName).append("age", age)
				.append("favouriteColour", favouriteColour).append("hobby", hobby).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(favouriteColour).append(lastName).append(age)
				.append(hobby).append(firstName).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Person) == false) {
			return false;
		}
		Person rhs = ((Person) other);
		return new EqualsBuilder().append(favouriteColour, rhs.favouriteColour).append(lastName, rhs.lastName)
				.append(age, rhs.age).append(hobby, rhs.hobby)
				.append(firstName, rhs.firstName).isEquals();
	}

}