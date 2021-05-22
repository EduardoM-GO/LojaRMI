import java.util.*;

class TesteGetProperties {
    public static void main (String[] args) {
        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            System.out.println (entry.getKey() + "="+ entry.getValue());
        }
    }
}