/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.enterprise;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the Enterprise class persistable, see also EnterpriseDaoTest and liquibase.xml
@Entity(name = "enterprise")
@Table(name = "enterprise")
public class Enterprise extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column(name = "enterprise_id")
	private Integer id;
	
	//	@ManyToMany
	//	@JoinTable(name = "enterprise_location_mapping", joinColumns = { @JoinColumn(name = "enterprise_id") }, inverseJoinColumns = { @JoinColumn(name = "location_id") })
	//	private Set<Location> locations = new HashSet<Location>();
	
	/*
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	*/
	@Basic
	@Column(name = "name", length = 255)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Basic
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Basic
	@Column(name = "city_village")
	private String cityOrVillage;
	
	@Basic
	@Column(name = "state_province")
	private String stateOrProvince;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "web")
	private String webAddress;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phoneNumber;
	
	@Column(name = "contact_person")
	private String contactPerson;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	//	public void addLocation(Location location) {
	//		this.getLocations().add(location);
	//	}
	//	
	//	public Set<Location> getLocations() {
	//		return locations;
	//	}
	//	
	//	public void setLocations(Set<Location> locations) {
	//		this.locations = locations;
	//	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getCityOrVillage() {
		return cityOrVillage;
	}
	
	public void setCityOrVillage(String cityOrVillage) {
		this.cityOrVillage = cityOrVillage;
	}
	
	public String getStateOrProvince() {
		return stateOrProvince;
	}
	
	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getWebAddress() {
		return webAddress;
	}
	
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
}
