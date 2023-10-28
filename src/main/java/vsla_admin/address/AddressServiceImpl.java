package vsla_admin.address;

import org.springframework.stereotype.Service;
import vsla_admin.address.dto.AddressReq;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address createAddress(AddressReq registrationReq) {
        AddressReq.validateAddressReq(registrationReq);

        Address address = Address.builder()
                .country(registrationReq.getCountry())
                .region(registrationReq.getRegion())
                .city(registrationReq.getCity())
                .zone(registrationReq.getZone())
                .woreda(registrationReq.getWoreda())
                .kebele(registrationReq.getKebele())
                .houseNumber(registrationReq.getHouseNumber())
                .build();

        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address, Address updatedAddress) {

        if (updatedAddress.getCountry() != null)
            address.setCountry(updatedAddress.getCountry());

        if (updatedAddress.getRegion() != null)
            address.setRegion(updatedAddress.getRegion());

        if (updatedAddress.getCity() != null)
            address.setCity(updatedAddress.getCity());

        if (updatedAddress.getZone() != null)
            address.setZone(updatedAddress.getZone());

        if (updatedAddress.getWoreda() != null)
            address.setWoreda(updatedAddress.getWoreda());

        if (updatedAddress.getKebele() != null)
            address.setKebele(updatedAddress.getKebele());

        if (updatedAddress.getHouseNumber() != null)
            address.setHouseNumber(updatedAddress.getHouseNumber());

        return addressRepository.save(address);
    }
}
