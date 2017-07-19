package controllers.sendInformation;

import java.util.ArrayList;

public class InformationSubject implements Subject {

	private ArrayList<Observer> observers;
	
	private String message;
	
	public InformationSubject(){
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void addObserver(Observer newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notifyObserver() {

		for(Observer observer : observers){
			observer.updateNotice(message);
			
		}
		
	}
	
	public void setMessage(String message){
		this.message = message;
		notifyObserver();
	}

}
