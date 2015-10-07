package example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mapfig.core.ImageOverlay;
import com.mapfig.core.Map;
import com.mapfig.core.MapFigApplication;
import com.mapfig.core.Marker;
import com.mapfig.core.Point;
import com.mapfig.exception.MapFigException;

public class Save {

	public static void main(String[] args) {
		MapFigApplication api = new MapFigApplication("https://studio.mapfig.com", "Za40iR62wtzc8HWs4TgJhNSI8_wRcqMa");
		
		String mapName = "My Map";
		Integer mapHeight = 450;
		Integer mapWidth = 950;
		Integer mapZoom = 4;
		Point mapCenter = new Point(48.856614, 2.3522219); // Latitude, Longitude
					/*
					 * -- Alternative Way --
					 * Point p = new Point();
					 *	try {
					 *		 *
					 *		 * get the Latitude/Longitude in array by providing the Address.
					 *		 * Throws Exception if the Address is incorrect
					 *		 *
					 *		mapCenter = p.setLatLng("United States of America"); // Sets the Point(Lat,Lng)
					 *	} catch (Exception e) {
					 *		// Handle the Exception Here
					 *		echo e.getMessage();
					 *	}
					 */
		Map map = new Map(mapName, mapHeight, mapWidth, mapZoom, mapCenter);
		
		/* These are not required unless you want to change something. 
		 * the Default value is set weather or not you write them here.
		 */
		map.setId(null);
		map.setLayerId(1);  // Default 1 or change it to the account owner's layer ID
		map.setGroupId(0);  // Default 0 or change it to the account owner's layer group ID
		map.setPassword("");  // Default NONE or change it to the Desire Password to protact the Map
		map.setUseCluster(false);  // Default false
		map.setOverlayEnable(false);  // Default false
		map.setOverlayTitle("");  // Default NONE
		map.setOverlayContent("");  // Default NONE
		map.setOverlayBlurb("");  // Default NONE
		map.setLegendEnable(false);  // Default false
		map.setLegendContent("HTML content here");  // Default NONE
		map.setProjectId(0);	// Default 0 or change it to the account owner's project ID
		map.setShowSidebar(true);  // Default true
		map.setShowExport(false);  // Default false
		map.setShowMeasure(false);  // Default false
		map.setShowMinimap(false);  // Default false
		map.setShowSearch(false);  // Default false
		map.setShowFilelayer(false);  // Default false // shows local file upload button
		map.setShowSvg(false);  // Default false
		map.setShowStaticSidebar(false);  // Default false
		map.setStaticSidebarContent("");  // Default NONE
		
		/* Add Image Overlay */
		String name = "Overlay Title goes here"; // will not be displayed
		
		Point upperRightCornor = new Point(0.0, 0.0); // Upper Right Cornor Of Overlay Image
		try {
			upperRightCornor.setLatLng("Canada");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Point bottomLeftCornor = new Point(0.0, 0.0); // Bottom Left Cornor Of image
		try {
			bottomLeftCornor.setLatLng("United State Of America");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		String imageUrl = "http://www.YOUR_IMAGE_URL.com/PATH.JPG";
		String popupContent = "<h3>Image Overlay Content here<h3>";
		
		ImageOverlay imageOverlay1 = new ImageOverlay(name, upperRightCornor, bottomLeftCornor, imageUrl, popupContent); // Create the overlay
		
		map.addImageOverlay(imageOverlay1); // Add as many overlays as you want
		
		//map.dropAllImageOverlays(); // If you want to delete all image overlays
		/* End Map options */
		
		
		
		/* Create First Marker */
		Marker marker1 = null;
		try {
			marker1 = new Marker(48.856614, 2.3522219000000177);
		} catch (MapFigException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // One Way - provide Latitude/Longitude directly
		/* Properties */
		marker1.setLocation("Paris, France");
		marker1.setDescription("<p>This is where you can write the <strong>HTML</strong> code too</p>");
		/* Advance Properties */
		marker1.setShowGetDirection(false);
		marker1.setShowInfoBox(false);
		marker1.setShowLocationOnPopup(true);
		marker1.setHideLabel(true);
		/* Styling */
		marker1.setMarkerStyle(""); // Default NONE, available options are (user,cog,leaf,home,.....) 
											// Complete list can be found here http://fortawesome.github.io/Font-Awesome/icons/
		marker1.setMarkerColor(""); // Default NONE, available options are 
											// (Red,Blue,Green,Purple,Orange,Darkred,Lightred,Beige,Darkblue,Darkpurple,White,
											//  Pink,Lightblue,Lightgreen,Gray,Black,cadetblue,Brown,Lightgray)
		
		
		
		
		/* Create Second Marker */
		Marker marker2 = null;
		try {
			marker2 = new Marker();
		} catch (MapFigException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Other Way,
		try {
			/*
			 * set the Latitude/Longitude by providing the Address.
			 * Throws Exception if the Latitude/Longitude is incorrect
			 */
			marker2.setLatLng("Germany");
		} catch (Exception e) {
			// Handle the Exception Here
			System.out.println(e.getMessage());
		}
		
		/* Properties */
		//marker2.location = "Germany"; // Here Default location is Set as 
												// "Paris, France". but you can still change it to your desired. 
												// Just uncomment the link and Set the Value
		marker2.setDescription("<p>This is where you can write the <strong>HTML</strong> code too</p>");
		/* Advance Properties */
		marker2.setShowGetDirection(false);
		marker2.setShowInfoBox(false);
		marker2.setShowLocationOnPopup(true);
		marker2.setHideLabel(true);
		/* Styling */
		marker2.setMarkerStyle("home"); // Default NONE, available options are (user,cog,leaf,home,.....) 
											// Complete list can be found here http://fortawesome.github.io/Font-Awesome/icons/
		marker2.setMarkerColor("red"); // Default NONE, available options are 
											// (Red,Blue,Green,Purple,Orange,Darkred,Lightred,Beige,Darkblue,Darkpurple,White,
											//  Pink,Lightblue,Lightgreen,Gray,Black,cadetblue,Brown,Lightgray)
											
		
		
		
		
		
		/* Add Markers to the Map */
		map.addShape(marker1);
		map.addShape(marker2);
		
		
		
		
		
		
		// Save the map and get the MapID if successfully saved
		String response = "";
		try {
			response = api.save(map);
		} catch (Exception e) {
			// Handle the Exception Here
			System.out.println(e.getMessage());
		}
		
		
		// TODO with Response.
		System.out.println(response);
		// Parse JSON String
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject) parser.parse(response); // JSON Object
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
