import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

import java.util.Map;

public class ServerNode {
    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        // Добавим в нашу программу распределённую карту (Map) для хранения данных:
        Map<Long, String> map = hazelcastInstance.getMap("data");

        // Также добавим IdGenerator для того, чтобы id записей были уникальными в нашей «таблице-карте»:
        IdGenerator idGenerator = hazelcastInstance.getIdGenerator("newid");

        // код для добавления, например, 20 записей в таблицу
        for (int i = 0; i < 20; i++) {
            map.put(idGenerator.newId(), "message" + i);
        }

    }
}
