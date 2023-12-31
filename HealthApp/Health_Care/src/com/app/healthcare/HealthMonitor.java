package com.app.healthcare;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;



public class HealthMonitor {

	private Map<String, VitalSigns> vitalSigns;
    private Timer timer;

    public HealthMonitor() {
        vitalSigns = new HashMap<>();
        timer = new Timer();
    }

    public void addVitalSign(String name) {
        vitalSigns.put(name, new VitalSigns(name));
    }

    public void startMonitoring() {
        for (VitalSigns vitalSign : vitalSigns.values()) {
            timer.schedule(new MonitorTask(vitalSign), 0, 5000);  // Monitor every 5 seconds
        }
    }

    
    private class MonitorTask extends TimerTask {
       
    	private VitalSigns vitalSign;

        public MonitorTask(VitalSigns vitalSign) {
            this.vitalSign = vitalSign;
        }

        @Override
        public void run() {
            vitalSign.generateRandomValue();
            System.out.println(vitalSign.getName() + ": " + vitalSign.getValue());

            // Check for abnormal readings and send alerts
            if (vitalSign.getName().equals("Heart Rate") && (vitalSign.getValue() < 60 || vitalSign.getValue() > 100)) {
                System.out.println("Abnormal heart rate detected! Alert sent.");                
            }
            else if (vitalSign.getName().equals("Blood Pressure") && (vitalSign.getValue() < 90 || vitalSign.getValue() > 140)) {
                System.out.println("Abnormal blood pressure detected! Alert sent.");
            }         
            else if (vitalSign.getName().equals("Body Temperature") && (vitalSign.getValue() < 36.0 || vitalSign.getValue() > 38.0)) {
                System.out.println("Abnormal body temperature detected! Alert sent.");               
            }
        }
    }
}
