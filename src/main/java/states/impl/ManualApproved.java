package states.impl;

import model.businesscard.BusinessCard;
import states.BusinessCardState;
import states.enums.State;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class ManualApproved implements BusinessCardState {

    private static final Logger logger = LogManager.getLogger(ManualApproved.class);
    /**
     * In case there was a request to un-verify the business card, we will move back the business card to the initial state - Known.
     * @param businessCard
     */
    @Override
    public void doAction(BusinessCard businessCard) {
        if(businessCard.isUnVerify()) {
            previous(businessCard);
        }
    }

    @Override
    public void next(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " inside Manual Approved state. last state");
    }

    /**
     * This method will un-verify the business card and move it back to the initial state - Known
     * @param businessCard
     */
    @Override
    public void previous(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " is being un-verified." +
                " moving the trusted business card to the initial state - Known.");
        businessCard.setState(new Known());
    }

    @Override
    public void printBusinessCardState(BusinessCard businessCard) {
        logger.info("Business card with ID:" + businessCard.getId() + " is in Manual Approved state");
    }

    @Override
    public String getStateName() {
        return State.MANUAL_APPROVED.name();
    }
}
