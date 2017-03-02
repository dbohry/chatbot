package com.danielbohry.controller

import com.danielbohry.service.ChatBotService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chatbot")
class ChatBotController {

    @Autowired
    ChatBotService service

    @RequestMapping(value="/", method=RequestMethod.GET)
    String hi() {
        return "Hi I'm just a bot!"
    }

    @RequestMapping(value = "answerme", method=RequestMethod.GET)
    @ResponseBody
    def answerme(@RequestParam("msg") String request) {
        service.answerme(request)
    }

}
