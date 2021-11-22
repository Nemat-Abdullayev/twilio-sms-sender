package az.a2z.clientapn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.InputStream;
import java.security.KeyStore;


@EnableFeignClients
@SpringBootApplication
public class ClientApnApplication {
    private final Logger logger = LoggerFactory.getLogger(ClientApnApplication.class);
    private static final String KEYSTOREPATH = "D:\\A2Z_WORK_DATA\\certificate\\certificate.p12"; // or .p12
    private static final String KEYSTOREPASS = "a2z123123!";
    private static final String KEYPASS = "a2z123123!";

    public KeyStore readStore() throws Exception {
        try (InputStream keyStoreStream = this.getClass().getResourceAsStream(KEYSTOREPATH)) {
            KeyStore keyStore = KeyStore.getInstance("PKCS12"); // or "PKCS12"
            keyStore.load(keyStoreStream, KEYSTOREPASS.toCharArray());
            return keyStore;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApnApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
//            logger.info("client post processing is start");
//
////            System.setProperty("javax.net.ssl.keyStoreType", "JKS");
////            System.setProperty("javax.net.ssl.keyStore", "D:\\A2Z_WORK_DATA\\cert1.jks");
////            System.setProperty("javax.net.ssl.keyStorePassword", "123456");
////            System.setProperty("javax.net.ssl.trustStore", "D:\\A2Z_WORK_DATA\\cert1.jks");
////            System.setProperty("javax.net.ssl.trustStorePassword", "123456");
//
//            String jsonData = "{\n" +
//                    "  \"aps\": {\n" +
//                    "    \"alert\": \"hello\"\n" +
//                    "  }\n" +
//                    "}";
//
//            String topic = "com.a2z.enigma.ios";
//            String TOKEN = "18e6f35f67c47d986544bfd405d429441ce10cd08892317b2e63f83500b5400b";
//
////            ApnsService service =
////                    APNS.newService()
////                            .withCert("D:\\A2Z_WORK_DATA\\certificate\\certificate.p12", "a2z123123!")
////                            .withProductionDestination()
////                            .build();
////
////            String payload = APNS.newPayload()
////                    .customField("apns-topic", "com.a2z.enigma.ios")
////                    .alertBody("This is test message").build();
////            service.push(TOKEN, payload);
//
//            final ApnsClient apnsClient = new ApnsClientBuilder()
//                    .setApnsServer(ApnsClientBuilder.DEVELOPMENT_APNS_HOST)
//                    .setSigningKey(ApnsSigningKey.loadFromPkcs8File(
//                            new File("D:\\A2Z_WORK_DATA\\certificate\\cert.p8"),
//                            "9C39R7BCW2", "6YTUNU2TJJ"))
//                    .build();
//
//            final SimpleApnsPushNotification pushNotification;
//
//            final ApnsPayloadBuilder payloadBuilder = new SimpleApnsPayloadBuilder();
//            payloadBuilder.setAlertBody("Hi, this is test message");
//
//            final String payload = payloadBuilder.build();
//            final String token = TokenUtil.sanitizeTokenString(TOKEN);
//
//            pushNotification = new SimpleApnsPushNotification(token, "com.a2z.enigma.ios ", payload);
//            final PushNotificationFuture<SimpleApnsPushNotification, PushNotificationResponse<SimpleApnsPushNotification>>
//                    sendNotificationFuture = apnsClient.sendNotification(pushNotification);
//
//        try {
//            final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse =
//                    sendNotificationFuture.get();
//
//            if (pushNotificationResponse.isAccepted()) {
//                System.out.println("Push notification accepted by APNs gateway.");
//            } else {
//                System.out.println("Notification rejected by the APNs gateway: " +
//                        pushNotificationResponse.getRejectionReason());
//
//                pushNotificationResponse.getTokenInvalidationTimestamp().ifPresent(timestamp -> {
//                    System.out.println("\t…and the token is invalid as of " + timestamp);
//                });
//            }
//        } catch (final InterruptedException | ExecutionException e) {
//            System.err.println("Failed to send push notification.");
//            e.printStackTrace();
//        }
//
//    }
}
