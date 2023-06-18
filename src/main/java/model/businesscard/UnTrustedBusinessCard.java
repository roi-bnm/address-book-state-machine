package model.businesscard;

import states.BusinessCardState;
import states.impl.Unknown;

public class UnTrustedBusinessCard extends BusinessCard {

    private BusinessCardState state = new Unknown();

    public UnTrustedBusinessCard(long id, String name, String address) {
        super(id, name, address);
    }

    public void printStatus() {
        state.printBusinessCardState();
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
