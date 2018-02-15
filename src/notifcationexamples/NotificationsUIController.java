/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifcationexamples;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import taskers.*;

/**
 * FXML Controller class
 *
 * @author dalemusser
 */
public class NotificationsUIController implements Initializable, Notifiable {

    @FXML
    private TextArea textArea;
    @FXML
    private Button task1Button;
    @FXML
    private Button task2Button;
    @FXML
    private Button task3Button;
    
    private Task1 task1;
    private Task2 task2;
    private Task3 task3;
    
    private boolean task1Running = false;
    private boolean task2Running = false;
    private boolean task3Running = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void start(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (task1 != null) task1.end();
                if (task2 != null) task2.end();
                if (task3 != null) task3.end();
            }
        });
    }
    
    @FXML
    public void handleTask1(ActionEvent event) {
        if (task1 == null || !task1Running) {
            task1 = new Task1(2147483647, 1000000);
            task1.setNotificationTarget(this);
            task1.start();
            task1Button.setText("End Task 1");
            task1Running = true;
        }
        else if(task1Running){
            task1Button.setText("Start Task 1");
            task1.end();
            task1Running = false;
        }
    }
    
    @Override
    public void notify(String message) {
        if (message.equals("Task1 done.")) {
            task1 = null;
            task1Button.setText("Start Task 1");
        }
        textArea.appendText(message + "\n");
    }
    
    @FXML
    public void handleTask2(ActionEvent event) {
        if (task2 == null || !task2Running) {
            task2 = new Task2(2147483647, 1000000);
            task2.setOnNotification((String message) -> {
                textArea.appendText(message + "\n");
                if(task2.getTaskState()){
                    task2Button.setText("Start Task 2");
                    task2Running = false;
                }
            });
            
            task2.start();
            task2Button.setText("End Task 2");
            task2Running = true;
        }        
        else if(task2Running){
            task2.end();
            task2Button.setText("Start Task 2");
            task2Running = false;
        }
    }
    
    @FXML
    public void handleTask3(ActionEvent event) {
        if (task3 == null || !task3Running) {
            task3 = new Task3(2147483647, 1000000);
            // this uses a property change listener to get messages
            task3.addPropertyChangeListener((PropertyChangeEvent evt) -> {
                textArea.appendText((String)evt.getNewValue() + "\n");
                if(task3.getTaskState()){
                    task3Button.setText("Start Task 3");
                    task3Running = false;
                }
            });
            
            task3.start();
            task3Button.setText("End Task 3");
            task3Running = true;
        }
        else if (task3Running){
            task3.end();
            task3Button.setText("Start Task 3");
            task3Running = false;
        }
    } 
}
