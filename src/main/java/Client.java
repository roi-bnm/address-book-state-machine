import model.addressbook.AddressBook;
import model.businesscard.TrustedBusinessCard;
import model.businesscard.UnTrustedBusinessCard;

public class Client {
    static AddressBook addressBook = AddressBook.getAddressBook();

    public static void main(String[] args) {
        System.out.println(" ********* Trusted business cards *********");
        addTrustedBusinessCards();
        System.out.println(" ********* UnTrusted business cards *********");
        addUnTrustedBusinessCards();
        System.out.println(" ********* Address Book *********");
        addressBook.printAddressBook();
    }

    private static void addTrustedBusinessCards() {
        TrustedBusinessCard trustedBC_ManualApproved = new TrustedBusinessCard(1, "trusted 1", "Hailanot 23");
        addressBook.addTrustedSource(trustedBC_ManualApproved);
        trustedBC_ManualApproved.printStatus();
        trustedBC_ManualApproved.doAction();
        trustedBC_ManualApproved.printStatus();
    }

    private static void addUnTrustedBusinessCards() {
        UnTrustedBusinessCard unTrustedBC_PendingVerification = new UnTrustedBusinessCard(2, " untrusted 1", "HaEtrog 14");
        addressBook.addUnTrustedSource(unTrustedBC_PendingVerification);
        unTrustedBC_PendingVerification.printStatus();
        unTrustedBC_PendingVerification.doAction();
        unTrustedBC_PendingVerification.printStatus();

        System.out.println("******");

        UnTrustedBusinessCard unTrustedBC_StrongVerification = new UnTrustedBusinessCard(3, " untrusted 2", "Asher Barash 40");
        addressBook.addUnTrustedSource(unTrustedBC_StrongVerification);
        unTrustedBC_StrongVerification.printStatus();
        unTrustedBC_StrongVerification.doAction();
        unTrustedBC_StrongVerification.printStatus();
        unTrustedBC_StrongVerification.doAction();
        unTrustedBC_StrongVerification.printStatus();
    }
}
