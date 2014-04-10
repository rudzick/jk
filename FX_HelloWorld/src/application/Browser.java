package application;

import java.net.URL;

import utils.BrowserUtils;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Browser extends Region {
	
	final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
 //   webEngine.setJavaScriptEnabled(true);
    
	public Browser() { 
		// load the web page
//		webEngine.load("http://www.oracle.com/products/index.html");
	//	webEngine.load("file://C:\\workspace\\FX_HelloWorld\\html\\test.html");
		URL url = getClass().getResource("/html/test3.html");
	//	System.out.println(getClass().getResource("/html/test3.html").toString());
		webEngine.load(url.toExternalForm());
		
	//	webEngine.executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}"); 
	// webEngine.executeScript("document.jumpTo("+m_longitude+","+m_latitude+","+m_osmzoom+")");
	//	System.out.println(webEngine.executeScript("getElementById(\"ueberschr\").innerHTML"));
	//	webEngine.executeScript("document.write(\"test\")");
	
      //  webEngine.executeScript("document.getElementById('ueberschr').innerHTML='Hallo'");
       // webEngine.executeScript("window.alert(\"ueberschr\")");
	//	webEngine.loadContent("<html><body><h1><em>Hallo</em> Welt</blink></h1></body></html>");
		System.out.println("Webseite geladen");
		//add the web view to the scene
        getChildren().add(browser);	
        
      //  webEngine.loadContent("<html><body></body><html>");
        System.out.println("-->"+webEngine.documentProperty());
      utils.BrowserUtils.webDocLoadCompleted(webEngine);
	}
	
	public WebView getBrowser() {
		return browser;
	}

	public WebEngine getWebEngine() {
		return webEngine;
	}
	
	@Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 950;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 700;
    }

}
