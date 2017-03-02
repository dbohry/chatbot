package com.danielbohry.controller

import org.springframework.context.ConfigurableApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class ChatBotControllerTest extends Specification {

    @Shared
    @AutoCleanup
    ConfigurableApplicationContext context

    void cleanupSpec() {
        if (context != null) {
            context.close()
        }
    }

    void "testing spock works"() {
        expect:
        true;
    }

    void "should return Greetings from ChatBot!"() {
        when: 'I go to the homepage'
        ResponseEntity entity = new RestTemplate().getForEntity("http://localhost:8080/chatbot/", String)

        then: 'I get a greeting'
        entity.statusCode == HttpStatus.OK
        entity.body == "Hi I'm just a bot!"
    }

    void "should return the response as awnser"() {
        String msg = "hi there mr bot"

        when: 'I ask for a response to the bot'
        ResponseEntity entity = new RestTemplate()
                .getForEntity("http://localhost:8080/chatbot/answerme?msg=" + msg, String)

        then: 'I get a greeting'
        entity.statusCode == HttpStatus.OK
        entity.body == "Seriously have you asked me " + msg + "?"
    }

}
