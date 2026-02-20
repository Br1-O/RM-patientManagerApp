/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.time;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author Bring Online
 */
public class DateMapper {
    
    public static DayOfWeek mapDay(String s) {

        if (s == null || s.equals("-") || s.equals(" ")) return null;

        return switch (s) {
            case "Lunes"     -> DayOfWeek.MONDAY;
            case "Martes"    -> DayOfWeek.TUESDAY;
            case "Miercoles" -> DayOfWeek.WEDNESDAY;
            case "Jueves"    -> DayOfWeek.THURSDAY;
            case "Viernes"   -> DayOfWeek.FRIDAY;
            case "Sabado"    -> DayOfWeek.SATURDAY;
            default -> null;
        };
    }
    
    public static LocalTime mapHour(String s) {

        if (s == null || s.equals("-")) return null;

        return LocalTime.parse(s);
    }
    
    public static String dayToSpanish(DayOfWeek d) {

        return switch (d) {
            case MONDAY    -> "Lunes";
            case TUESDAY   -> "Martes";
            case WEDNESDAY -> "Miércoles";
            case THURSDAY  -> "Jueves";
            case FRIDAY    -> "Viernes";
            case SATURDAY  -> "Sábado";
            case SUNDAY    -> "Domingo";
        };
    }
    
}
