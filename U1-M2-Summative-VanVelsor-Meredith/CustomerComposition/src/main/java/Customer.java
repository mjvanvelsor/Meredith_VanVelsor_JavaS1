public class Customer {

    /*
    This was for composition. Two objects are creating Customer: CustomerContact and Address
    Two Address object classes are used: Shipping + Billing, per instructions.
    Constructors, getters, and setters have all been added to each class.
     */

    // properties
    private CustomerContact info;
    private Address shippingAddress;    // address is user-defined data type, this is address object that hasn't been instantiated.
    private Address billingAddress;     // Address object that has not been instantiated
    private boolean rewardsMember;

    //needed to instantiate in another class since I didn't instantiate in this class
    public Customer() {
    }

    public Customer(CustomerContact info, Address shippingAddress, Address billingAddress, boolean rewardsMember) {
        this.info = info;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.rewardsMember = rewardsMember;
    }

    public CustomerContact getInfo() {
        return info;
    }

    public void setInfo(CustomerContact info) {
        this.info = info;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }
}
