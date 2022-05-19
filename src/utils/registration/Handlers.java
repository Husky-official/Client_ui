/**
 * @author UWENAYO ALain Pacifique
 * @description a class that contains all the handlers
 */
package src.utils.registration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;

import java.io.IOException;


/** The type Handlers. */
public class Handlers {
  /**
   * Request handler.
   *
   * @param requestString the request string
   * @throws IOException the io exception
   * @role request handling and response printing
   */
  public static void RequestHandler(String requestString) throws IOException {
        ClientServerConnector clientServerConnector = new ClientServerConnector();
        String response = clientServerConnector.connect(requestString);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response);

        int status = jsonResponse.get("status").asInt();
        String message = jsonResponse.get("message").asText();
        String actionDone = jsonResponse.get("actionToDo").asText();
        System.out.println(actionDone+" " + message+ " "+ status);
    }
}
