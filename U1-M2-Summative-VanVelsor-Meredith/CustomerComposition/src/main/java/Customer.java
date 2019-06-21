public class Customer {

//    Address billingAddress = new Address();
//    Address shippingAddress = new Address();
    /*
    Dalonte said to do this bc I need an object inside of this
    class and not as a variable.
     */

    /*
    This was for composition. Two objects are creating Customer: CustomerContact and Address
    Two Address objects are used: Shipping + Billing, per instructions.
    Constructors
     */

    private CustomerContact info;
    private Address shippingAddress;
    private Address billingAddress;
    private boolean rewardsMember;

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
