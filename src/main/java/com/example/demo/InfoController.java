package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
public class InfoController {
    
    @GetMapping("/get-info")
    public InfoResponse getInfo(
        @RequestParam String slackName,
        @RequestParam int utcOffset
    ) {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String currentDayOfWeek = dayOfWeek.toString();

        //Validate UTC offset within +/_2
        if(utcOffset < -2 || utcOffset > 2){
            //Return an error response with custom status code
            throw new InvalidUtcOffsetException();
        }

        // Construct the response
        InfoResponse response = new InfoResponse();
        response.setSlackName(slackName);
        response.setCurrentDayOfWeek(currentDayOfWeek);
        response.setCurrentUtcTime(now.toString());
        response.setTrack("Backend");
        response.setGitHubFileUrl("");
        response.setGithubSourceUrl("");

        return response;

    }
}
