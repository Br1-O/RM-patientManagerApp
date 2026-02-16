/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bring Online
 */
public class JPAUtil {
    
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {
            
            Path appData = Paths.get(System.getProperty("user.home"), ".patientManager");
            Path dbFile = appData.resolve("patient.db");

            try {
                if (!Files.exists(appData)) {
                    Files.createDirectories(appData);
                }

                // Copy db from JAR if not exists
                if (!Files.exists(dbFile)) {
                    try (InputStream is = JPAUtil.class.getResourceAsStream("/data/patient.db")) {
                        if (is == null) {
                            throw new FileNotFoundException("No se encontró el recurso /data/patient.db en el JAR");
                        }
                        Files.copy(is, dbFile);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al preparar la base de datos", e);
            }

            // EntityManagerFactory pointing to user's db instance in their computer
            Map<String, Object> props = new HashMap<>();
            props.put("javax.persistence.jdbc.url", "jdbc:sqlite:" + dbFile.toAbsolutePath());


            emf = Persistence.createEntityManagerFactory("patientPU", props);
        }

        return emf;
    }
    
    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}
