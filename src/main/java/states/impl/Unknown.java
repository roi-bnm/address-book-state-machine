package states.impl;

import model.businesscard.BusinessCard;
import states.BusinessCardState;
import states.enums.State;

public class Unknown implements BusinessCardState {
    @Override
    public void doAction(BusinessCard businessCard) {
        if(contactAddress()) {
            System.out.println("Was able to contact address for business card with ID: " + businessCard.getId()
                    + " .moving to Pending Verification state");
            next(businessCard);
        } else {
            System.out.println("Unable to contact address for businessCard with ID: " + businessCard.getId());
        }

    }

    @Override
    public void next(BusinessCard businessCard) {
        businessCard.setState(new PendingVerification());
    }

    @Override
    public void previous(BusinessCard businessCard) {
        System.out.println("Business card with ID: " + businessCard.getId() + " in first state - Unknown, can't go previous");
    }

    @Override
    public void printBusinessCardState(BusinessCard businessCard) {
        System.out.println("Business card with ID:" + businessCard.getId() + " is in Unknown state");
    }

    @Override
    public String getStateName() {
        return State.UNKNOWN.name();
    }
}
