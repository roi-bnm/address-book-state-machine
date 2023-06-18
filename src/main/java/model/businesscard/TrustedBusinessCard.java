package model.businesscard;

import states.BusinessCardState;
import states.impl.Known;

public class TrustedBusinessCard extends BusinessCard {

    private BusinessCardState state = new Known();

    public TrustedBusinessCard(long id, String name, String address) {
        super(id, name, address);
    }

    public void printStatus() {
        state.printBusinessCardState(this);
    }

    @Override
    public void doAction() {
        state.doAction(this);
    }

    public void setState(BusinessCardState state) {
        this.state = state;
    }

    public BusinessCardState getState() {
        return state;
    }

}
