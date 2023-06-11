package com.app.healthcare;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class VitalSigns {

	    private String name;
	    private double value;

	    public VitalSigns(String name) {
	        this.name = name;
	        this.value = 0.0;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getValue() {
	        return value;
	    }

	    public void generateRandomValue() {
	    	
	        // Simulating random vital sign readings within a certain range
	        Random random = new Random();
	        
	        if (name.equals("Heart Rate")) {
	            value = random.nextInt(70) + 60;  // Range: 60-130 bpm
	        } else if (name.equals("Blood Pressure")) {
	            value = random.nextInt(50) + 100;  // Range: 100-150 mmHg
	        } else if (name.equals("Body Temperature")) {
	            value = random.nextDouble() + 36.5;  // Range: 36.5-37.5 °C
	        }
	    }
}
