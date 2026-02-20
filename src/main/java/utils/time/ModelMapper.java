/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.time;

import com.bo.patientmanager.model.Session;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bring Online
 */
public class ModelMapper {
    
    public static String formatSessions(List<Session> sessions) {

    if (sessions == null || sessions.isEmpty()) {
        return "-";
    }

    DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");

    return sessions.stream()
        .map(s ->
            DateMapper.dayToSpanish(s.getDayOfWeek()) + " " +
            s.getFrom().format(tf) + " - " +
            s.getTo().format(tf)
        )
        .collect(Collectors.joining(" | "));
}
}
