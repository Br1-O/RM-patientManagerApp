/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.time;

import com.bo.patientmanager.model.Session;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    
    public static List<String> formatSessionsLabels(List<Session> sessions) {
        
        List<String> formattedSessionText = new ArrayList<>();

        if (sessions == null || sessions.isEmpty()) return formattedSessionText;;

        java.time.format.DateTimeFormatter tf =
                java.time.format.DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < sessions.size() && i < 3; i++) {

            Session s = sessions.get(i);

            String text =
                    s.getDayOfWeek().getDisplayName(
                            java.time.format.TextStyle.FULL,
                            new java.util.Locale("es", "AR")
                    )
                    + " "
                    + s.getFrom().format(tf)
                    + " - "
                    + s.getTo().format(tf);

            formattedSessionText.add(text);
        }
        
        return formattedSessionText;
    }
    
    public static String nullSafe(String v) {
        return (v == null || v.isBlank()) ? "-" : v;
    }
}
