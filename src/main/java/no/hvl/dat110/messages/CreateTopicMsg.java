package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	
	// message sent from client to create topic on the broker
    private String topic;

    public CreateTopicMsg(String user, String topic) {
        super(MessageType.CREATETOPIC, user);
        this.topic = topic;
    }

    // getter and setter methods
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    // toString method
    @Override
    public String toString() {
        return "CreateTopicMsg [user=" + getUser() + ", topic=" + topic + "]";
    }
}


