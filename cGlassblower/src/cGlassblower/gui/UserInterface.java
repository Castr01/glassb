package cGlassblower.gui;


import cGlassblower.data.Data;
import cGlassblower.data.UserInterfaceData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {

    public JFrame frmc;

    public UserInterface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmc = new JFrame();
        frmc.setResizable(false);
       // frmc.setTitle(">C<Glassblower");
        frmc.setBounds(100, 100, 295, 171);
        frmc.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frmc.getContentPane().setLayout(null);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(0, 87, 301, 6);
        frmc.getContentPane().add(separator_2);

        JLabel lblFishingOptions = new JLabel("Glassblowing options:");
        lblFishingOptions.setForeground(Color.GRAY);
        lblFishingOptions.setBounds(10, 37, 147, 14);
        frmc.getContentPane().add(lblFishingOptions);

        JLabel lblFishToCatch = new JLabel("Make:");
        lblFishToCatch.setBounds(10, 62, 40, 14);
        frmc.getContentPane().add(lblFishToCatch);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Beer glass", "Candle lantern", "Oil lamp", "Vial","Fishbowl", "Unpowered staff orb","Lantern lens", "Light orb"}));
        comboBox.setBounds(45, 59, 234, 20);
        frmc.getContentPane().add(comboBox);

        JLabel lblCkarambwans = new JLabel("cGlassblower");
        lblCkarambwans.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCkarambwans.setBounds(10, 0, 159, 29);
        frmc.getContentPane().add(lblCkarambwans);

        JSeparator separator = new JSeparator();
        separator.setBounds(-1, 27, 302, 2);
        frmc.getContentPane().add(separator);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if(comboBox.getSelectedItem().toString() == "Beer glass"){

                    UserInterfaceData.itemToBlowIndex = Data.beerGlass;

                } else if(comboBox.getSelectedItem().toString() == "Candle lantern"){

                    UserInterfaceData.itemToBlowIndex = Data.candleLantern;

                }else if (comboBox.getSelectedItem().toString() == "Oil lamp"){

                    UserInterfaceData.itemToBlowIndex = Data.oilLamp;

                }else if (comboBox.getSelectedItem().toString() == "Vial"){

                    UserInterfaceData.itemToBlowIndex = Data.vial;

                }else if (comboBox.getSelectedItem().toString() == "Fishbowl"){

                    UserInterfaceData.itemToBlowIndex = Data.fishbowl;

                }else if (comboBox.getSelectedItem().toString() == "Unpowered staff orb"){

                    UserInterfaceData.itemToBlowIndex = Data.unpoweredStaffOrb;

                }else if (comboBox.getSelectedItem().toString() == "Lantern lens"){

                    UserInterfaceData.itemToBlowIndex = Data.lens;

                }else{

                    UserInterfaceData.itemToBlowIndex = Data.lightOrb;

                }

                frmc.setVisible(false);
            }
        });
        btnStart.setBounds(10, 104, 269, 23);
        frmc.getContentPane().add(btnStart);
    }
}