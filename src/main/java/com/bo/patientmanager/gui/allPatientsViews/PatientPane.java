/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bo.patientmanager.gui.allPatientsViews;

import com.bo.patientmanager.model.PatientRelativeRelation;
import com.bo.patientmanager.model.Session;
import com.bo.patientmanager.model.Patient;
import com.bo.patientmanager.service.PatientRelativeRelationService;
import com.bo.patientmanager.service.PatientService;
import com.bo.patientmanager.service.ServiceManager;
import com.bo.patientmanager.service.SessionService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import utils.time.ModelMapper;

/**
 *
 * @author Bring Online
 */
public class PatientPane extends javax.swing.JPanel {
    
    private PatientService patientService = null;
    private SessionService sessionService = null;
    private PatientRelativeRelationService patientRelativeRelationService = null;
    private ServiceManager serviceManager = null;
    Long patientId;
    
    List<PatientRelativeRelation> relatives;

    private DefaultListModel<PatientRelativeRelation> relativesModel;

    /**
     * Creates new form PatientPane
     */
    public PatientPane(ServiceManager serviceManager, Long patientId) {
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
            age.setText("");
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
        Observations.setText(ModelMapper.nullSafe(p.getInitialObservations()));

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

        jPanel1 = new javax.swing.JPanel();
        lastName = new javax.swing.JLabel();
        birthday = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        country = new javax.swing.JLabel();
        derivedFrom = new javax.swing.JLabel();
        state = new javax.swing.JLabel();
        derivedTo = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        socials = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        phone1 = new javax.swing.JLabel();
        phone2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Observations = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        relativesList = new javax.swing.JList<>();
        btnAddRelative = new javax.swing.JButton();
        btnDltRelative = new javax.swing.JButton();
        btnEditRelative = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        difRate = new javax.swing.JLabel();
        session1 = new javax.swing.JLabel();
        session2 = new javax.swing.JLabel();
        session3 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        clinicalHistoryList = new javax.swing.JList<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(61, 25, 119));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lastName.setBackground(new java.awt.Color(61, 25, 119));
        lastName.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lastName.setForeground(new java.awt.Color(255, 255, 255));
        lastName.setText("paciente ");
        jPanel1.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 210, 50));

        birthday.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        birthday.setForeground(new java.awt.Color(255, 255, 255));
        birthday.setText("Fecha");
        jPanel1.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        age.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        age.setForeground(new java.awt.Color(255, 255, 255));
        age.setText("(Edad)");
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        address.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setText("Dirección");
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        city.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        city.setForeground(new java.awt.Color(255, 255, 255));
        city.setText("Ciudad");
        jPanel1.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        gender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setText("Genero");
        jPanel1.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        country.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        country.setForeground(new java.awt.Color(255, 255, 255));
        country.setText("País");
        jPanel1.add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        derivedFrom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        derivedFrom.setForeground(new java.awt.Color(255, 255, 255));
        derivedFrom.setText("Derivado por:");
        jPanel1.add(derivedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        state.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        state.setForeground(new java.awt.Color(255, 255, 255));
        state.setText("Estado");
        jPanel1.add(state, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        derivedTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        derivedTo.setForeground(new java.awt.Color(255, 255, 255));
        derivedTo.setText("Derivado a:");
        jPanel1.add(derivedTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        name.setBackground(new java.awt.Color(61, 25, 119));
        name.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Nombre ");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 60));

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/avatar/man (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 160, 160));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Estado");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Derivado a:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Derivado por:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha de nacimiento");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("(Edad)");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Genero");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Dirección");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Ciudad");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("País");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 17, 442, 480));

        jPanel2.setBackground(new java.awt.Color(61, 25, 119));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        socials.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        socials.setForeground(new java.awt.Color(255, 255, 255));
        socials.setText("Redes:");
        jPanel2.add(socials, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Email:");
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        phone1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone1.setForeground(new java.awt.Color(255, 255, 255));
        phone1.setText("Telefono 1:");
        jPanel2.add(phone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        phone2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone2.setForeground(new java.awt.Color(255, 255, 255));
        phone2.setText("Telefono 2:");
        jPanel2.add(phone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Telefono 1:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Telefono 2:");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Email:");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Redes:");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 515, 442, 184));

        jPanel3.setBackground(new java.awt.Color(61, 25, 119));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Observations.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Observations.setForeground(new java.awt.Color(255, 255, 255));
        Observations.setText("Observaciones:");
        jPanel3.add(Observations, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Observaciones:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 17, 424, 169));

        jPanel4.setBackground(new java.awt.Color(61, 25, 119));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Familiares:");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPane1.setViewportView(relativesList);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 250));

        btnAddRelative.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnAddRelative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/icons/add (1).png"))); // NOI18N
        btnAddRelative.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddRelative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRelativeActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddRelative, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        btnDltRelative.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnDltRelative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/icons/remove.png"))); // NOI18N
        btnDltRelative.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDltRelative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDltRelativeActionPerformed(evt);
            }
        });
        jPanel4.add(btnDltRelative, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        btnEditRelative.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnEditRelative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/icons/edit.png"))); // NOI18N
        btnEditRelative.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditRelative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRelativeActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditRelative, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 40, -1));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 378, 325, 321));

        jPanel5.setBackground(new java.awt.Color(61, 25, 119));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        difRate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        difRate.setForeground(new java.awt.Color(255, 255, 255));
        difRate.setText("Tarifa diferencial");
        jPanel5.add(difRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        session1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        session1.setForeground(new java.awt.Color(255, 255, 255));
        session1.setText("Sesion 1");
        jPanel5.add(session1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        session2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        session2.setForeground(new java.awt.Color(255, 255, 255));
        session2.setText("Sesion 2");
        jPanel5.add(session2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        session3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        session3.setForeground(new java.awt.Color(255, 255, 255));
        session3.setText("Sesion 3");
        jPanel5.add(session3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Sesion 1");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Sesion 2");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Sesion 3");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Tarifa diferencial");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 17, 319, 343));

        jPanel6.setBackground(new java.awt.Color(61, 25, 119));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Historial de sesiones:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        clinicalHistoryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(clinicalHistoryList);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 410));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 204, 424, 495));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRelativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRelativeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRelativeActionPerformed

    private void btnDltRelativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltRelativeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDltRelativeActionPerformed

    private void btnEditRelativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRelativeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditRelativeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Observations;
    private javax.swing.JLabel address;
    private javax.swing.JLabel age;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel birthday;
    private javax.swing.JButton btnAddRelative;
    private javax.swing.JButton btnDltRelative;
    private javax.swing.JButton btnEditRelative;
    private javax.swing.JLabel city;
    private javax.swing.JList<String> clinicalHistoryList;
    private javax.swing.JLabel country;
    private javax.swing.JLabel derivedFrom;
    private javax.swing.JLabel derivedTo;
    private javax.swing.JLabel difRate;
    private javax.swing.JLabel email;
    private javax.swing.JLabel gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastName;
    private javax.swing.JLabel name;
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
