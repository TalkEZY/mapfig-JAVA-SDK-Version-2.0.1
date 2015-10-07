package example;

import com.mapfig.core.Map;
import com.mapfig.core.MapFigApplication;

public class Get {

	public static void main(String[] args) {
		MapFigApplication api = new MapFigApplication("https://studio.mapfig.com", "Za40iR62wtzc8HWs4TgJhNSI8_wRcqMa");
		
		try {
			Map map = api.get(491); // it'll return the Map Object. 424 is the user's MapId
			
			System.out.println(map.getWholeDataArray());
			
			// TODO with Response.
			//print_r(map.getWholeDataArray());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
