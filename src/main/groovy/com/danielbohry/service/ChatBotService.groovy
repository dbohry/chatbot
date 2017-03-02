package com.danielbohry.service

import org.springframework.stereotype.Component

@Component
class ChatBotService {

    String answerme(String request) {
        "Seriously have you asked me " + request + "?"
    }

}
