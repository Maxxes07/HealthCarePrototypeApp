package com.app.healthcare;

public class HealthMonitorApp {

	public static void main(String[] args) {
		
		HealthMonitor monitor = new HealthMonitor();

        // Adding vital signs to monitor
        monitor.addVitalSign("Heart Rate");
        monitor.addVitalSign("Blood Pressure");
        monitor.addVitalSign("Body Temperature");

        monitor.startMonitoring();

	}

}
