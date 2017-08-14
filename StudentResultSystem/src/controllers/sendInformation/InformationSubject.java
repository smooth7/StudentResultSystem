package controllers.sendInformation;

import java.util.ArrayList;

public class InformationSubject implements SubjectInterface {

	private ArrayList<ObserverInterface> observers;
	
	private String message;
	
	public InformationSubject(){
		observers = new ArrayList<ObserverInterface>();
	}
	
	@Override
	public void addObserver(ObserverInterface newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void removeObserver(ObserverInterface observer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notifyObserver() {

		for(ObserverInterface observer : observers){
			observer.updateNotice(message);
			
		}
		
	}
	
	public void setMessage(String message){
		this.message = message;
		notifyObserver();
	}

}
