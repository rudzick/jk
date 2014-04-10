package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.w3c.dom.Element;

import utils.CimdataProxy;

// import com.google.code.geocoder.AdvancedGeoCoder;
// import com.google.code.geocoder.Geocoder;
// import com.google.code.geocoder.GeocoderRequestBuilder;
// import com.google.code.geocoder.model.GeocodeResponse;
// import com.google.code.geocoder.model.GeocoderRequest;




public class WebViewSample extends Application {
	private Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		// create scene
        stage.setTitle("OpenLayers Beispiel");
        
        final Browser browser = new Browser();
        BorderPane root = new BorderPane();
        scene = new Scene(root, 1024, 968, Color.web("#666970"));

        //root.getChildren().add(browser);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button update_btn = new Button("Zurücksetzen");
        Button update_btn2 = new Button("Zentriere auf Position");
        
        Label labellat = new Label("Breite:");
        labellat.setTextFill(Color.web("#eeeeee"));
        Label labellon = new Label("Länge:");
        labellon.setTextFill(Color.web("#eeeeee"));
        Label labelzoom = new Label("zoom:");
        labelzoom.setTextFill(Color.web("#eeeeee"));
        TextField tflat = new TextField ("52.5234051");
        TextField tflon = new TextField ("13.4113999");
        TextField tfzoom = new TextField ("11");
                
        hbox.getChildren().addAll(update_btn, labellat, tflat, labellon, tflon, labelzoom, tfzoom, update_btn2);

        hbox.setAlignment(Pos.TOP_CENTER);
		root.setTop(hbox);
		root.setCenter(browser);
		
		  
		
		update_btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				Element p = (Element) browser.getWebEngine()
						.executeScript("document.getElementById('ueberschr')");
				System.out.println(p);
				// p.setAttribute("style", "font-weight: bold; background:red");
				browser.getWebEngine().executeScript("reset()");

			}
		});
		
		update_btn2.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				String m_osmzoom = "11";
				String m_longitude = "13.4113999";
				String m_latitude = "52.5234051";
				
				String lat = m_latitude;
				String lon = m_longitude;
				String zoom = m_osmzoom;
						
				String adresse ="";
				
				lat = evalTextField(tflat);
				lon = evalTextField(tflon);
				zoom = evalTextField(tfzoom);
				
				System.out.println(lat);
				System.out.println(lon);
				System.out.println(zoom);
				
			//	final Geocoder geocoder = new Geocoder();

			//	final AdvancedGeoCoder advancedGeoCoder = new AdvancedGeoCoder();
				
			//	advancedGeoCoder.getHttpClient().getHostConfiguration().setProxy("10.101.21.1", 8877);
			//	GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").getGeocoderRequest();
			//	GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		//		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").getGeocoderRequest();
		//		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
				// browser.getWebEngine().executeScript("jumpTo("+m_longitude+","+m_latitude+","+m_osmzoom+")");
				browser.getWebEngine().executeScript("jumpTo("+ lon +","+ lat + "," + zoom + ")");			
				
			}
			
			private String evalTextField(TextField tf) {
				String val ="";
				if ((tf.getText() != null && !tf.getText().isEmpty())) {
		            val = tf.getText();
		        } else {
		            tf.setText("Bitte gültigen Wert eingeben.");
		        }
				return val;
			}
		});
        
        stage.setScene(scene);
      //  scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        // show stage
        stage.show();
        
        
		
		
	}
	
	public static void main(String[] args){
		// Proxy
		CimdataProxy.setCimdataProxy();
		
        launch(args);
    }
	
	

}
