package application;

import java.util.List;

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

import com.google.code.geocoder.AdvancedGeoCoder;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;

// import utils.CimdataProxy;

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
        final TextField tflat = new TextField ("52.5234051");
        final TextField tflon = new TextField ("13.4113999");
        final TextField tfzoom = new TextField ("11");
                
        hbox.getChildren().addAll(update_btn, labellat, tflat, labellon, tflon, labelzoom, tfzoom, update_btn2);

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(15, 12, 15, 12));
        hbox2.setSpacing(10);
        hbox2.setMaxHeight(40);
        hbox2.setStyle("-fx-background-color: #336699;");
        Label labeladdress = new Label("Adresse:");
        labeladdress.setTextFill(Color.web("#eeeeee"));
        final TextField tfaddress = new TextField ("Adresse eingeben");
        hbox2.setAlignment(Pos.TOP_CENTER);
        Button address_btn = new Button("Los!");
        
        hbox2.getChildren().addAll(labeladdress, tfaddress, address_btn);
        
		root.setTop(hbox);
		root.setCenter(hbox2);
		root.setBottom(browser);
		
		  
		
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
				
				
				// browser.getWebEngine().executeScript("jumpTo("+m_longitude+","+m_latitude+","+m_osmzoom+")");
				browser.getWebEngine().executeScript("jumpTo("+ lon +","+ lat + "," + zoom + ")");			
				
			}
			
			
		});
		
		address_btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				String m_osmzoom = "11";
				String m_longitude = "13.4113999";
				String m_latitude = "52.5234051";
				
				String lat = m_latitude;
				String lon = m_longitude;
				String zoom = m_osmzoom;
						
				String address ="";
				
				zoom = evalTextField(tfzoom);
				address = evalTextField(tfaddress);
				
				
				
			final Geocoder geocoder = new Geocoder();

	//		final AdvancedGeoCoder advancedGeoCoder = new AdvancedGeoCoder();
				
			//	advancedGeoCoder.getHttpClient().getHostConfiguration().setProxy("10.101.21.1", 8877);
			//	GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").getGeocoderRequest();
			//	GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
				GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("de").getGeocoderRequest();
				GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
				List<GeocoderResult> results = geocoderResponse.getResults();
				lat = results.get(0).getGeometry().getLocation().getLat().toString();
				lon = results.get(0).getGeometry().getLocation().getLng().toString();
				
				System.out.println(lat);
				System.out.println(lon);
				System.out.println(zoom);
				
				// browser.getWebEngine().executeScript("jumpTo("+m_longitude+","+m_latitude+","+m_osmzoom+")");
				browser.getWebEngine().executeScript("jumpTo("+ lon +","+ lat + "," + zoom + ")");			
				
			}
			
			
		});
        
        stage.setScene(scene);
      //  scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        // show stage
        stage.show();
        
        
		
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
	
	public static void main(String[] args){
		// Proxy
	//	CimdataProxy.setCimdataProxy();
		
        launch(args);
    }
	
	

}
