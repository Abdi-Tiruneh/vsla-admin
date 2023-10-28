package vsla_admin.address;


import vsla_admin.address.dto.AddressReq;

public interface AddressService {
    Address saveAddress(Address address);

    Address createAddress(AddressReq registrationReq);

    Address updateAddress(Address address, Address updatedAddress);
}
