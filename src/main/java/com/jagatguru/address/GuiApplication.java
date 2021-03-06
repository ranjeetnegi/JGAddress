package com.jagatguru.address;

import com.jagatguru.address.common.Constants;
import com.jagatguru.address.entity.Address;
import com.jagatguru.address.gui.AddressEditPopUp;
import com.jagatguru.address.service.AddressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class GuiApplication extends JFrame {

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
  private JPopupMenu popupMenuPhoneNumber;


  private DefaultListModel<String> searchResultListModel;
  private List<Address> addresses;

  @Autowired
  @Qualifier("com.jagatguru.address.service.impl.AddressServiceImpl")
  private AddressService addressService;

  GuiApplication() {
    super("JagatGuru");
    this.setContentPane(mainApp);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.pack();

    //Initializations
    this.addresses = new ArrayList<>();
    this.popupMenuPhoneNumber = new JPopupMenu();
    searchListPopUpItems();
    searchResultListModel = new DefaultListModel();
    this.searchResultList.setModel(searchResultListModel);

    //Event Configs
    uploadButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        openAndQueueFileForProcess(event);
      }
    });
    downloadButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });
    searchTextField.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    searchResultList.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
      }
    });
    searchTextField.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent event) {
        insertPhoneUpdate(event);
      }

      @Override
      public void removeUpdate(DocumentEvent event) {
        removePhoneUpdate(event);
      }

      @Override
      public void changedUpdate(DocumentEvent event) {
      }
    });
    searchResultList.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent event) {
        searchResultItemRightClick(event);
      }
    });
  }

  private void openAndQueueFileForProcess(ActionEvent e){
    File file = openFileFromComputer();
    System.out.println(file.getName());
  }
  private void searchResultItemRightClick(MouseEvent event){
    //DETERMINE RIGHT CLICKED
    if (SwingUtilities.isRightMouseButton(event)
        && searchResultList.locationToIndex(event.getPoint()) == searchResultList
        .getSelectedIndex()) {
      //Make sure sth row is selected
      if (!searchResultList.isSelectionEmpty()) {
        popupMenuPhoneNumber.show(searchResultList, event.getX(), event.getY());
      }
    }
  }
  private void insertPhoneUpdate(DocumentEvent event){
    if(event != null){
      Document document = event.getDocument();
      if(document != null){
        try {
          String searchText = document.getText(0, document.getLength());
          addresses = addressService
              .searchAddressByPhoneNumber(searchText, Constants.RESULT_SIZE_40, null, null);
          refreshAddressList();
        } catch (BadLocationException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void searchListPopUpItems(){

    //Items
    JMenuItem showAddress = new JMenuItem("View Address");
    JMenuItem editAddress = new JMenuItem("Edit Address");

    //Adding items to popup
    popupMenuPhoneNumber.add(showAddress);
    popupMenuPhoneNumber.add(editAddress);

    //Events
    showAddress.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        AddressEditPopUp addressEditPopUp = new AddressEditPopUp(null);
      }
    });
    editAddress.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Edit Address");
      }
    });
  }

  /**
   * Delete phone char from search text event
   *
   * @param event
   */
  private void removePhoneUpdate(DocumentEvent event){
    if (event != null) {
      Document document = event.getDocument();
      if (document != null) {
        try {
          String searchParam = document.getText(0, document.getLength());
          if (!StringUtils.isEmpty(searchParam)) {
            addresses = addressService
                .searchAddressByPhoneNumber(searchParam, Constants.RESULT_SIZE_40, null, null);
            refreshAddressList();
          } else {
            searchResultListModel.removeAllElements();
          }
        } catch (BadLocationException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * Select file from computer for process
   *
   * @return
   */
  private File openFileFromComputer() {
    File file = null;
    JFrame frame = new JFrame("Open File");
    frame.setSize(560, 400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    JFileChooser fileChooser = new JFileChooser();

    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
    fileChooser.setFileFilter(filter);

    int option = fileChooser.showOpenDialog(frame);
    if(option == JFileChooser.APPROVE_OPTION){
      file = fileChooser.getSelectedFile();
    }
    frame.setVisible(false);
    return file;
  }

  /**
   * Refresh updated phone list
   */
  private void refreshAddressList(){
    this.searchResultListModel.removeAllElements();
    this.addresses.forEach(a -> this.searchResultListModel.addElement(a.getPhone()));
  }
}
