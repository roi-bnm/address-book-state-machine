package states.impl;

import model.businesscard.BusinessCard;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import states.BusinessCardState;
import states.enums.State;

public class Known implements BusinessCardState {

    private static final Logger logger = LogManager.getLogger(Known.class);
    private BusinessCardState stateToMoveTo = new ManualApproved();

    /**
     * In case manual verification failed, we will try to contact address.<br>
     * If we were able to contact the address,
     * then, we'll move the business card to Pending Verification state.<br>
     * In case manual verification passed, then we will move the business card to Manual Approved state.
     * @param businessCard - current processed business card
     */
    @Override
    public void doAction(BusinessCard businessCard) {
        if(!manualVerification() && contactAddress()) {
            logger.info("Business card with ID: " + businessCard.getId() + " failed manual verification. second try of verification." +
                    " Attempting to contact address and moving to Pending Approval state");
            stateToMoveTo = new PendingVerification();
            next(businessCard);
        } else {
            logger.info("Business card with ID: " + businessCard.getId() + " passed manual verification. moving to Manual Approved state");
            next(businessCard);
        }
    }

    @Override
    public void next(BusinessCard businessCard) {
        businessCard.setState(stateToMoveTo);
    }

    @Override
    public void previous(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " in first state - known, can't go previous");
    }

    @Override
    public void printBusinessCardState(BusinessCard businessCard) {
        logger.info("Business card with ID: " + businessCard.getId() + " is in Known state");
    }

    /**
         This method will execute the manual verification.
         For mocking purpose, I'm returning true in order to transition to the desired state
     **/
    private boolean manualVerification() {
        // execute manual verification ...

        return true;
    }

    @Override
    public String getStateName() {
        return State.KNOWN.name();
    }
}
