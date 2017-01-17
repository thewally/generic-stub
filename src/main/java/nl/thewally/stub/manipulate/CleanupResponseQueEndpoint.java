package nl.thewally.stub.manipulate;

import nl.thewally.stub.manipulate.service.cleanupresponseque.CleanupResponseQueRequest;
import nl.thewally.stub.manipulate.service.cleanupresponseque.CleanupResponseQueResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CleanupResponseQueEndpoint {
    private static final String NAMESPACE_URI = "http://thewally.nl/stub/manipulate/service/cleanupresponseque";
    private QueManipulator que;

    @Autowired
    public CleanupResponseQueEndpoint(QueManipulator que) {
        this.que = que;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CleanupResponseQueRequest")
    @ResponsePayload
    public CleanupResponseQueResponse getResult(@RequestPayload CleanupResponseQueRequest request) {
        CleanupResponseQueResponse response = new CleanupResponseQueResponse();
        if(request.getType()==null) {
            que.clearAll();
            if(que.isEmpty()) {
                response.setResult("OK");
            } else {
                response.setResult("NOK");
            }
        } else {
            que.clearAllByTarget(request.getType());
            if(que.isEmptyByTarget(request.getType())) {
                response.setResult("OK");
            } else {
                response.setResult("NOK");
            }
        }
        return response;
    }
}
