package example;

import com.mapfig.core.Gdal;
import com.mapfig.core.MapFigApplication;

public class GdalGet {
	
	public static void main(String[] args) {
		MapFigApplication api = new MapFigApplication("http://64.90.181.103/endpoint", "6URWZCuYcPdQEgRYH4ZiaYLx4QWXCLwI");
		
		try {
			
			/*
			String request = "ogr2ogr"; // gdal_translate, ogr2ogr, ogrinfo
			String options = "-f \"GeoJSON\""; // optional for request = ogrinfo
			
			String sourceFileURL = "https://developers.google.com/kml/documentation/KML_Samples.kml";
			String targetFileExtension = "json"; // (not required for request = ogrinfo)
			*/
			
			
			String request = "ogrinfo"; // gdal_translate, ogr2ogr, ogrinfo
			String options = ""; 
			String sourceFileURL = "https://developers.google.com/kml/documentation/KML_Samples.kml";
			String targetFileExtension = ""; // (not required for request = ogrinfo)
			
			
			Gdal gdal = new Gdal(request, options, sourceFileURL ,targetFileExtension);
			String output = api.getGDALData(gdal); // it'll return the Map Object. 424 is the user's MapId
			
			System.out.println(output);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
