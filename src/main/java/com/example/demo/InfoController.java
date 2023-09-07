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
    public InfoResponse getInfo(@RequestParam int utcOffset, String statusCode) {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String currentDayOfWeek = dayOfWeek.toString();

        // Validate UTC offset within +/-2
        if (utcOffset < -2 || utcOffset > 2) {
            // Return an error response with a custom status code
            throw new InvalidUtcOffsetException();
        }

        // Set the 'slackName' directly in your code
        String slackName = "leslie";
        String track = "Backend";

        // Construct the response using a record
        InfoResponse response = new InfoResponse(
            slackName,
            currentDayOfWeek,
            now.toString(),
            track,
            "URL to the GitHub file being run",
            "https://github.com/nkemsileslie/Java-Spring-Boot-Endpoint",
            statusCode = "200"
        );

        return response;
    }

    record InfoResponse(
        String slackName,
        String currentDayOfWeek,
        String currentUtcTime,
        String track,
        String gitHubFileUrl,
        String gitHubSourceUrl,
        String statusCode
    ) {}
}
