package states.impl;

import model.businesscard.BusinessCard;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import states.BusinessCardState;
import states.enums.State;

public class StrongApproved implements BusinessCardState {
    private static final Logger logger = LogManager.getLogger(StrongApproved.class);

    @Override
    public void doAction(BusinessCard businessCard) {
        // Passed strong verification. Last state. nothing to do.
    }

    @Override
    public void next(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " In final state - Strong Approved. no state to move to.");
    }

    @Override
    public void previous(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " In final state - Strong Approved. no state to go back to.");
    }

    @Override
    public void printBusinessCardState(BusinessCard businessCard) {
        logger.info("Business card with ID:" + businessCard.getId() + " is in Strong Approved state");
    }

    @Override
    public String getStateName() {
        return State.STRONG_APPROVED.name();
    }
}
