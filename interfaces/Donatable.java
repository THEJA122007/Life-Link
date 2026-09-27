package interfaces;

import exceptions.DonorNotAvailableException;

public interface Donatable {
    boolean isAvailable();
    void setAvailable(boolean available);
    void donateBlood(String donationDate) throws DonorNotAvailableException;
}