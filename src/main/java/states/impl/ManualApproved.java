package states.impl;

import model.businesscard.BusinessCard;
import states.BusinessCardState;
import states.enums.State;

public class ManualApproved implements BusinessCardState {

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
        System.out.println("Business card with ID: " + businessCard.getId() + " inside manual approved. last state");
    }

    /**
     * This method will un-verify the business card and move it back to the initial state - Known
     * @param businessCard
     */
    @Override
    public void previous(BusinessCard businessCard) {
        System.out.println("Business card with ID: " + businessCard.getId() + " is being un-verified." +
                " moving the trusted business card to the initial state - Known.");
        businessCard.setState(new Known());
    }

    @Override
    public void printBusinessCardState() {
        System.out.println("Current state is Manual Approved");
    }

    @Override
    public String getStateName() {
        return State.MANUAL_APPROVED.name();
    }
}
