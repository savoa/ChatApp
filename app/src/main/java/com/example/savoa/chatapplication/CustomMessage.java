package com.example.savoa.chatapplication;

/**
 * Created by MITAR on 02-Apr-18.
 */

public class CustomMessage {

    public String message;
    public boolean sending = false;

    public CustomMessage(String m_message, boolean m_type) {
        this.message = m_message;
        this.sending = m_type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSending() {
        return sending;
    }

    public void setSending(boolean sending) {
        this.sending = sending;
    }
}
