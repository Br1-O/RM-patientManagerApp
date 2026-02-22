/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bo.patientmanager.gui.allPatientsViews;

import com.bo.patientmanager.model.Patient;
import com.bo.patientmanager.model.PatientRelativeRelation;
import com.bo.patientmanager.model.Session;
import com.bo.patientmanager.service.PatientRelativeRelationService;
import com.bo.patientmanager.service.PatientService;
import com.bo.patientmanager.service.ServiceManager;
import com.bo.patientmanager.service.SessionService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import utils.time.ModelMapper;

/**
 *
 * @author Bring Online
 */
public class PatientDataPane extends javax.swing.JPanel {

    /**
     * Creates new form PatientDataPane
     */
    private PatientService patientService = null;
    private SessionService sessionService = null;
    private PatientRelativeRelationService patientRelativeRelationService = null;
    private ServiceManager serviceManager = null;
    Long patientId;
    
    List<PatientRelativeRelation> relatives;

    private DefaultListModel<PatientRelativeRelation> relativesModel;

    /**
     * Creates new form PatientDataPane
     */
    public PatientDataPane(ServiceManager serviceManager, Long patientId) {
        initComponents();
        
        this.setOpaque(false);
                        
        this.patientService = serviceManager.getPatientService();
        this.sessionService = serviceManager.getSessionService();
        this.patientRelativeRelationService = serviceManager.getPatientRelativeRelationService();
        this.serviceManager = serviceManager;
        this.patientId = patientId;
        
        relativesModel = new DefaultListModel<>();
        relativesList.setModel(relativesModel);
        
        loadPatientData(patientId);
        
        relativesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getClickCount() == 2){

                    PatientRelativeRelation selected = relativesList.getSelectedValue();

                    if(selected != null){
                        new RelativeFrame(serviceManager, selected.getId()).setVisible(true);
                    }
                }
            }
        });
    }
    
    public void loadPatientData(Long patientId) {

        var p = patientService.findById(patientId);

        if (p == null) return;

        // --- Datos personales
        name.setText(p.getName());
        lastName.setText(p.getLastName());

        if (p.getBirthday() != null) {
            /**
            birthday.setText(
                p.getBirthday().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );

            age.setText("(" + utils.time.DateUtils.calculateAge(p.getBirthday()) + ")");
            * */
        } else {
            birthday.setText("-");
            //age.setText("");
        }

        address.setText(ModelMapper.nullSafe(p.getAddress()));
        city.setText(ModelMapper.nullSafe(p.getCity()));
        country.setText(ModelMapper.nullSafe(p.getCountry()));
        gender.setText(ModelMapper.nullSafe(p.getGender()));
        state.setText(ModelMapper.nullSafe(p.getState()));

        derivedFrom.setText(ModelMapper.nullSafe(p.getDerivedFrom()));
        derivedTo.setText(ModelMapper.nullSafe(p.getDerivedTo()));

        // --- Contacto
        phone1.setText(ModelMapper.nullSafe(p.getPhone1()));
        phone2.setText(ModelMapper.nullSafe(p.getPhone2()));
        email.setText(ModelMapper.nullSafe(p.getEmail()));
        socials.setText(ModelMapper.nullSafe(p.getSocial()));

        // --- Observaciones
        observations.setText(ModelMapper.nullSafe(p.getInitialObservations()));

        // --- Sesiones
        List<Session> sessions = sessionService.findByPatient(p.getPatientId());
        
        session1.setText("-");
        session2.setText("-");
        session3.setText("-");
        
        List<String> loadedSessionStrings = ModelMapper.formatSessionsLabels(sessions);
        
        if (loadedSessionStrings != null) {
            if (loadedSessionStrings.size() > 0) { 
                session1.setText(loadedSessionStrings.get(0));
            }
            if (loadedSessionStrings.size() > 1) { 
                session2.setText(loadedSessionStrings.get(1));
            }
            if (loadedSessionStrings.size() > 2) { 
                session3.setText(loadedSessionStrings.get(2));
            }
        }
        
        // --- Familiares
        loadRelatives(p);
    }


    private void loadRelatives(Patient patient){

        relativesModel.clear();

        List<PatientRelativeRelation> list = patientRelativeRelationService.findByPatient(patient.getPatientId());

        for(PatientRelativeRelation r : list){
            relativesModel.addElement(r);
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        state = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        birthday = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        country = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        phone2 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        phone1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        socials = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        session1 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        session2 = new javax.swing.JLabel();
        derivedFrom = new javax.swing.JLabel();
        derivedTo = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        session3 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        observations = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        relativesList = new javax.swing.JList<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(61, 25, 119));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        state.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        state.setForeground(new java.awt.Color(255, 255, 255));
        state.setText("Estado");

        lastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastName.setForeground(new java.awt.Color(255, 255, 255));
        lastName.setText("Apellido");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección");

        city.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        city.setForeground(new java.awt.Color(255, 255, 255));
        city.setText("Ciudad");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("País");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha Nac.");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Género");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));

        name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Nombre");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Apellido");

        birthday.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        birthday.setForeground(new java.awt.Color(255, 255, 255));
        birthday.setText("Fecha Nac.");

        gender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setText("Género");

        address.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setText("Dirección");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Ciudad");

        country.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        country.setForeground(new java.awt.Color(255, 255, 255));
        country.setText("País");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nombre");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(60, 60, 60)
                            .addComponent(country))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastName))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel38)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17)))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(state)
                                .addComponent(name))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birthday))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel25)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gender)
                            .addComponent(city)
                            .addComponent(address))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(state))
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastName)
                    .addComponent(jLabel21))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(birthday))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(gender))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(address))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(country))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 340, 360));

        jPanel3.setBackground(new java.awt.Color(61, 25, 119));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tel. 1");

        phone2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone2.setForeground(new java.awt.Color(255, 255, 255));
        phone2.setText("Tel. 2");

        email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Email");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Redes");

        phone1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone1.setForeground(new java.awt.Color(255, 255, 255));
        phone1.setText("Tel. 1");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Tel. 2");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Email");

        socials.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        socials.setForeground(new java.awt.Color(255, 255, 255));
        socials.setText("Redes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel30))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone2)
                            .addComponent(phone1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(socials)
                            .addComponent(email))
                        .addGap(186, 186, 186))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(82, 82, 82))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(email)
                    .addComponent(phone1)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone2)
                    .addComponent(jLabel20)
                    .addComponent(jLabel30)
                    .addComponent(socials))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 580, 130));

        jPanel4.setBackground(new java.awt.Color(61, 25, 119));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tarifa dif.");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("sesion 1");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Datos de sesión");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Derivado por");

        session1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        session1.setForeground(new java.awt.Color(255, 255, 255));
        session1.setText("sesion 1");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("sesion 2");

        session2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        session2.setForeground(new java.awt.Color(255, 255, 255));
        session2.setText("sesion 2");

        derivedFrom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        derivedFrom.setForeground(new java.awt.Color(255, 255, 255));
        derivedFrom.setText("Derivado por");

        derivedTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        derivedTo.setForeground(new java.awt.Color(255, 255, 255));
        derivedTo.setText("Derivado a");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Derivado a");

        session3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        session3.setForeground(new java.awt.Color(255, 255, 255));
        session3.setText("sesion 3");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("sesion 3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel37)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(derivedTo)
                            .addComponent(derivedFrom)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(session2)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(83, 83, 83))
                                .addComponent(session1)
                                .addComponent(session3))
                            .addComponent(jLabel33)
                            .addComponent(jLabel40))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(16, 16, 16)
                .addComponent(session1)
                .addGap(4, 4, 4)
                .addComponent(jLabel33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(session2)
                        .addGap(33, 33, 33)
                        .addComponent(session3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(derivedFrom))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(derivedTo))
                .addGap(19, 19, 19))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 320, 410));

        jPanel6.setBackground(new java.awt.Color(61, 25, 119));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setBackground(new java.awt.Color(61, 25, 119));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Obs. Iniciales");

        observations.setBackground(new java.awt.Color(61, 25, 119));
        observations.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        observations.setForeground(new java.awt.Color(255, 255, 255));
        observations.setText("Obs. Iniciales");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(observations, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(observations)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 340, 170));

        jPanel7.setBackground(new java.awt.Color(61, 25, 119));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel42.setBackground(new java.awt.Color(61, 25, 119));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Familiares:");

        jScrollPane1.setViewportView(relativesList);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, -1, 250));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel birthday;
    private javax.swing.JLabel city;
    private javax.swing.JLabel country;
    private javax.swing.JLabel derivedFrom;
    private javax.swing.JLabel derivedTo;
    private javax.swing.JLabel email;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastName;
    private javax.swing.JLabel name;
    private javax.swing.JLabel observations;
    private javax.swing.JLabel phone1;
    private javax.swing.JLabel phone2;
    private javax.swing.JList<com.bo.patientmanager.model.PatientRelativeRelation> relativesList;
    private javax.swing.JLabel session1;
    private javax.swing.JLabel session2;
    private javax.swing.JLabel session3;
    private javax.swing.JLabel socials;
    private javax.swing.JLabel state;
    // End of variables declaration//GEN-END:variables
}
