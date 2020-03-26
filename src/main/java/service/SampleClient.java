
package service;
import java.util.List; 
import java.util.ArrayList; 
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import javax.ws.rs.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.core.*;
import javax.ws.rs.client.*;
public class SampleClient {
            private static Client client = ClientBuilder.newClient();
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
       getUsers();
    }
    private static void getUsers() {
         WebTarget webresource=client.target("http://localhost:9090/TestRest-1.0-SNAPSHOT/rest/employees");
        Response response = webresource.request(MediaType.APPLICATION_JSON).get();
    
        if(response.getStatus()!=200){
          throw new RuntimeException("Failed : HTTP error code : "+response.getStatus());

        }
       
     List<User> users
                = response.readEntity(new GenericType<List<User>>() {});

     System.out.println("Response from the Server");
        users.forEach((user)->{System.out.println("id : "+user.getId()+",name : "+user.getName()+",pass :"+user.getPas()+"first name :"+user.getfirstName()+"last name : "+user.getlastName());});
       /* 
       ObjectMapper objectMapper = new ObjectMapper();
       List<User> users=objectMapper.readValue(json , new TypeReference<List<User>>(){});
       */
      /* List<User> users= client
          .target("http://localhost:9090/TestRest-1.0-SNAPSHOT/rest/employees")
          .request(MediaType.APPLICATION_JSON)
          .get(User.class);
          
         System.out.println("Response from the Server");
        users.forEach((user)->{System.out.println("id : "+user.getId()+",name : "+user.getName()+",pass :"+user.getPas()+"first name :"+user.getfirstName()+"last name : "+user.getlastName());});
       */
        }

}
        

       /* System.out.println("id : "+user.getId()+",name : "+user.getName()+",pass :"+user.getPas()+"first name :"+user.getfirstName()+"last name : "+user.getlastName());

/*  String json = client
          .target("http://localhost:9090/TestRest-1.0-SNAPSHOT/rest/employees")
          .request(MediaType.APPLICATION_JSON)
          .get(User.class).toString();
        
        System.out.println(json);
     /*Client clients = ClientBuilder.newClient();
     String url="http://localhost:9090/TestRest-1.0-SNAPSHOT/rest/employees/retrieve/1";
        WebTarget webresource=clients.target(url);
        Response response = webresource.request(MediaType.APPLICATION_JSON).get();
    
        if(response.getStatus()!=200){
          throw new RuntimeException("Failed : HTTP error code : "+response.getStatus());

        }
        User employee=response.readEntity(User.class);
		System.out.println("Response From Server : ");
		System.out.println("id : "+employee.getId()+",name : "+employee.getName());
     List<User> users
                = response.readEntity(new GenericType<List<User>>() {});

     System.out.println("Response from the Server");
        users.forEach((user)->{System.out.println(user);});
        */

        
