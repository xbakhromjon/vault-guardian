package uz.bakhromjon.persistence.common;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SequenceEventListener extends AbstractMongoEventListener<Auditable> {
    private final SequenceGenerator sequenceGenerator;

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Auditable> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(sequenceGenerator.generateSequence(event.getSource().getSequenceName()));
        }
    }
}
