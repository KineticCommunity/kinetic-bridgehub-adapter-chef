package com.kineticdata.bridgehub.adapter.chef;

import com.kineticdata.bridgehub.adapter.BridgeAdapter;
import com.kineticdata.bridgehub.adapter.BridgeError;
import com.kineticdata.bridgehub.adapter.BridgeRequest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 *
 */
public class ChefAdapterTest {
    
    @Test
    public void test_simpleCount() throws Exception {
        Map<String,String> configuration = new HashMap<String,String>();
        configuration.put("Username","sgerike");
        configuration.put("Pem Location","/Users/sgerike/Documents/public-key-files/scott.gerike-chef.pem");
        configuration.put("API Endpoint","https://api.opscode.com/organizations/kinetic");
        
        BridgeAdapter adapter = new ChefAdapter();
        adapter.setProperties(configuration);
        adapter.initialize();
        
        BridgeRequest request = new BridgeRequest();
        request.setStructure("");
        request.setQuery("");
        
        try {
            adapter.count(request);
        } catch (BridgeError e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
