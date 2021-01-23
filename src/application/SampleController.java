package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootpane;

    @FXML
    private JFXButton btnSnackbar;
    

    @FXML
    private JFXButton btntoast;

    @FXML
    private Label toastlabel;
    
    @FXML
    private AnchorPane alertPane;

    @FXML
    private AnchorPane backgroundPane;

    @FXML
    private ImageView smileImage;

    @FXML
    private Label HeaderLabel;

    @FXML
    private Label messageLabel;
    

    @FXML
    private JFXButton alertBtns;

    @FXML
    void initialize() {
    	
    	
    	FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),toastlabel);
    	fadeTransition.setToValue(1);
    	fadeTransition.setFromValue(0);
    	fadeTransition.play();
    	
    	ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.5),alertPane);
    	scaleTransition.setByX(-1);
    	scaleTransition.setByY(-1);
    	scaleTransition.play();
      
    	btnSnackbar.setOnAction(e->{
    		showSnackbar("Hello World");
    	});
    	
    	btntoast.setOnAction(event1->{
    		showtoast("Hello Ýlyas");
    	});
    	
    	alertBtns.setOnAction(e3->{
    		
    		showAlert("/Images/smile.png"," #00d0b0","OOOOOOPSSS","Messsageeeeee");
    	});

    }

private void showAlert(String imageUrl, String BackgroundColor, String Header, String Message) {
	
	smileImage.setImage(new Image(imageUrl));
	
	backgroundPane.setStyle("-fx-background-color:"+BackgroundColor+";");
	HeaderLabel.setText(Header);
	messageLabel.setText(Message);
	alertPane.setVisible(true);
	
	ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(1),alertPane);
	scaleTransition.setByX(1);
	scaleTransition.setByY(1);
	scaleTransition.play();
	
	scaleTransition.setOnFinished(e4->{
		FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),alertPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
		
		fadeTransition.setOnFinished(e5->{
			ScaleTransition scala1=new ScaleTransition(Duration.seconds(0.5),alertPane);
			
			scala1.setByX(-1);
			scala1.setByY(-1);
			scala1.play();
			
			alertPane.setVisible(false);
			
			FadeTransition fadeTransition2=new FadeTransition(Duration.seconds(0.5),alertPane);
			fadeTransition2.setFromValue(0);
			fadeTransition2.setToValue(1);
			fadeTransition2.play();
		});
	});
		
	}

private void showtoast(String string) {
		
	       toastlabel.setText(string);
	       toastlabel.setVisible(true);
	       FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(2),toastlabel);
	    	fadeTransition1.setToValue(1);
	    	fadeTransition1.setFromValue(0);
	    	fadeTransition1.play();
	       
	    	fadeTransition1.setOnFinished(event2->{
	    		 FadeTransition fadeTransition2=new FadeTransition(Duration.seconds(2),toastlabel);
	 	    	fadeTransition2.setToValue(0);
	 	    	fadeTransition2.setFromValue(1);
	 	    	fadeTransition2.play();
	 	       
	    	});
	       
		
	}

	private void showSnackbar(String string) {
		
		JFXSnackbar snackbar=new JFXSnackbar(rootpane);
		snackbar.setPrefHeight(30);
		snackbar.setPrefWidth(rootpane.getPrefWidth());
		snackbar.setAlignment(Pos.BOTTOM_RIGHT);
		snackbar.show(string, 2000);
		
	}
}
