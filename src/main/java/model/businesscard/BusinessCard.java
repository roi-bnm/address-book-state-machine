package model.businesscard;

import model.enums.ActionResult;
import model.enums.BusinessCardType;
import states.BusinessCardState;

public abstract class BusinessCard {
    private BusinessCardState state;
    private long id;
    private String name;
    private String address;
    private boolean unVerify;
    private BusinessCardType type;
    private ActionResult currentActionResult;

    public BusinessCard(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    abstract public void printStatus();

    abstract public void doAction();

    public void setState(BusinessCardState state) {
        this.state = state;
    }

    public BusinessCardState getState() {
        return state;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public boolean isUnVerify() {
        return unVerify;
    }

    public void setUnVerify(boolean unverify) {
        this.unVerify = unverify;
    }

    public BusinessCardType getType() {
        return type;
    }

    public void setType(BusinessCardType type) {
        this.type = type;
    }
}
