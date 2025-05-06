package com.example.time_to_words.controller;


import com.example.time_to_words.model.TimeResponse;
import com.example.time_to_words.service.TimeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @ApiOperation("Convert 24-hour time to words")
    @GetMapping("/toWords")
    public TimeResponse convertToWords(@RequestParam String time) {
        String result = timeService.convertTimeToWords(time);
        return new TimeResponse(result);
    }
}

