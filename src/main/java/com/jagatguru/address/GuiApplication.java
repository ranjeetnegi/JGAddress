package com.jagatguru.address;

import com.jagatguru.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class GuiApplication extends JFrame{

  //private JButton buttonDownload;
  private JPanel mainApp;
  private JPanel titlePanel;
  private JLabel titleLabel;
  private JPanel searchPanel;
  private JTextField searchTextField;
  private JList searchResultList;
  private JPanel mainPanel;
  private JButton uploadButton;
  private JPanel uploadPanel;
  private JPanel progressPanel;
  private JProgressBar progressBar;
  private JPanel recordViewPanel;
  private JTable recordViewTable;
  private JButton downloadButton;
  private JPanel rightProcessPanel;

  @Autowired
  @Qualifier("com.jagatguru.address.service.impl.AddressServiceImpl")
  private AddressService addressService;

  GuiApplication(){
    super("JG Address");
    this.setContentPane(mainApp);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    uploadButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    downloadButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });
  }
}
