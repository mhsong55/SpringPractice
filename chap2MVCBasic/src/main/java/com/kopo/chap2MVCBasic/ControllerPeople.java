package com.kopo.chap2MVCBasic;

public class ControllerPeople {
	private ModelPeople model;
	private ViewPeople view;
	
	public ControllerPeople(ModelPeople model, ViewPeople view) {
		this.model = model;
		this.view = view;
	}
	
	public void setPeopleName(String name) {
		model.setName(name);
	}
	
	public String getPeopleName() {
		return model.getName();
	}
	
	public void setPeopleHobby(String hobby) {
		model.setHobby(hobby);
	}
	
	public String getPeopleHobby() {
		return model.getHobby();
	}
	
	public void updateView() {
		view.printPeopleProfile(model.getName(), model.getHobby());
	}
}
