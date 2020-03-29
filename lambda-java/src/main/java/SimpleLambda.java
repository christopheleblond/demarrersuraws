import com.amazonaws.services.lambda.runtime.Context;

public class SimpleLambda {

    public String sayHello(String name, Context context) {
        return String.format("Hello %s", name);
    }
}
