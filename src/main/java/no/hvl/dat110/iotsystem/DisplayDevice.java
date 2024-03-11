package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

import java.io.IOException;

public class DisplayDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		System.out.println("Display starting ...");

		// create a client object
		Client client = new Client("display", Common.BROKERHOST, Common.BROKERPORT);

        // connect to the broker
        client.connect();

        // create the temperature topic on the broker
        client.createTopic("temperature");

        // subscribe to the topic
        client.subscribe("temperature");

        // receive messages on the topic
        for (int i = 0; i < COUNT; i++) {
            // receive a message
            String message = String.valueOf(client.receive());

            // print the received message
            System.out.println("Received temperature: " + message);
        }

        // unsubscribe from the topic
        client.unsubscribe("temperature");

        // disconnect from the broker
        client.disconnect();

        System.out.println("Display stopping ... ");
	}
}


