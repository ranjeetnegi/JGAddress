package com.jagatguru.address.gui;

import com.jagatguru.address.entity.Address;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@NoArgsConstructor
public class AddressEditPopUp extends JFrame {
  //Labels
  private JLabel nameLabel;
  private JLabel phoneLabel;
  private JLabel pinLabel;
  private JLabel stateLabel;
  private JLabel districtLabel;
  private JLabel blockLabel;
  private JLabel bookLabel;
  private JLabel addressLabel;
  private JLabel rawAddressLabel;
  private JLabel orderDateLabel;

  //Text Fields
  private JTextField nameTextField;
  private JTextField phoneTextField;
  private JTextField pinTextField;
  private JTextField stateTextField;
  private JTextField districtTextField;
  private JTextField blockTextField;
  private JTextField bookTextField;
  private JTextField addressTextField;
  private JTextField rawAddressTextField;
  private JTextField orderDateTextField;

  private JButton saveButton;


  public AddressEditPopUp(Address address){
    setTitle("Address");
    setSize(400,400);
    setLocation(600,300);
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    Container c = getContentPane();
    c.setLayout(null);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

    //Name
    nameLabel = new JLabel("Name");
    nameLabel.setBounds(5,5,200,15);
    nameTextField = new JTextField();
    nameTextField.setBounds(5,25,350,20);
    c.add(nameLabel);
    c.add(nameTextField);

  }
}
