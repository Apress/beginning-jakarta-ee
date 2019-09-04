  package com.example.listeners;

  import javax.faces.event.*;

  public class RegisterListener 
          implements ActionListener {
      @Override
      public void processAction(ActionEvent event) 
            throws AbortProcessingException {
        System.err.println("!!! ACTION !!!");
      }
  }
