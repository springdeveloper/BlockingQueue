package com.app.navneet;

public class Message {
private final String subject;
private final String message;
public String getSubject() {
	return subject;
}
public String getMessage() {
	return message;
}
public Message(String subject, String message) {
	super();
	this.subject = subject;
	this.message = message;
}
@Override
public String toString() {
	return "Message [subject=" + subject + ", message=" + message + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((message == null) ? 0 : message.hashCode());
	result = prime * result + ((subject == null) ? 0 : subject.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Message other = (Message) obj;
	if (message == null) {
		if (other.message != null)
			return false;
	} else if (!message.equals(other.message))
		return false;
	if (subject == null) {
		if (other.subject != null)
			return false;
	} else if (!subject.equals(other.subject))
		return false;
	return true;
}


}
