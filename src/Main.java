/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 64mda
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends javax.swing.JFrame {

    int[] modifiers = new int[6]; //Integer array of size-6
    int strMod = 2;
    int dexMod;
    int conMod;
    int intMod;
    int wisMod;
    int chaMod;
    int profBonus = 2;
    
    public Main() {
        initComponents();
    }
    
    public int calculateModifier(int score) {
        int mod = (score - 10) / 2; // Minus ten divided by two
        if(score < 10 && score %2 != 0) mod -= 1; //Round down if negative
        return mod;
    }
    
    public boolean calculateModifiers() { //Returns true if successful
        try { //Calculate modifiers from ability fields, and display modifers
            strMod = calculateModifier(Integer.parseInt(StrField.getText())); 
            dexMod = calculateModifier(Integer.parseInt(DexField.getText()));
            conMod = calculateModifier(Integer.parseInt(ConField.getText()));
            intMod = calculateModifier(Integer.parseInt(IntField.getText()));
            wisMod = calculateModifier(Integer.parseInt(WisField.getText()));
            chaMod = calculateModifier(Integer.parseInt(ChaField.getText()));
            StrModLabel.setText(String.valueOf(strMod));
            DexModLabel.setText(String.valueOf(dexMod));
            ConModLabel.setText(String.valueOf(conMod));
            WisModLabel.setText(String.valueOf(wisMod));
            IntModLabel.setText(String.valueOf(intMod));
            ChaModLabel.setText(String.valueOf(chaMod));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Integer");
            return false;
        }
    }
    
    public void refreshStats() {
        try {
            profBonus = Integer.parseInt(ProfBonusField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Integer (Prof)");
        }
        if(!calculateModifiers()) return;
        updateSavingThrows();
        updateSkills();
    }
    
    public void updateSavingThrows() { //Mod + prof if proficent, just mod if not
        if(StrST.isSelected()) StrST.setText(String.format("%d Strength", profBonus+strMod));
        else StrST.setText(String.format("%d Strength", strMod));
        if(DexST.isSelected()) DexST.setText(String.format("%d Dexterity", profBonus+dexMod));
        else DexST.setText(String.format("%d Dexterity", dexMod));
        if(ConST.isSelected()) ConST.setText(String.format("%d Constitution", profBonus+conMod));
        else ConST.setText(String.format("%d Constitution", conMod));
        if(IntST.isSelected()) IntST.setText(String.format("%d Intelligence", profBonus+intMod));
        else IntST.setText(String.format("%d Intelligence", intMod));
        if(WisST.isSelected()) WisST.setText(String.format("%d Wisdom", profBonus+wisMod));
        else WisST.setText(String.format("%d Wisdom", wisMod));
        if(ChaST.isSelected()) ChaST.setText(String.format("%d Charisma", profBonus+chaMod));
        else ChaST.setText(String.format("%d Charisma", chaMod));
    }
    
    
    public void updateSkills() { //Same as saving throws
        if(strAthletics.isSelected()) strAthletics.setText(String.format("%d Athletics", profBonus+strMod));
        else strAthletics.setText(String.format("%d Athletics", strMod));
        if(dexAcrobatics.isSelected()) dexAcrobatics.setText(String.format("%d Acrobatics", profBonus+dexMod));
        else dexAcrobatics.setText(String.format("%d Acrobatics", dexMod));
        if(dexStealth.isSelected()) dexStealth.setText(String.format("%d Stealth", profBonus+dexMod));
        else dexStealth.setText(String.format("%d Stealth", dexMod));
        if(dexSleight.isSelected()) dexSleight.setText(String.format("%d Sleight of Hand", profBonus+dexMod));
        else dexSleight.setText(String.format("%d Sleight of Hand", dexMod));
        if(intArcana.isSelected()) intArcana.setText(String.format("%d Arcana", profBonus+intMod));
        else intArcana.setText(String.format("%d Arcana", intMod));
        if(intHistory.isSelected()) intHistory.setText(String.format("%d History", profBonus+intMod));
        else intHistory.setText(String.format("%d History", intMod));
        if(intInvestigation.isSelected()) intInvestigation.setText(String.format("%d Investigation", profBonus+intMod));
        else intInvestigation.setText(String.format("%d Investigation", intMod));
        if(intNature.isSelected()) intNature.setText(String.format("%d Nature", profBonus+intMod));
        else intNature.setText(String.format("%d Nature", intMod));
        if(intReligion.isSelected()) intReligion.setText(String.format("%d Religion", profBonus+intMod));
        else intReligion.setText(String.format("%d Religion", intMod));
        if(wisAnimal.isSelected()) wisAnimal.setText(String.format("%d Animal Handling", profBonus+wisMod));
        else wisAnimal.setText(String.format("%d Animal Handling", wisMod));
        if(wisInsight.isSelected()) wisInsight.setText(String.format("%d Insight", profBonus+wisMod));
        else wisInsight.setText(String.format("%d Insight", wisMod));
        if(wisMedicine.isSelected()) wisMedicine.setText(String.format("%d Medicine", profBonus+wisMod));
        else wisMedicine.setText(String.format("%d Medicine", wisMod));
        if(wisPerception.isSelected()) wisPerception.setText(String.format("%d Perception", profBonus+wisMod));
        else wisPerception.setText(String.format("%d Perception", wisMod));
        if(wisSurvival.isSelected()) wisSurvival.setText(String.format("%d Survival", profBonus+wisMod));
        else wisSurvival.setText(String.format("%d Survival", wisMod));
        if(chaDeception.isSelected()) chaDeception.setText(String.format("%d Deception", profBonus+chaMod));
        else chaDeception.setText(String.format("%d Deception", chaMod));
        if(chaIntimidation.isSelected()) chaIntimidation.setText(String.format("%d Intimidation", profBonus+chaMod));
        else chaIntimidation.setText(String.format("%d Intimidation", chaMod));
        if(chaPerformance.isSelected()) chaPerformance.setText(String.format("%d Performance", profBonus+chaMod));
        else chaPerformance.setText(String.format("%d Performance", chaMod));
        if(chaPersuasion.isSelected()) chaPersuasion.setText(String.format("%d Persuasion", profBonus+chaMod));
        else chaPersuasion.setText(String.format("%d Persuasion", chaMod));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        CharacterNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ClassRacePanel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        InspirationTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ProfBonusField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        AbilityScores = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        StrField = new javax.swing.JTextField();
        StrModLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DexField = new javax.swing.JTextField();
        DexModLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ConField = new javax.swing.JTextField();
        ConModLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        IntField = new javax.swing.JTextField();
        IntModLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        WisField = new javax.swing.JTextField();
        WisModLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ChaField = new javax.swing.JTextField();
        ChaModLabel = new javax.swing.JLabel();
        SavingThrowPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        StrST = new javax.swing.JCheckBox();
        IntST = new javax.swing.JCheckBox();
        WisST = new javax.swing.JCheckBox();
        ChaST = new javax.swing.JCheckBox();
        DexST = new javax.swing.JCheckBox();
        ConST = new javax.swing.JCheckBox();
        SkillsPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        dexAcrobatics = new javax.swing.JCheckBox();
        wisAnimal = new javax.swing.JCheckBox();
        intArcana = new javax.swing.JCheckBox();
        strAthletics = new javax.swing.JCheckBox();
        chaDeception = new javax.swing.JCheckBox();
        intHistory = new javax.swing.JCheckBox();
        wisInsight = new javax.swing.JCheckBox();
        chaIntimidation = new javax.swing.JCheckBox();
        intInvestigation = new javax.swing.JCheckBox();
        wisMedicine = new javax.swing.JCheckBox();
        intNature = new javax.swing.JCheckBox();
        wisPerception = new javax.swing.JCheckBox();
        chaPerformance = new javax.swing.JCheckBox();
        chaPersuasion = new javax.swing.JCheckBox();
        intReligion = new javax.swing.JCheckBox();
        dexSleight = new javax.swing.JCheckBox();
        dexStealth = new javax.swing.JCheckBox();
        wisSurvival = new javax.swing.JCheckBox();
        RefreshStats = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CharacterNameField.setText("Character Name");
        CharacterNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CharacterNameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Character Name");

        jLabel2.setText("Class & Level");

        jLabel3.setText("Background");

        jLabel4.setText("Player Name");

        jLabel5.setText("Race");

        jLabel6.setText("Alignment");

        jLabel7.setText("EXP. Points");

        javax.swing.GroupLayout ClassRacePanelLayout = new javax.swing.GroupLayout(ClassRacePanel);
        ClassRacePanel.setLayout(ClassRacePanelLayout);
        ClassRacePanelLayout.setHorizontalGroup(
            ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClassRacePanelLayout.createSequentialGroup()
                .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ClassRacePanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClassRacePanelLayout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClassRacePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClassRacePanelLayout.createSequentialGroup()
                        .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ClassRacePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField1, jTextField2, jTextField3});

        ClassRacePanelLayout.setVerticalGroup(
            ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClassRacePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClassRacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ClassRacePanelLayout.createSequentialGroup()
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addComponent(jLabel5))
                        .addGroup(ClassRacePanelLayout.createSequentialGroup()
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addComponent(jLabel6)))
                    .addGroup(ClassRacePanelLayout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))))
        );

        InspirationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InspirationTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Inspiration");

        ProfBonusField.setText("2");
        ProfBonusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfBonusFieldActionPerformed(evt);
            }
        });

        jLabel10.setText("Proficiency Bonus");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Strength");

        StrField.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        StrField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StrField.setText("10");
        StrField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrFieldActionPerformed(evt);
            }
        });

        StrModLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StrModLabel.setText("0");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Dexterity");

        DexField.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        DexField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DexField.setText("10");

        DexModLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DexModLabel.setText("0");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Constitution");

        ConField.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        ConField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ConField.setText("10");

        ConModLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConModLabel.setText("0");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Intellligence");

        IntField.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        IntField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IntField.setText("10");

        IntModLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntModLabel.setText("0");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Wisdom");

        WisField.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        WisField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        WisField.setText("10");

        WisModLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WisModLabel.setText("0");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Charisma");

        ChaField.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        ChaField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ChaField.setText("10");

        ChaModLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChaModLabel.setText("0");

        javax.swing.GroupLayout AbilityScoresLayout = new javax.swing.GroupLayout(AbilityScores);
        AbilityScores.setLayout(AbilityScoresLayout);
        AbilityScoresLayout.setHorizontalGroup(
            AbilityScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbilityScoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbilityScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AbilityScoresLayout.createSequentialGroup()
                        .addGroup(AbilityScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StrModLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DexModLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConModLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IntModLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WisModLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChaModLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StrField)
                    .addComponent(DexField)
                    .addComponent(ConField)
                    .addComponent(IntField)
                    .addComponent(WisField)
                    .addComponent(ChaField))
                .addContainerGap())
        );
        AbilityScoresLayout.setVerticalGroup(
            AbilityScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbilityScoresLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(StrField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(StrModLabel)
                .addGap(6, 6, 6)
                .addComponent(jLabel11)
                .addGap(1, 1, 1)
                .addComponent(DexField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(DexModLabel)
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(1, 1, 1)
                .addComponent(ConField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(ConModLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(1, 1, 1)
                .addComponent(IntField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(IntModLabel)
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addGap(1, 1, 1)
                .addComponent(WisField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(WisModLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(1, 1, 1)
                .addComponent(ChaField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(ChaModLabel))
        );

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Saving Throws");

        StrST.setText("0 Strength");
        StrST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrSTActionPerformed(evt);
            }
        });

        IntST.setText("0 Intelligence");
        IntST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntSTActionPerformed(evt);
            }
        });

        WisST.setText("0 Wisdom");
        WisST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WisSTActionPerformed(evt);
            }
        });

        ChaST.setText("0 Charisma");
        ChaST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChaSTActionPerformed(evt);
            }
        });

        DexST.setText("0 Dexterity");
        DexST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DexSTActionPerformed(evt);
            }
        });

        ConST.setText("0 Constitution");
        ConST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConSTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SavingThrowPanelLayout = new javax.swing.GroupLayout(SavingThrowPanel);
        SavingThrowPanel.setLayout(SavingThrowPanelLayout);
        SavingThrowPanelLayout.setHorizontalGroup(
            SavingThrowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SavingThrowPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(SavingThrowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StrST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IntST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WisST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChaST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DexST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SavingThrowPanelLayout.setVerticalGroup(
            SavingThrowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SavingThrowPanelLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StrST, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DexST, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConST, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IntST, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WisST, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChaST, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Skills");

        dexAcrobatics.setText("0 Acrobatics");
        dexAcrobatics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dexAcrobaticsActionPerformed(evt);
            }
        });

        wisAnimal.setText("0 Animal Handling");
        wisAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wisAnimalActionPerformed(evt);
            }
        });

        intArcana.setText("0 Arcana");
        intArcana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intArcanaActionPerformed(evt);
            }
        });

        strAthletics.setText("0 Athletics");
        strAthletics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strAthleticsActionPerformed(evt);
            }
        });

        chaDeception.setText("0 Deception");
        chaDeception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chaDeceptionActionPerformed(evt);
            }
        });

        intHistory.setText("0 History");
        intHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intHistoryActionPerformed(evt);
            }
        });

        wisInsight.setText("0 Insight");
        wisInsight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wisInsightActionPerformed(evt);
            }
        });

        chaIntimidation.setText("0 Intimidation");
        chaIntimidation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chaIntimidationActionPerformed(evt);
            }
        });

        intInvestigation.setText("0 Investigation");
        intInvestigation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intInvestigationActionPerformed(evt);
            }
        });

        wisMedicine.setText("0 Medicine");
        wisMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wisMedicineActionPerformed(evt);
            }
        });

        intNature.setText("0 Nature");
        intNature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intNatureActionPerformed(evt);
            }
        });

        wisPerception.setText("0 Perception");
        wisPerception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wisPerceptionActionPerformed(evt);
            }
        });

        chaPerformance.setText("0 Performance");
        chaPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chaPerformanceActionPerformed(evt);
            }
        });

        chaPersuasion.setText("0 Persuasion");
        chaPersuasion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chaPersuasionActionPerformed(evt);
            }
        });

        intReligion.setText("0 Religion");
        intReligion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intReligionActionPerformed(evt);
            }
        });

        dexSleight.setText("0 Sleight of Hand");
        dexSleight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dexSleightActionPerformed(evt);
            }
        });

        dexStealth.setText("0 Stealth");
        dexStealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dexStealthActionPerformed(evt);
            }
        });

        wisSurvival.setText("0 Survival");
        wisSurvival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wisSurvivalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SkillsPanelLayout = new javax.swing.GroupLayout(SkillsPanel);
        SkillsPanel.setLayout(SkillsPanelLayout);
        SkillsPanelLayout.setHorizontalGroup(
            SkillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dexAcrobatics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wisAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(intArcana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(strAthletics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chaDeception, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(intHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wisInsight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chaIntimidation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(intInvestigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wisMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(intNature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wisPerception, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chaPerformance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chaPersuasion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(intReligion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dexSleight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dexStealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wisSurvival, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SkillsPanelLayout.setVerticalGroup(
            SkillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SkillsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dexAcrobatics, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wisAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intArcana, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strAthletics, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chaDeception, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wisInsight, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chaIntimidation, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intInvestigation, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wisMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intNature, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wisPerception, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chaPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chaPersuasion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intReligion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dexSleight, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dexStealth, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wisSurvival, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RefreshStats.setText("Update Modifiers");
        RefreshStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshStatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CharacterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AbilityScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InspirationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ProfBonusField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SavingThrowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClassRacePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SkillsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RefreshStats)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ClassRacePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SkillsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CharacterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(InspirationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ProfBonusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SavingThrowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AbilityScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(RefreshStats)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CharacterNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CharacterNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CharacterNameFieldActionPerformed

    private void InspirationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InspirationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InspirationTextFieldActionPerformed

    private void ProfBonusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfBonusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfBonusFieldActionPerformed

    private void StrSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StrSTActionPerformed

    private void dexAcrobaticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dexAcrobaticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dexAcrobaticsActionPerformed

    private void IntSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IntSTActionPerformed

    private void WisSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WisSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WisSTActionPerformed

    private void ChaSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChaSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChaSTActionPerformed

    private void wisAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wisAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wisAnimalActionPerformed

    private void intArcanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intArcanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intArcanaActionPerformed

    private void strAthleticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strAthleticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strAthleticsActionPerformed

    private void chaDeceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chaDeceptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chaDeceptionActionPerformed

    private void intHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intHistoryActionPerformed

    private void wisInsightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wisInsightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wisInsightActionPerformed

    private void chaIntimidationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chaIntimidationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chaIntimidationActionPerformed

    private void intInvestigationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intInvestigationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intInvestigationActionPerformed

    private void wisMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wisMedicineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wisMedicineActionPerformed

    private void intNatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intNatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intNatureActionPerformed

    private void wisPerceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wisPerceptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wisPerceptionActionPerformed

    private void chaPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chaPerformanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chaPerformanceActionPerformed

    private void chaPersuasionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chaPersuasionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chaPersuasionActionPerformed

    private void intReligionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intReligionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intReligionActionPerformed

    private void dexSleightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dexSleightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dexSleightActionPerformed

    private void dexStealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dexStealthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dexStealthActionPerformed

    private void DexSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DexSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DexSTActionPerformed

    private void wisSurvivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wisSurvivalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wisSurvivalActionPerformed

    private void RefreshStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshStatsActionPerformed
        refreshStats();
    }//GEN-LAST:event_RefreshStatsActionPerformed

    private void ConSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConSTActionPerformed

    private void StrFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StrFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbilityScores;
    private javax.swing.JTextField ChaField;
    private javax.swing.JLabel ChaModLabel;
    private javax.swing.JCheckBox ChaST;
    private javax.swing.JTextField CharacterNameField;
    private javax.swing.JPanel ClassRacePanel;
    private javax.swing.JTextField ConField;
    private javax.swing.JLabel ConModLabel;
    private javax.swing.JCheckBox ConST;
    private javax.swing.JTextField DexField;
    private javax.swing.JLabel DexModLabel;
    private javax.swing.JCheckBox DexST;
    private javax.swing.JTextField InspirationTextField;
    private javax.swing.JTextField IntField;
    private javax.swing.JLabel IntModLabel;
    private javax.swing.JCheckBox IntST;
    private javax.swing.JTextField ProfBonusField;
    private javax.swing.JButton RefreshStats;
    private javax.swing.JPanel SavingThrowPanel;
    private javax.swing.JPanel SkillsPanel;
    private javax.swing.JTextField StrField;
    private javax.swing.JLabel StrModLabel;
    private javax.swing.JCheckBox StrST;
    private javax.swing.JTextField WisField;
    private javax.swing.JLabel WisModLabel;
    private javax.swing.JCheckBox WisST;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chaDeception;
    private javax.swing.JCheckBox chaIntimidation;
    private javax.swing.JCheckBox chaPerformance;
    private javax.swing.JCheckBox chaPersuasion;
    private javax.swing.JCheckBox dexAcrobatics;
    private javax.swing.JCheckBox dexSleight;
    private javax.swing.JCheckBox dexStealth;
    private javax.swing.JCheckBox intArcana;
    private javax.swing.JCheckBox intHistory;
    private javax.swing.JCheckBox intInvestigation;
    private javax.swing.JCheckBox intNature;
    private javax.swing.JCheckBox intReligion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JCheckBox strAthletics;
    private javax.swing.JCheckBox wisAnimal;
    private javax.swing.JCheckBox wisInsight;
    private javax.swing.JCheckBox wisMedicine;
    private javax.swing.JCheckBox wisPerception;
    private javax.swing.JCheckBox wisSurvival;
    // End of variables declaration//GEN-END:variables
}
