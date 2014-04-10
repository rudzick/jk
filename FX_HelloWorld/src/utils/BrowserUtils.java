package utils;

import java.net.URL;

import org.w3c.dom.Document;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class BrowserUtils {

	
	public static void webDocLoadCompleted(final WebEngine webEngine)  {
		webEngine.getLoadWorker().stateProperty()
		.addListener(new ChangeListener<State>() {
			public void changed(ObservableValue ov, State oldState, State newState) {

				if (newState == Worker.State.SUCCEEDED) {

					System.out.println("called");
					Document doc = webEngine.getDocument();
					System.out.println(doc);
				//	doc.getElementById("ueberschr").setTextContent("BliiiiiiiiiBaaaaaa...");
				}

		}

		
	});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
