

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.client.ClientConfig;

public class ClientRetrieve 
{

	public static void main(String[] args) throws IOException 
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		Response response = target.path("matakuliah/84/f4/3a/4d/84f43a4d-8316-4417-8bf7-1266c70bd226").request().get();
		
		System.out.println(response.getStatus());
		
		InputStream in = response.readEntity(InputStream.class);
		File file = new File("C:\\contoh\\alpro_download.docx");
		FileUtils.copyInputStreamToFile(in, file);
		in.close();
		
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8081/fcrepo-webapp-4.7.4/rest").build();
	}
	
}