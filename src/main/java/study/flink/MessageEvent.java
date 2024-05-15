package study.flink;

import lombok.Getter;

@Getter
public class MessageEvent {
private final String identifier; // Identifier can be WhatsApp number or email
private final String channel; // Channel indicates the type of communication, such as WhatsApp or Email
private final String message;



public MessageEvent(String identifier, String channel, String message) {
this.identifier = identifier;
this.channel = channel;
this.message = message;
}
}