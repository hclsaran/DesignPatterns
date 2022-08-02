package com.saran.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

// onetoone dependency -> when one object changes the state all other dependent objs
//are notified and update as well
//Observer design pattern is a part of Behvioral Design Pattern

//Comcast TV  channel 
/*
 *  fatmana->standard package (50 channels)
 *  saniya ->silver package   (100 channels)
 *  creigh -> gold package   (200 channels)
 *  behar ->  platinum package   (All channels)
comcast has millions of users->
you can access only 50 or 100 or all the channel
publish subscribe

has their own messaging servers-> publising a new movie and configuring it to those
who has platinum package

 * 
 * 
 */
abstract class Observer{
	protected Subject subject;
	public abstract void update();
}
class Subject{
	private int state;
	private List<Observer> observers=new ArrayList<>();
	
	public List<Observer> getObservers() {
		return observers;
	}
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}
	
	public void notifyAllObservers() {
		for(Observer obs:observers) {
			obs.update();
		}
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	
	
}

class TriObserver extends Observer{
	
	
	TriObserver(Subject subject){
		this.subject=subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
	  System.out.println("Tri String :"+Integer.toHexString(subject.getState()).toUpperCase());
		
	}
	
}

class BinaryObserver extends Observer{
	
	
	BinaryObserver(Subject subject){
		this.subject=subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
	  System.out.println("Binary String :"+Integer.toBinaryString(subject.getState()));
		
	}
	
}

public class ObserverDesignPattern {
	
public static void main(String[] args) {
	
	Subject subject=new Subject();
	new BinaryObserver(subject);
	new TriObserver(subject);
	System.out.println("First  state change :15");
	subject.setState(12);
	System.out.println("Second state change :20");
	subject.setState(18);	
}
}
