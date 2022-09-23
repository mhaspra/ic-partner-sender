package ch.mhaspra.insurancecase.icpartnersender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Component
public class PartnerDataGenerator {
    private final PartnerDataStreamBridge partnerDataStreamBridge;

    @Autowired
    public PartnerDataGenerator(PartnerDataStreamBridge partnerDataStreamBridge) {
        this.partnerDataStreamBridge = partnerDataStreamBridge;
    }

    //Only fire once, we simulate only contract changes for now
    @Scheduled(initialDelay = 5000L, fixedRate = Long.MAX_VALUE)
    void send(){
        LongStream.range(1, 21).forEach(this::sendPartner);
    }

    private void sendPartner(Long partnerNr) {
        var partner = new Partner(partnerNr,"Partner-" + partnerNr, true);
        partnerDataStreamBridge.send(partner);
    }
}
