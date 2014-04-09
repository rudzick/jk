package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class WebViewSample extends Application {
	private Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		// Proxy
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", "10.101.21.1");
		System.getProperties().put("http.proxyPort", "8877");
		
		// create scene
        stage.setTitle("OpenLayers Beispiel");
        scene = new Scene(new Browser(),750,500, Color.web("#666970"));
        stage.setScene(scene);
      //  scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        // show stage
        stage.show();
		
		
	}
	
	public static void main(String[] args){
        launch(args);
    }
	
	

}
