package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

import java.io.IOException;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// create a client object
		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);

		try {
			// connect to the broker
			client.connect();

			// publish temperature(s)
			for (int i = 0; i < COUNT; i++) {
				// generate a random temperature value
				int temperature = sn.read();

				// publish the temperature to the topic
				client.publish("temperature", String.valueOf(temperature));

				// sleep for a while before publishing the next temperature
				Thread.sleep(1000);
			}

			// disconnect from the broker
			client.disconnect();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Temperature device stopping ... ");

	}
}
