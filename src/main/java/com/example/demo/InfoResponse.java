package com.example.demo;

public record InfoResponse(
    String slackName,
    String currentDayOfWeek,
    String currentUtcTime,
    String track,
    String gitHubFileUrl,
    String gitHubSourceUrl,
    String statusCode
) {}
