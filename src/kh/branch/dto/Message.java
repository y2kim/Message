package kh.branch.dto;

public class Message {
	
	/*
	message_id number primary key,
    name varchar(20) not null,
    message varchar(200) not null
	 */
	
	int messageId;
	String name, message;
	
	public Message() {
		super();
	}

	public Message(int messageId, String name, String message) {
		super();
		this.messageId = messageId;
		this.name = name;
		this.message = message;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
