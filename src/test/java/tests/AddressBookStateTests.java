package tests;

import model.addressbook.AddressBook;
import model.businesscard.TrustedBusinessCard;
import model.businesscard.UnTrustedBusinessCard;
import org.junit.jupiter.api.Test;
import states.enums.State;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookStateTests {

    AddressBook addressBook = AddressBook.getAddressBook();

    @Test
    void testTrustedBCTransitionToManualApprovedState() {
        TrustedBusinessCard trustedBC_ManualApproved = new TrustedBusinessCard(1, "trusted 1", "Hailanot 23");
        addressBook.addTrustedSource(trustedBC_ManualApproved);
        trustedBC_ManualApproved.printStatus();
        trustedBC_ManualApproved.doAction();
        trustedBC_ManualApproved.printStatus();
        assertEquals(State.MANUAL_APPROVED.name(), trustedBC_ManualApproved.getState().getStateName());
    }

    @Test
    void testUnTrustedBCTransitionToPendingVerificationState() {
        UnTrustedBusinessCard unTrustedBC_PendingVerification = new UnTrustedBusinessCard(2, " untrusted 1", "HaEtrog 14");
        addressBook.addUnTrustedSource(unTrustedBC_PendingVerification);
        unTrustedBC_PendingVerification.printStatus();
        unTrustedBC_PendingVerification.doAction();
        unTrustedBC_PendingVerification.printStatus();
        assertEquals(State.PENDING_VERIFICATION.name(), unTrustedBC_PendingVerification.getState().getStateName());
    }

    @Test
    void testUnTrustedBCTransitionToStrongApprovedState() {
        UnTrustedBusinessCard unTrustedBC_StrongVerification = new UnTrustedBusinessCard(3, " untrusted 2", "Asher Barash 40");
        addressBook.addUnTrustedSource(unTrustedBC_StrongVerification);
        unTrustedBC_StrongVerification.printStatus();
        unTrustedBC_StrongVerification.doAction();
        unTrustedBC_StrongVerification.printStatus();
        unTrustedBC_StrongVerification.doAction();
        unTrustedBC_StrongVerification.printStatus();
        assertEquals(State.STRONG_APPROVED.name(), unTrustedBC_StrongVerification.getState().getStateName());
    }

    @Test
    void testTrustedBCTransitionFromManualApprovedToKnownState() {
        TrustedBusinessCard trustedBC_Known = new TrustedBusinessCard(4, "trusted 2", "HaNeurim 2");
        addressBook.addTrustedSource(trustedBC_Known);
        trustedBC_Known.printStatus();
        trustedBC_Known.doAction();
        trustedBC_Known.printStatus();
        assertEquals(State.MANUAL_APPROVED.name(), trustedBC_Known.getState().getStateName());
        trustedBC_Known.setUnVerify(true);
        trustedBC_Known.doAction();
        trustedBC_Known.printStatus();
        assertEquals(State.KNOWN.name(), trustedBC_Known.getState().getStateName());
    }

}
