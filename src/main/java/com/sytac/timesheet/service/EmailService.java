package com.sytac.timesheet.service;

public interface EmailService {
    void send(final String to, final String subject, final String text, final String pathToAttachment);
}
