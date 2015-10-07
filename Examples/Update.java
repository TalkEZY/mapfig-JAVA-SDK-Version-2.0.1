package example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mapfig.core.ImageOverlay;
import com.mapfig.core.Map;
import com.mapfig.core.MapFigApplication;
import com.mapfig.core.Marker;
import com.mapfig.core.Point;

public class Update {

	public static void main(String[] args) {
		MapFigApplication api = new MapFigApplication("https://studio.mapfig.com", "Za40iR62wtzc8HWs4TgJhNSI8_wRcqMa");
		
		
		Map map;
		try {
			map = api.get(491); // First of all get the map by ID
			
			// TODO with map - Update Map object here
			/* Update the Map here*/
			map.setLayerId(1);  // Default 1 or change it to the account owner's layer ID
			map.setGroupId(0);  // Default 0 or change it to the account owner's layer group ID
			map.setPassword("");  // Default NONE or change it to the Desire Password to protact the Map
			map.setUseCluster(true);  // Default false
			map.setOverlayEnable(true);  // Default false
			map.setOverlayTitle("Updated Overlay Title");  // Default NONE
			map.setOverlayContent("Updated Overlay Content");  // Default NONE
			map.setOverlayBlurb("Example Blurb");  // Default NONE
			map.setLegendEnable(false);  // Default false
			map.setLegendContent("HTML content here");  // Default NONE
			map.setProjectId(0);	// Default 0 or change it to the account owner's project ID
			map.setShowSidebar(true);  // Default true
			map.setShowExport(true);  // Default false
			map.setShowMeasure(true);  // Default false
			map.setShowMinimap(true);  // Default false
			map.setShowSearch(true);  // Default false
			map.setShowFilelayer(false);  // Default false // shows local file upload button
			map.setShowSvg(false);  // Default false
			map.setShowStaticSidebar(false);  // Default false
			map.setStaticSidebarContent("");  // Default NONE
			
			/* Add Image Overlay */
			String name = "Overlay Title goes here"; // will not be displayed
			
			Point upperRightCornor = new Point(0.0, 0.0); // Upper Right Cornor Of Overlay Image
			upperRightCornor.setLatLng("Canada");
			
			Point bottomLeftCornor = new Point(0.0, 0.0); // Bottom Left Cornor Of image
			bottomLeftCornor.setLatLng("United State Of America");
			
			String imageUrl = "http://www.YOUR_IMAGE_URL.com/PATH.PNG";
			String popupContent = "<h3>Image Overlay Content here<h3>";
			
			ImageOverlay imageOverlay1 = new ImageOverlay(name, upperRightCornor, bottomLeftCornor, imageUrl, popupContent); // Create the overlay
			map.addImageOverlay(imageOverlay1); // Add as many overlays as you want
			
			//map.dropAllImageOverlays(); // If you want to delete all image overlays
			
			
			
			
			
			// map.dropAllShapes(); it'll remove all the shapes from Map
			// You can add more Markers
			Marker marker = new Marker(48.856614, 2.3522219000000177); // One Way - provide Latitude/Longitude directly
			/* Properties */
			marker.setLocation("New York");
			marker.setDescription("<p>This is where you can write the <strong>HTML</strong> code too</p>");
			/* Advance Properties */
			marker.setShowGetDirection(false);
			marker.setShowInfoBox(true);
			marker.setShowLocationOnPopup(true);
			marker.setHideLabel(true);
			/* Styling */
			marker.setMarkerStyle(""); // Default NONE, available options are (user,cog,leaf,home,.....) 
												// Complete list can be found here http://fortawesome.github.io/Font-Awesome/icons/
			marker.setMarkerColor(""); // Default NONE, available options are 
												// (Red,Blue,Green,Purple,Orange,Darkred,Lightred,Beige,Darkblue,Darkpurple,White,
												//  Pink,Lightblue,Lightgreen,Gray,Black,cadetblue,Brown,Lightgray)
			map.addShape(marker);
			
			
			
			// Save the map and get the MapID if successfully saved
			String response = "";
			try {
				// TODO with response
				response = api.update(map);
				// Parse JSON String
				JSONParser parser = new JSONParser();
				
				try {
					JSONObject obj = (JSONObject) parser.parse(response); // JSON Object
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (Exception e) {
				// Handle the Exception Here
				System.out.println(e.getMessage());
			}
			
			
			// TODO with Response.
			System.out.println(response);
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}

}
