package states.impl;

import model.businesscard.BusinessCard;
import states.BusinessCardState;
import states.enums.State;

public class StrongApproved implements BusinessCardState {
    @Override
    public void doAction(BusinessCard businessCard) {
        // Passed strong verification. Last state. nothing to do.
    }

    @Override
    public void next(BusinessCard businessCard) {
        System.out.println("Business card with ID: " + businessCard.getId() + " In final state - Strong Approved. no state to move to.");
    }

    @Override
    public void previous(BusinessCard businessCard) {
        System.out.println("Business card with ID: " + businessCard.getId() + " In final state - Strong Approved. no state to go back to.");
    }

    @Override
    public void printBusinessCardState() {
        System.out.println("Current state is Strong Approved");
    }

    @Override
    public String getStateName() {
        return State.STRONG_APPROVED.name();
    }
}
