package model.addressbook;

import model.businesscard.BusinessCard;
import model.businesscard.TrustedBusinessCard;
import model.businesscard.UnTrustedBusinessCard;
import model.enums.BusinessCardType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import states.impl.Known;
import states.impl.Unknown;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private static final Logger logger = LogManager.getLogger(AddressBook.class);
    private static AddressBook addressBook;
    private final List<BusinessCard> businessCards = new ArrayList<>();

    private AddressBook(){};

    public static synchronized AddressBook getAddressBook() {
        if(addressBook == null) {
            synchronized (AddressBook.class) {
                if (addressBook == null) {
                    addressBook = new AddressBook();
                }
            }
        }
        return addressBook;
    }

    public void addTrustedSource(TrustedBusinessCard trustedBusinessCard) {
        trustedBusinessCard.setType(BusinessCardType.TRUSTED);
        trustedBusinessCard.setState(new Known());
        businessCards.add(trustedBusinessCard);
    }

   public void addUnTrustedSource(UnTrustedBusinessCard unTrustedBusinessCard) {
        unTrustedBusinessCard.setType(BusinessCardType.UNTRUSTED);
        unTrustedBusinessCard.setState(new Unknown());
        businessCards.add(unTrustedBusinessCard);
    }

    public void printAddressBook() {
        businessCards.forEach(businessCard -> {
            logger.info("Business Card details: ID: " + businessCard.getId()
                             + " , name: " + businessCard.getName()
                             + " , address: " + businessCard.getAddress()
                             + " , type: " + businessCard.getType().name()
                             + " , current state: " + businessCard.getState().getStateName());
        });
    }

    public List<BusinessCard> getBusinessCards() {
        return businessCards;
    }
}
