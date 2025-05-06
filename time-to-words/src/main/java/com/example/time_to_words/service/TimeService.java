package com.example.time_to_words.service;

import com.example.time_to_words.exception.InvalidTimeFormatException;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private static final String[] HOURS = {
        "midnight", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "midday", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twenty one", "twenty two", "twenty three"
    };

    private static final String[] MINUTES = {
        "o'clock", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
        "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty",
        "thirty one", "thirty two", "thirty three", "thirty four", "thirty five", "thirty six",
        "thirty seven", "thirty eight", "thirty nine", "forty", "forty one", "forty two",
        "forty three", "forty four", "forty five", "forty six", "forty seven", "forty eight",
        "forty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
        "fifty six", "fifty seven", "fifty eight", "fifty nine"
    };

    public String convertTimeToWords(String time) {
        if (!time.matches("^\\d{2}:\\d{2}$")) {
            throw new InvalidTimeFormatException("Time must be in HH:mm format");
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour == 0 && minute == 0) return "It's Midnight";
        if (hour == 12 && minute == 0) return "It's Midday";

        String hourWord = HOURS[hour];
        String minuteWord = minute == 0 ? "o'clock" : MINUTES[minute];

        return minute == 0 ? "It's " + hourWord + " " + minuteWord
                           : "It's " + hourWord + " " + minuteWord;
    }
}

