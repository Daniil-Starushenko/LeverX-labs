package com.leverx.task2.service.initialize.staff;

import com.leverx.task2.entity.Staff;

/**
 * class is needed to create  objects of <code>Staff</code> type
 * to not transfer objects from controller to service by constructor
 * but to make less connectedness
 */
public class StaffFactory {
    public Staff getStaff(StaffType staffType) {
        return staffType.getStaff();
    }
}
