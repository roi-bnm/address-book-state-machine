package states;

import model.businesscard.BusinessCard;

public interface BusinessCardState {

    public void doAction(BusinessCard businessCard);

    public void next(BusinessCard businessCard);

    public void previous(BusinessCard businessCard);

    public void printBusinessCardState();

    String getStateName();

    /**
        This method is set as default as it is being executed by 2 states.
        For mock purpose, I'm returning success, so I can transition to the desired state
     **/
    default boolean contactAddress() {
        // Contacting contact process

        return true;
    }
}
