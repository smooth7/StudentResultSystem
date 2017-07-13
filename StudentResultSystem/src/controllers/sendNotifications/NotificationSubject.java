package controllers.sendNotifications;

import java.util.ArrayList;

public class NotificationSubject implements Subject {

	private ArrayList<Observer> observers;
	
	private String message;
	private String userType;
	private String userId;
	
	public NotificationSubject(){
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
			observer.update(message);
			
		}
		
	}
	
	public void setMessage(String message){
		this.message = message;
		notifyObserver();
	}

}
