package ch.mhaspra.insurancecase.icpartnersender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PartnerDataStreamBridge {
    private final StreamBridge streamBridge;

    @Autowired
    public PartnerDataStreamBridge(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void send(Partner partner){
        var message = MessageBuilder
                .withPayload(partner)
                .setHeader(KafkaHeaders.KEY, partner.partnerNr())
                .build();
        streamBridge.send("partner-data-out", message);
    }

}
