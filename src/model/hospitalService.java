package model;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.Hospital;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Hospital")
public class hospitalService {
	Hospital hospitalObj = new Hospital();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital() {

		return hospitalObj.readHospital();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("hpCode") String hpCode, @FormParam("hpName") String hpName,
			@FormParam("hpTp") String hpTp, @FormParam("hpAddress") String hpAddress, @FormParam("hpDoc") String hpDoc, @FormParam("hpDesc") String hpDesc) {
		String output = hospitalObj.insertHospital(hpCode, hpName, hpTp, hpAddress,hpDoc,hpDesc);
		return output;
	}

	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) {
		// Convert the input string to a JSON object
		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		// Read the values from the JSON object
		String hpID = hospitalObject.get("hpID").getAsString();
		String hpCode = hospitalObject.get("hpCode").getAsString();
		String hpName = hospitalObject.get("hpName").getAsString();
		String hpTp = hospitalObject.get("hpTp").getAsString();
		String hpAddress = hospitalObject.get("hpAddress").getAsString();
		String hpDoc = hospitalObject.get("hpDoc").getAsString();	
		String hpDesc = hospitalObject.get("hpDesc").getAsString();
		String output = hospitalObj.updateHospital(hpID, hpCode, hpName, hpTp, hpAddress, hpDoc, hpDesc);
		return output;
	}

	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String HospitalData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(HospitalData, "", Parser.xmlParser());
		// Read the value from the element <hpID>
		String hpID = doc.select("hpID").text();
		String output = hospitalObj.deleteHospital(hpID);
		return output;
	}
}