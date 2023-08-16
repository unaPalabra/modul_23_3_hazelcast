import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class ClientNode {
    static Map<Long, String> map;
    static HazelcastInstance hzClient;
    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        GroupConfig groupConfig = config.getGroupConfig();
        groupConfig.setName("dev");
        groupConfig.setPassword("dev-pass");
        hzClient = HazelcastClient.newHazelcastClient(config);
        map = hzClient.getMap("data");
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println("Key: "+entry.getKey()+", Value: "+ entry.getValue());
        }
    }
}
