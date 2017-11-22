package com.bal;

public class Message {
    private String sender;
    private String receiver;
    private int priority;
    private String subject;
    private String content;
    private String service; // test vivibilité => non visible
    private  static int ID = 0;
    private String id;
    
    
  	public Message(String sender, String receiver, int priority, String subject, String content, String service) {
		id = "m" + ID++;
		this.sender = sender;
		this.receiver = receiver;
		this.priority = priority;
		this.subject = subject;
		this.content = content;
		this.service = service;
	}

    public String getId() {
  		return id;
  	}

  	public void setId(String id) {
  		this.id = id;
  	}
  	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getServiceTest() {
		return service;
	}

	public void setServiceTest(String service) {
		this.service = service;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String toString(){
    	return sender + " sends " + subject + " detail: " + content;
    }

}
