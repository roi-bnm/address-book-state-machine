package states.impl;

import model.businesscard.BusinessCard;
import model.enums.BusinessCardType;
import states.BusinessCardState;
import states.enums.State;

public class PendingVerification implements BusinessCardState {

    /**
     * In case the business card passed strong verification we will move it to the last state - Strong Approved. <br>
     * In case the strong verification failed, we will check if this business card is untrusted one and do an Abort if it is
     * (Which will move it back to the initial state Unknown).
     * @param businessCard
     */
    @Override
    public void doAction(BusinessCard businessCard) {
        if(strongVerification()) {
            next(businessCard);
        } else if(businessCard.getType().equals(BusinessCardType.UNTRUSTED)) {
            abort(businessCard);
        }
    }

    @Override
    public void next(BusinessCard businessCard) {
        System.out.println("Business card with ID: " + businessCard.getId() + " passed strong verification. moving to last state - Strong Approved");
        businessCard.setState(new StrongApproved());
    }

    @Override
    public void previous(BusinessCard businessCard) {
        System.out.println("Business card with ID: " + businessCard.getId() + " failed strong verification. " +
                "Aborting and moving the untrusted business card to initial state - Unknown");
        businessCard.setState(new Unknown());
    }

    @Override
    public void printBusinessCardState() {
        System.out.println("Current state is PendingVerification");
    }
    /**
        This method will be used to do the strong verification.
        For mocking purpose, I'm returning true in order to transition to the desired state
     **/
    private boolean strongVerification() {
        // Execute strong verification ...

        return true;
    }

    /**
     * This method will abort the flow and will move the business card to the initial state - Unknown.
     * @param businessCard
     */
    private void abort(BusinessCard businessCard) {
        previous(businessCard);
    }

    @Override
    public String getStateName() {
        return State.PENDING_VERIFICATION.name();
    }
}
