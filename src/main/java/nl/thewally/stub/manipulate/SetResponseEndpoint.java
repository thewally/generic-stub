package nl.thewally.stub.manipulate;

import nl.thewally.stub.manipulate.service.setresponse.SetResponseRequest;
import nl.thewally.stub.manipulate.service.setresponse.SetResponseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SetResponseEndpoint {
    private static final String NAMESPACE_URI = "http://thewally.nl/stub/manipulate/service/setresponse";
    private QueManipulator que;

    @Autowired
    public SetResponseEndpoint(QueManipulator que) {
        this.que = que;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SetResponseRequest")
    @ResponsePayload
    public SetResponseResponse getResult(@RequestPayload SetResponseRequest request) {
        SetResponseResponse response = new SetResponseResponse();
        //Get old size of que and add 1
        int newSize = que.getSize()+1;

        //Set que with target and xml
        que.set(request.getResponse().getRequestTarget(), request.getResponse().getResponseXml());

        //Check current size of que with calculated que size
        if(newSize==que.getSize()) {
            response.setResult("OK");
        } else {
            response.setResult("NOK");
        }

        // return response with OK or NOK
        return response;
    }
}
