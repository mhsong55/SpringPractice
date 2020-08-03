package com.kopo.chap2MVCBasic;

public class MVCApplication {
	
	public static void main(String[] args) {
		// get related information and set them to model
		ModelPeople model = retrievePeople();
		ViewPeople view = new ViewPeople();
		
		ControllerPeople controller = new ControllerPeople(model, view);
		controller.updateView();	// show the updated information
		
		controller.setPeopleName("Lee");	// update the variable
		controller.setPeopleHobby("Playing Soccer");//update the variable
		controller.updateView();	// show the updated information again
	}
	
	public static ModelPeople retrievePeople() {
		ModelPeople model = new ModelPeople();
		model.setName("Song");
		model.setHobby("Listening Music");
		return model;
	}
}
