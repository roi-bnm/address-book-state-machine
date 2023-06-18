package states.impl;

import model.businesscard.BusinessCard;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import states.BusinessCardState;
import states.enums.State;

public class Unknown implements BusinessCardState {
    private static final Logger logger = LogManager.getLogger(Unknown.class);

    /**
     * In case we are able to contact address then we will move the business card to the next state - Pending Verification.<br>
     * In case not, the business card will stay at the initial state Unknown
     * @param businessCard - current processed business card
     */
    @Override
    public void doAction(BusinessCard businessCard) {
        if(contactAddress()) {
            logger.info("Was able to contact address for business card with ID: " + businessCard.getId()
                    + " .moving to Pending Verification state");
            next(businessCard);
        } else {
            logger.info("Unable to contact address for businessCard with ID: " + businessCard.getId());
        }

    }

    @Override
    public void next(BusinessCard businessCard) {
        businessCard.setState(new PendingVerification());
    }

    @Override
    public void previous(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " in first state - Unknown, can't go previous");
    }

    @Override
    public void printBusinessCardState(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " is in Unknown state");
    }

    @Override
    public String getStateName() {
        return State.UNKNOWN.name();
    }
}
