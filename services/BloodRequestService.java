package services;

import java.util.ArrayList;
import models.BloodRequest;

public class BloodRequestService {
    private ArrayList<BloodRequest> requests;

    public BloodRequestService() {
        requests = new ArrayList<>();
    }

    public void createRequest(BloodRequest request) {
        requests.add(request);
        System.out.println("Blood request created successfully!");
    }

    public void viewAllRequests() {
        if (requests.isEmpty()) {
            System.out.println("No blood requests found.");
            return;
        }

        for (BloodRequest request: requests) {
            request.displayRequest();
        }
    }
}