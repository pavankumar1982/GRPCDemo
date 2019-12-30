package grpcdemo.test.server;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import grpcdemo.test.generated.Greeting;
import grpcdemo.test.generated.HelloWorldServiceGrpc;
import grpcdemo.test.generated.Person;
import io.grpc.stub.StreamObserver;

@GRpcService
public class HelloWorldServer extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldServer.class);
	
	@Override
	public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
		LOGGER.info("server received {}", request);
		String message = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";
		
		Greeting greeting = Greeting.newBuilder().setMessage(message).build();
		LOGGER.info("server responded {}", greeting);
		
		responseObserver.onNext(greeting);
		responseObserver.onCompleted();
	}
}