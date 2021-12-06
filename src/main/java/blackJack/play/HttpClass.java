package blackJack.play;




import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpClass {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localHost", 8001), 0);
        server.createContext("/test");
        server.setExecutor(threadPoolExecutor);
        server.start();
        logger.info(" Server started on port 8001");
    }
}
